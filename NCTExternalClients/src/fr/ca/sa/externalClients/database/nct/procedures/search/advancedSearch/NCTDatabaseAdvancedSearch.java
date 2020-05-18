package fr.ca.sa.externalClients.database.nct.procedures.search.advancedSearch;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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
import fr.ca.sa.nct.commons.services.json.search.AdvancedSearchFilter;

/**
 * 
 * SP handler for advanced search
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseAdvancedSearch extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseAdvancedSearch.class);

	private int bankId;
	private AdvancedSearchFilter filter;

	/**
	 * default constructor for NCT Database Advanced Search
	 */
	public NCTDatabaseAdvancedSearch() {
		super();
	}

	/**
	 * NCT Database Advanced Search
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param bankId
	 * 				Bank ID
	 * 
	 * @param filter
	 * 				Filter
	 */
	public NCTDatabaseAdvancedSearch(int userId, int bankId, AdvancedSearchFilter filter) {
		super(userId);
		this.bankId = bankId;
		this.filter = filter;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection
				.prepareStatement("exec spGetSearchedUserDetails ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.bankId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, NCTDatabaseConstants.getSearchTypeAdvanced());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, NCTSystemConstants.getUserSearchLimit());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.filter.isWithoutLeads() ? 1 : 0);
			ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.VARCHAR);
	
			if (this.filter.getClientType() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.filter.getClientType());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_7, Types.INTEGER);
			}
	
			if (this.filter.getBank() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_8, this.filter.getBank());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_8, Types.INTEGER);
			}
	
			if (this.filter.getRegion() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_9, this.filter.getRegion());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_9, Types.INTEGER);
			}
	
			if (this.filter.getMainBranch() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_10, this.filter.getMainBranch());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_10, Types.INTEGER);
			}
	
			if (this.filter.getBranch() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_11, this.filter.getBranch());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_11, Types.NVARCHAR);
			}
			if (this.filter.getAdvisor() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_12, this.filter.getAdvisor());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_12, Types.INTEGER);
			}
	
			if (this.filter.getFirstName() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_13, this.filter.getFirstName());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_13, Types.NVARCHAR);
			}
	
			if (this.filter.getLastName() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_14, this.filter.getLastName());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_14, Types.NVARCHAR);
			}
			if (this.filter.getCustomerId() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_15, this.filter.getCustomerId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_15, Types.NVARCHAR);
			}
			if (this.filter.getBirthDate() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_16, this.filter.getBirthDate());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_16, Types.NVARCHAR);
			}
			if (this.filter.getAccountNb() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_17, this.filter.getAccountNb());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_17, Types.NVARCHAR);
			}
			if (this.filter.getZipCode() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_18, this.filter.getZipCode());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_18, Types.NVARCHAR);
			}
			if (this.filter.getCity() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_19, this.filter.getCity());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_19, Types.NVARCHAR);
			}
			if (this.filter.getCountry() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_20, this.filter.getCountry());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_20, Types.NVARCHAR);
			}
	
			if (this.filter.getMobilePhone() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_21, this.filter.getMobilePhone());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_21, Types.NVARCHAR);
			}
	
			if (this.filter.getSegment() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_22, this.filter.getSegment());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_22, Types.INTEGER);
			}
	
			if (this.filter.getLastContactDate() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_23, this.filter.getLastContactDate());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_23, Types.NVARCHAR);
			}
			if (this.filter.getEmail() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_24, this.filter.getEmail());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_24, Types.NVARCHAR);
			}
			if (this.filter.getClientOrigin() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_25, this.filter.getClientOrigin());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_25, Types.INTEGER);
			}
			if (this.filter.getAddress() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_26, this.filter.getAddress());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_26, Types.NVARCHAR);
			}
			if (this.filter.getClientCodeTypeId() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_27, this.filter.getClientCodeTypeId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_27, Types.NVARCHAR);
			}
			if (this.filter.getExternalId() != null) {
				ps.setLong(NCTDatabaseConstants.SP_ARG_NR_28, this.filter.getExternalId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_28, Types.BIGINT);
			}
			if (this.filter.getRcNumber() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_29, this.filter.getRcNumber());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_29, Types.NVARCHAR);
			}
			if (this.filter.getPassport() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_30, this.filter.getPassport());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_30, Types.NVARCHAR);
			}
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
