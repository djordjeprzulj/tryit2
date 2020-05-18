package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.changeProspectStatus;

import java.sql.CallableStatement;
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
import fr.ca.sa.nct.commons.services.json.leadManagement.ChangeProspectStatusRequest;

/**
 * 
 * Store procedure handler for changing prospect status
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseChangeProspectStatus extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseChangeProspectStatus.class);
	
	private ChangeProspectStatusRequest req;

	/**
	 * NCT Database Change Prospect Status
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param req
	 * 				Request
	 */
	public NCTDatabaseChangeProspectStatus(int userId, ChangeProspectStatusRequest req) {
		super(userId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		CallableStatement cs = connection.prepareCall("exec spChangeProspectStatus ?,?,?,?,?");
		try {
			setUser(cs);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getProspectId());
	
			if (this.req.getClientId() != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.req.getClientId());
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_3, java.sql.Types.INTEGER);
			}
	
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.req.getNewStatusId());
			cs.setString(NCTDatabaseConstants.SP_ARG_NR_5, this.req.getChangeDate());
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}

		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_SET_PROSPECT);
	}
}
