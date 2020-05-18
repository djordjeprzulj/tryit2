package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowTraceByExecutionId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetFlowTraceByExecutionId extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetFlowTraceByExecutionId.class);

	private Integer jobExecutionId;
	private Integer jobFlowExecutionId;

	/**
	 * default constructor for NCT Database Get Flow Trace By Execution ID
	 */
	public NCTDatabaseGetFlowTraceByExecutionId() {
		super();
	}

	/**
	 * NCT Database Get Flow Trace By Execution ID
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param jobExecutionId
	 * 				Job execution ID
	 * 
	 * @param jobFlowExecutionId
	 * 				Job flow execution ID
	 */
	public NCTDatabaseGetFlowTraceByExecutionId(int userId, Integer jobExecutionId, Integer jobFlowExecutionId) {
		super(userId);
		this.jobExecutionId = jobExecutionId;
		this.jobFlowExecutionId = jobFlowExecutionId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batchTrace.spGetJobTraceByExecutionId ?,?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.userId);
	
			if (this.jobExecutionId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.jobExecutionId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
	
			if (this.jobFlowExecutionId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.jobFlowExecutionId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetFlowTraceByExecutionIdNCTResultList retList = new GetFlowTraceByExecutionIdNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getFlowTrace()
						.add(new GetFlowTraceByExecutionIdNCTResultItem(this.getResultSet().getInt("JobId"),
								this.getResultSet().getString("JobName"), this.getResultSet().getString("FlowName"),
								this.getResultSet().getTimestamp("TraceTimeStamp"),
								this.getResultSet().getString("JobExecutionCurrentStatus"),
								this.getResultSet().getString("FlowExecutionCurrentStatus"),
								this.getResultSet().getString("TraceDescription")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new BatchProcessingOperationException(ErrorConstants.ERROR_MSG_FAILED_SQL_STATEMENT);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		LOGGER.error(ex);
		throw new BatchProcessingOperationException(ErrorConstants.ERROR_MSG_FAILED_SQL_STATEMENT);
	}

}
