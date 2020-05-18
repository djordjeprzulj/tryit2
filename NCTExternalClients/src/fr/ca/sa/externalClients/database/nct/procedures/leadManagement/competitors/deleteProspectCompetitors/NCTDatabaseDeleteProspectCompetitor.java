package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.competitors.deleteProspectCompetitors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LeadManagementCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for deleting prospects competitor
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseDeleteProspectCompetitor extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseDeleteProspectCompetitor.class);

	private int prospectId;

	/**
	 * NCT Database Delete Prospect Competitor
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 */
	public NCTDatabaseDeleteProspectCompetitor(int userId, int prospectId) {
		super(userId);
		this.prospectId = prospectId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spDeleteProspectCompetitors ?,?");
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
		DeleteProspectCompetitorsNCTResultItem retValue = null;

		try {
			while (this.getResultSet().next()) {
				retValue = new DeleteProspectCompetitorsNCTResultItem(this.getResultSet().getInt("ProspectId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_SET_PROSPECT);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_SET_PROSPECT);
	}

}
