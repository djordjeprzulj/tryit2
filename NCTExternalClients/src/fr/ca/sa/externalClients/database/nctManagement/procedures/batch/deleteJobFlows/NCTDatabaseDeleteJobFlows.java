package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.deleteJobFlows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for deleting batch job flows
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseDeleteJobFlows extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseDeleteJobFlows.class);

	private int jobId;

	/**
	 * NCT Database Delete Job Flows
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param jobId
	 * 				Job ID
	 */
	public NCTDatabaseDeleteJobFlows(int userId, Integer jobId) {
		super(userId);
		this.jobId = jobId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batch.spDeleteJobFlows ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.jobId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		DeleteJobFlowsNCTResultItem retValue = new DeleteJobFlowsNCTResultItem();

		try {
			while (this.getResultSet().next()) {
				retValue.setJobId(this.getResultSet().getInt("JobId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new BatchCRUDException(ErrorConstants.ERROR_MSG_DELETE_JOB_FLOWS);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchCRUDException(ErrorConstants.ERROR_MSG_DELETE_JOB_FLOWS);
	}
}
