package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.startJobFlowExecution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for starting job flow execution
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseStartJobFlowExecution extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseStartJobFlowExecution.class);

	private int jobExecutionId;
	private int flowId;

	/**
	 * default constructor for NCT Database Start Job Flow Execution
	 */
	public NCTDatabaseStartJobFlowExecution() {
		super();
	}

	/**
	 * NCT Database Start Job Flow Execution
	 * 
	 * @param jobExecutionId
	 * 				Job execution ID
	 * 
	 * @param flowId
	 * 				Flow ID
	 */
	public NCTDatabaseStartJobFlowExecution(int jobExecutionId, int flowId) {
		super();
		this.jobExecutionId = jobExecutionId;
		this.flowId = flowId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batchTrace.spStartJobFlowExecution ?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jobExecutionId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.flowId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		StartJobFlowExecutionNCTResultItem retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue = new StartJobFlowExecutionNCTResultItem(this.getResultSet().getInt("JobFlowExecutionId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new BatchProcessingOperationException(ErrorConstants.ERROR_MSG_FAILED_SQL_STATEMENT);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		LOGGER.error(ex);
		throw new BatchProcessingOperationException(ErrorConstants.ERROR_MSG_FAILED_SQL_STATEMENT);
	}
}
