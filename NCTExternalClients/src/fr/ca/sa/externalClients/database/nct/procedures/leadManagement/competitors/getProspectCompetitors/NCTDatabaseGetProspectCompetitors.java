package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.competitors.getProspectCompetitors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LeadManagementCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting prospect competitors
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetProspectCompetitors extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetProspectCompetitors.class);

	private int prospectId;

	/**
	 * NCT Database Get Prospect Competitors
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 */
	public NCTDatabaseGetProspectCompetitors(int userId, int prospectId) {
		super(userId);
		this.prospectId = prospectId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetProspectCompetitors ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.prospectId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetProspectCompetitorsNCTResultList retList = new GetProspectCompetitorsNCTResultList();

		try {
			while (this.getResultSet().next()) {
				retList.getProspectCompetitors().add(new GetProspectCompetitorsNCTResultItem(
						this.getResultSet().getInt("CompetitorId"), this.getResultSet().getString("CompetitorName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_GET_PROSPECT_DATA);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_GET_PROSPECT_DATA);
	}

}
