package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.setJobFlows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store Procedure for storing job flows
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseSetJobFlows extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetJobFlows.class);

	private int jobId;
	private int flowId;

	/**
	 * NCT Database Set Job Flows
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param jobId
	 * 				Job ID
	 * 
	 * @param flowId
	 * 				Flow ID
	 */
	public NCTDatabaseSetJobFlows(int userId, int jobId, int flowId) {
		super(userId);
		this.jobId = jobId;
		this.flowId = flowId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec batch.spSetJobFlows ?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.jobId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.flowId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetJobFlowsNCTResultItem retValue = null;

		try {
			while (this.getResultSet().next()) {
				retValue = new SetJobFlowsNCTResultItem(this.getResultSet().getInt("FlowId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new BatchCRUDException(ErrorConstants.ERROR_MSG_SET_JOB_FLOWS);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchCRUDException(ErrorConstants.ERROR_MSG_SET_JOB_FLOWS);
	}
}
