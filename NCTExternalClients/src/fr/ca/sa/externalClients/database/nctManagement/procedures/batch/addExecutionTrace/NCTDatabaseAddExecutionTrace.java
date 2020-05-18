package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.addExecutionTrace;

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
 * Store procedure handler for tracing batch processing
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseAddExecutionTrace extends AbstractStoreProcedureHandler {
	
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseAddExecutionTrace.class);
	
	private int jobExecutionId;
	private Integer flowExecutionId;
	private int executionStatusId;
	private String description;

	/**
	 * default constructor for NCT Database Add Execution Trace
	 */
	public NCTDatabaseAddExecutionTrace() {
		super();
	}

	/**
	 * NCT Database Add Execution Trace
	 * 
	 * @param jobExecutionId
	 * 				Job execution ID
	 * 
	 * @param flowExecutionId
	 * 				Flow execution ID
	 * 
	 * @param executionStatusId
	 * 				Execution status ID
	 * 
	 * @param description
	 * 				Description
	 */
	public NCTDatabaseAddExecutionTrace(int jobExecutionId, Integer flowExecutionId, int executionStatusId,
			String description) {
		super();
		this.jobExecutionId = jobExecutionId;
		this.flowExecutionId = flowExecutionId;
		this.executionStatusId = executionStatusId;
		this.description = description;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement ps = connection.prepareCall("exec batchTrace.spAddExecutionTrace ?,?,?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jobExecutionId);
			if (this.flowExecutionId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.flowExecutionId);
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
		throw new BatchProcessingOperationException(ex.toString(),ex.getCause());
	}

}
