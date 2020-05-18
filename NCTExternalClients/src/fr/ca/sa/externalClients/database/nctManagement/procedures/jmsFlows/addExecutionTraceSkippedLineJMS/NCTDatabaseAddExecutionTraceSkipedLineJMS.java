package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.addExecutionTraceSkippedLineJMS;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for tracing jms flow processing skipped lines
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseAddExecutionTraceSkipedLineJMS extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseAddExecutionTraceSkipedLineJMS.class);
	
	private int jmsFlowExecutionId;
	private int lineOrderNumber;
	private String errorMessage;

	/**
	 * default constructor for NCT Database Add Execution Trace Skiped Line JMS
	 */
	public NCTDatabaseAddExecutionTraceSkipedLineJMS() {
		super();
	}

	/**
	 * NCT Database Add Execution Trace Skiped Line JMS
	 * 
	 * @param jmsFlowExecutionId
	 * 				JMS flow execution ID
	 * 
	 * @param lineOrderNumber
	 * 				Line order number
	 * 
	 * @param errorMessage
	 * 				Error message
	 */
	public NCTDatabaseAddExecutionTraceSkipedLineJMS(int jmsFlowExecutionId, int lineOrderNumber, String errorMessage) {
		super();
		this.jmsFlowExecutionId = jmsFlowExecutionId;
		this.lineOrderNumber = lineOrderNumber;
		this.errorMessage = errorMessage;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement ps = connection.prepareCall("exec batchTrace.spAddExecutionTraceSkippedLineJMS ?,?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jmsFlowExecutionId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.lineOrderNumber);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.errorMessage);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new BatchProcessingOperationException(ex.getMessage(),ex.getCause());
	}

}
