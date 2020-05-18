package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.markTransferredOutgoingData;

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
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseMarkTransferredOutgoingData extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseMarkTransferredOutgoingData.class);
	
	private int jobExecutionId;
	private int jobFlowExecutionId;
	
	/**
	 * default constructor for NCT Database Mark Transferred Outgoing Data
	 */
	public NCTDatabaseMarkTransferredOutgoingData() {
		super();
	}

	/**
	 * NCT Database Mark Transferred Outgoing Data
	 * 
	 * @param jobExecutionId
	 * 				Job execution ID
	 * 
	 * @param jobFlowExecutionId
	 * 				Job flow execution ID
	 */
	public NCTDatabaseMarkTransferredOutgoingData(int jobExecutionId, int jobFlowExecutionId) {
		super();
		this.jobExecutionId = jobExecutionId;
		this.jobFlowExecutionId = jobFlowExecutionId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement cs = connection.prepareCall("batchFlow.spMarkTransferredOutgoingData ?,?");
		try {
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jobExecutionId);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.jobFlowExecutionId);
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
