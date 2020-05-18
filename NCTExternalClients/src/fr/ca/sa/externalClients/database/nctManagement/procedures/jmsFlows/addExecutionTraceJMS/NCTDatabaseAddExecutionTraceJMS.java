package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.addExecutionTraceJMS;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for tracing jms flow processing summary
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseAddExecutionTraceJMS extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseAddExecutionTraceJMS.class);
	
	private int jmsExecutionId;
	private Integer jmsFlowExecutionId;
	private int executionStatusId;
	private String description;

	/**
	 * default constructor for NCT Database Add Execution Trace JMS
	 */
	public NCTDatabaseAddExecutionTraceJMS() {
		super();
	}


	/**
	 * NCT Database Add Execution Trace JMS
	 * 
	 * @param jmsExecutionId
	 * 				JMS execution ID
	 * 
	 * @param jmsFlowExecutionId
	 * 				JMS flow execution ID
	 * 
	 * @param executionStatusId
	 * 				Execution status ID
	 * 
	 * @param description
	 * 				Description
	 */
	public NCTDatabaseAddExecutionTraceJMS(int jmsExecutionId, Integer jmsFlowExecutionId, int executionStatusId,
			String description) {
		super();
		this.jmsExecutionId = jmsExecutionId;
		this.jmsFlowExecutionId = jmsFlowExecutionId;
		this.executionStatusId = executionStatusId;
		this.description = description;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement ps = connection.prepareCall("exec batchTrace.spAddExecutionTraceJMS ?,?,?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jmsExecutionId);
			if (this.jmsFlowExecutionId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.jmsFlowExecutionId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.executionStatusId);
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.description);
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
		throw new BatchProcessingOperationException(ex.getMessage(), ex.getCause());
	}

}
