package fr.ca.sa.externalClients.database.nct.procedures.search.quickSearch;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SearchFailedException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nct.procedures.search.SearchNCTResultItem;
import fr.ca.sa.externalClients.database.nct.procedures.search.SearchNCTResultList;
import fr.ca.sa.model.Collaborator;
import fr.ca.sa.model.Client;
import fr.ca.sa.model.Entity;
import fr.ca.sa.model.IdName;
import fr.ca.sa.nct.commons.NCTSystemConstants;

/**
 * 
 * SP handling for quick search
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseQuickSearch extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseQuickSearch.class);

	private int bankId;
	private String needle;

	/**
	 * default constructor for NCT Database Quick Search
	 */
	public NCTDatabaseQuickSearch() {
		super();
	}

	/**
	 * NCT Database Quick Search
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param bankId
	 * 				Bank ID
	 * 
	 * @param needle
	 * 				Needle
	 * 				
	 */
	public NCTDatabaseQuickSearch(int userId, int bankId, String needle) {
		super(userId);
		this.bankId = bankId;
		this.needle = needle;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetSearchedUserDetails ?,?,?,?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.bankId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, NCTDatabaseConstants.getSearchTypeQuick());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, NCTSystemConstants.getUserSearchLimit());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, NCTDatabaseConstants.getSearchLeadsEnabled());
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_6, this.needle);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}				
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SearchNCTResultList retList = new SearchNCTResultList();
		try {
			while (this.getResultSet().next()) {
				if (retList.getTotalRecordCount() == 0) {
					retList.setTotalRecordCount(this.getResultSet().getInt("RecordCount"));
				}
				
				Collaborator lastContactAdvisor = new Collaborator();
				lastContactAdvisor.setName(this.getResultSet().getString("LastContactAdvisorName"));
				
				Entity entity = new Entity(this.getResultSet().getInt("EntityId"), null, null, this.getResultSet().getString("BranchName"));
				
				Client client = new Client(this.getResultSet().getInt("ClientId"),
						this.getResultSet().getString("Name"), 
						entity,						
						this.getResultSet().getInt("PortfolioId"),
						this.getResultSet().getString("ClientCode"));
				
				client.setLastName(this.getResultSet().getString("Surname"));
				client.setType(new IdName(null, this.getResultSet().getString("TypeOfClient")));
				client.setClientOrLead(this.getResultSet().getString("C_L"));
				client.setCityName(this.getResultSet().getString("CityName"));
				client.setMobilePhone(this.getResultSet().getString("MobilePhone"));
				client.setSegment(this.getResultSet().getString("Segment"));

				Date dateOfLastContact = this.getResultSet().getDate("DateOfLastContact");
				if (dateOfLastContact != null) {
					DateFormat df = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
					client.setDateOfLastContact(df.format(dateOfLastContact));
				}
								
				client.setLastContactCollaborator(lastContactAdvisor);
				client.setEmail(this.getResultSet().getString("Email"));
				client.setActive(this.getResultSet().getInt("Active") == 1);
				
				retList.getSearchResults().add(new SearchNCTResultItem(client));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SearchFailedException();
		}
		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SearchFailedException();

	}
}
