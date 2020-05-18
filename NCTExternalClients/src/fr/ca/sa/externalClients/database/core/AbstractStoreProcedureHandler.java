package fr.ca.sa.externalClients.database.core;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.externalClients.database.common.PreparedStatementBuilderI;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.utilFunctions.ExternalClientsTimingLogger;

/**
 * Basic functionality for handling store procedures, which is required to be
 * extended in order to perform queries on DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public abstract class AbstractStoreProcedureHandler implements PreparedStatementBuilderI {

	private static final Logger LOGGER = Logger.getLogger(AbstractStoreProcedureHandler.class);

	private ResultSet resultSet = null;

	/**
	 * Invokes store procedure and if successful forwards results to parses
	 * 
	 * @return Result from store procedure, parsed in particular overridden
	 *         handler
	 * @throws SQLException
	 * @throws StatementExecutionException
	 */
	public StoreProcedureResult invokeStoreProcedure() throws StatementExecutionException {
		StoreProcedureResult retValue = null;
		PreparedStatementExecutor statementExecutor = null;
		try {

			statementExecutor = new PreparedStatementExecutor();

			Long start = System.currentTimeMillis();
			resultSet = statementExecutor.executeStatement(this);

			Long startHandling = System.currentTimeMillis();

			retValue = this.handleResultSet();

			if (retValue != null) {
				ExternalClientsTimingLogger.logExternalClientExecutionTiming(ProjectConstants.EXTERNAL_CLIENT_DB, start,
						System.currentTimeMillis(), ProjectConstants.getWarnExecutionTimeDB(),
						retValue.getClass().getSimpleName(),
						"in DB : " + (startHandling - start) + "ms,in server : "
								+ (System.currentTimeMillis() - startHandling) + "ms");
			}
		} catch (StatementExecutionException ex) {
			LOGGER.error(ex);
			throw ex;
		} finally {
			if (statementExecutor != null) {
				cleanUp(statementExecutor);
			}
		}
		return retValue;
	}

	private void cleanUp(PreparedStatementExecutor statementExecutor) {
		try {
			statementExecutor.cleanUp();
		} catch (SQLException ex) {
			LOGGER.error("Unable to cleanup DB connection!");
			LOGGER.error(ex);
			throw new StatementExecutionException(ErrorConstants.ERROR_MSG_DB_CONNECTION);
		}
	}

	protected ResultSet getResultSet() {
		return this.resultSet;
	}

	/**
	 * Parse for result set from store procedure, has to be overridden
	 * 
	 * @return Parsed result set from the store procedure
	 * @throws SQLException
	 * @throws StatementExecutionException
	 */
	protected abstract StoreProcedureResult handleResultSet() throws StatementExecutionException;

}
