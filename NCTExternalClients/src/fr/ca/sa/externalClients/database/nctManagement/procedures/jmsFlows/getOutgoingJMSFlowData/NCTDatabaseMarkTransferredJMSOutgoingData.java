package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.getOutgoingJMSFlowData;

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
 * Store procedure handler for marking transferred outgoing data
 * 
 * @author Milivoj Bozic
 *
 */
public class NCTDatabaseMarkTransferredJMSOutgoingData extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseMarkTransferredJMSOutgoingData.class);
	
	private static final int JMS_TYPE = 2;

	private int jmsExecutionId;
	private int flowExecutionId;

	/**
	 * default constructor for NCT Database Mark Transferred JMS Outgoing Data
	 */
	public NCTDatabaseMarkTransferredJMSOutgoingData() {
		super();
	}

	/**
	 * NCT Database Mark Transferred JMS Outgoing Data
	 * 
	 * @param jobExecutionId
	 * 				Job execution ID
	 * 
	 * @param jobFlowExecutionId
	 * 				Job flow execution ID
	 */
	public NCTDatabaseMarkTransferredJMSOutgoingData(int jobExecutionId, int jobFlowExecutionId) {
		super();
		this.jmsExecutionId = jobExecutionId;
		this.flowExecutionId = jobFlowExecutionId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement cs = connection.prepareCall("batchFlow.spMarkTransferredOutgoingData  ?,?,?");
		try {
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jmsExecutionId);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.flowExecutionId);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, NCTDatabaseMarkTransferredJMSOutgoingData.JMS_TYPE); // set type to JMS
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
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
