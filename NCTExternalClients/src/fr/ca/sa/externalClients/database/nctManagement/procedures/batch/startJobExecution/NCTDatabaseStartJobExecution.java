package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.startJobExecution;

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
 * Store procedure handler for starting job execution
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseStartJobExecution extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseStartJobExecution.class);

	private int jobId;
	private int jobStartOriginId;

	/**
	 * default constructor for NCT Database Start Job Execution
	 */
	public NCTDatabaseStartJobExecution() {
		super();
	}

	/**
	 * NCT Database Start Job Execution
	 * 
	 * @param jobId
	 * 				Job ID
	 * 
	 * @param jobStartOriginId
	 * 				Job start origin ID
	 */
	public NCTDatabaseStartJobExecution(int jobId, int jobStartOriginId) {
		super();
		this.jobId = jobId;
		this.jobStartOriginId = jobStartOriginId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec batchTrace.spStartJobExecution ?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.jobId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.jobStartOriginId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		StartJobExecutionNCTResultItem retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue = new StartJobExecutionNCTResultItem(this.getResultSet().getInt("JobExecutionId"),
						this.getResultSet().getInt("PreviousJobExecutionInProgress"));
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
