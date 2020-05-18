package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobSkipTraceByExecutionId;

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
public class NCTDatabaseGetJobSkipTraceByExecutionId extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetJobSkipTraceByExecutionId.class);

	private Integer jobExecutionId;
	private Integer jobFlowExecutionId;

	/**
	 * default constructor for NCT Database Get Job Skip Trace By Execution ID
	 */
	public NCTDatabaseGetJobSkipTraceByExecutionId() {
		super();
	}

	/**
	 * NCT Database Get Job Skip Trace By Execution ID
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param jobExecutionId
	 * 				Job execution ID
	 * 
	 * @param jobFlowExecutionId
	 * 				Flow execution ID
	 */
	public NCTDatabaseGetJobSkipTraceByExecutionId(int userId, Integer jobExecutionId, Integer jobFlowExecutionId) {
		super(userId);
		this.jobExecutionId = jobExecutionId;
		this.jobFlowExecutionId = jobFlowExecutionId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batchTrace.spGetJobSkipTraceByExecutionId ?,?,?");
		try {
			setUser(ps);
	
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
		GetJobSkipTraceByExecutionIdNCTResultList retList = new GetJobSkipTraceByExecutionIdNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getJobSkipTraces().add(new GetJobSkipTraceByExecutionIdNCTResultItem(
						this.getResultSet().getInt("JobId"), this.getResultSet().getString("JobName"),
						this.getResultSet().getString("FlowName"), this.getResultSet().getTimestamp("SkipTimeStamp"),
						this.getResultSet().getInt("SkipLine"), this.getResultSet().getString("SkipDescription")));
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
