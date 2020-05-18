package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.startJMSFlowExecution;

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
 * Store procedure handler for getting jms flows
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseStartJMSFlowExecution extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseStartJMSFlowExecution.class);

	private int jmsExecutionId;
	private int flowId;

	/**
	 * default constructor for NCT Database Start JMS Flow Execution
	 */
	public NCTDatabaseStartJMSFlowExecution() {
		super();
	}

	/**
	 * NCT Database Start JMS Flow Execution
	 * 
	 * @param jmsExecutionId
	 * 				JMS execution ID
	 * 
	 * @param flowId
	 * 				FLow ID
	 */
	public NCTDatabaseStartJMSFlowExecution(int jmsExecutionId, int flowId) {
		super();
		this.jmsExecutionId = jmsExecutionId;
		this.flowId = flowId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batchTrace.spStartJmsFlowExecution ?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jmsExecutionId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.flowId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		StartJMSFlowExecutionNCTResultItem retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue = new StartJMSFlowExecutionNCTResultItem(this.getResultSet().getInt("JmsFlowExecutionId"));
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
