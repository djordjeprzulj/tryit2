package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.purgeFlowImportTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import fr.ca.sa.commons.exceptions.databaseExceptions.BatchProcessingOperationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for tracing batch processing
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabasePurgeFlowImportTable extends AbstractStoreProcedureHandler {

	private String flowName;

	/**
	 * default constructor for NCT Database Purge Flow Import Table
	 */
	public NCTDatabasePurgeFlowImportTable() {
		super();
	}

	/**
	 * NCT Database Purge Flow Import Table
	 * 
	 * @param flowName
	 * 				Flow name
	 */
	public NCTDatabasePurgeFlowImportTable(String flowName) {
		super();
		this.flowName = flowName;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareCall("DELETE FROM batchFlow."+flowName);
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
