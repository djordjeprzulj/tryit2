package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.addExecutionTraceSkippedLine;

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
 * Store procedure handler for tracing batch processing skipped lines
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseAddExecutionTraceSkipedLine extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseAddExecutionTraceSkipedLine.class);
	
	private int jobFlowExecutionId;
	private int lineOrderNumber;
	private String errorMessage;

	/**
	 * default constructor for NCT Database Add Execution Trace Skiped Line
	 */
	public NCTDatabaseAddExecutionTraceSkipedLine() {
		super();
	}

	/**
	 * NCT Database Add Execution Trace Skiped Line
	 * 
	 * @param jobFlowExecutionId
	 * 				Job flow execution ID
	 * 
	 * @param lineOrderNumber
	 * 				Line order number
	 * 
	 * @param errorMessage
	 * 				Error message
	 */
	public NCTDatabaseAddExecutionTraceSkipedLine(int jobFlowExecutionId, int lineOrderNumber, String errorMessage) {
		super();
		this.jobFlowExecutionId = jobFlowExecutionId;
		this.lineOrderNumber = lineOrderNumber;
		this.errorMessage = errorMessage;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement ps = connection.prepareCall("exec batchTrace.spAddExecutionTraceSkippedLine ?,?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jobFlowExecutionId);
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
