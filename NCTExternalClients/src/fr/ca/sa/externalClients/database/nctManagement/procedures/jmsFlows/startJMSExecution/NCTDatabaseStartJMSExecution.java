package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.startJMSExecution;

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
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting jms flows
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseStartJMSExecution extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseStartJMSExecution.class);

	private int jmsId;
	private String messageId;
	private String correlationId;

	/**
	 * default constructor for NCT Database Start JMS Execution
	 */
	public NCTDatabaseStartJMSExecution() {
		super();
	}

	/**
	 * NCT Database Start JMS Execution
	 * 
	 * @param jmsId
	 * 				JMS ID
	 * 
	 * @param messageId
	 * 				Message ID
	 * 
	 * @param correlationId
	 * 				Correlation ID
	 */
	public NCTDatabaseStartJMSExecution(int jmsId, String messageId, String correlationId) {
		super();
		this.jmsId = jmsId;
		this.messageId = messageId;
		this.correlationId = correlationId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batchTrace.spStartJmsExecution ?,?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jmsId);
		
			if (this.messageId != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_2, this.messageId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.VARCHAR);
			}
	
			if (this.correlationId != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.correlationId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.VARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		StartJMSExecutionNCTResultItem retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue = new StartJMSExecutionNCTResultItem(this.getResultSet().getInt("JmsExecutionId"),
						this.getResultSet().getInt("PreviousJmsExecutionInProgress"));
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
