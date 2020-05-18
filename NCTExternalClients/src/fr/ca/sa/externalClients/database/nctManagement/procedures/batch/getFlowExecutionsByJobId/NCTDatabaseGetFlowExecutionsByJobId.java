package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowExecutionsByJobId;

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
 * Store procedure handler for getting flow executions for job ID
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetFlowExecutionsByJobId extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetFlowExecutionsByJobId.class);

	private int jobExecutionId;

	/**
	 * default constructor for NCT Database Get Flow Executions By Job Id
	 */
	public NCTDatabaseGetFlowExecutionsByJobId() {
		super();
	}

	/**
	 * NCT Database Get Flow Executions By Job Id
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param jobExecutionId
	 * 				Job execution ID
	 */
	public NCTDatabaseGetFlowExecutionsByJobId(int userId, int jobExecutionId) {
		super(userId);
		this.jobExecutionId = jobExecutionId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batchTrace.spGetFlowExecutionsByJobId ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.jobExecutionId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetFlowExecutionsByJobIdNCTResultList retList = new GetFlowExecutionsByJobIdNCTResultList();

		try {
			while (this.getResultSet().next()) {
				retList.getFlowExecutions().add(new GetFlowExecutionsByJobIdNCTResultItem(
						this.getResultSet().getInt("FlowId"), this.getResultSet().getString("FlowName"),
						this.getResultSet().getString("FileName"), this.getResultSet().getInt("SkipLimit"),
						this.getResultSet().getInt("RetryLimit"), this.getResultSet().getInt("JobExecutionId"),
						this.getResultSet().getString("JobFlowExecutionId"), this.getResultSet().getInt("RecordCount"),
						this.getResultSet().getInt("ReadCount"), this.getResultSet().getInt("ReadSkipCount"),
						this.getResultSet().getInt("WriteCount"), this.getResultSet().getInt("WriteSkipCount"),
						this.getResultSet().getString("FlowExecutionCurrentStatus"),
						this.getResultSet().getTimestamp("StartTime"), this.getResultSet().getTimestamp("EndTime"),
						this.getResultSet().getString("ExitMessage"), this.getResultSet().getInt("ErrorOccurred"),
						this.getResultSet().getInt("TransferInProgress"), this.getResultSet().getInt("OnlySkippedRows"),
						this.getResultSet().getTimestamp("LastUpdate")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new BatchCRUDException(ErrorConstants.ERROR_MSG_GET_FLOW_EXECUTIONS_BY_JOB_ID);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchCRUDException(ErrorConstants.ERROR_MSG_GET_FLOW_EXECUTIONS_BY_JOB_ID);
	}

}
