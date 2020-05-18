package fr.ca.sa.externalClients.database.nctManagement.procedures.getAppVersion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ParametersCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting application version from DB
 * 
 * @author Jelena Raca
 *
 */
public class NCTDatabaseGetAppVersion extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAppVersion.class);

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement("exec spGetAppVersion");
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetAppVersionNCTResultItem retValue = new GetAppVersionNCTResultItem();
		try {
			while (this.getResultSet().next()) {

				retValue = new GetAppVersionNCTResultItem(this.getResultSet().getString("NAME"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_APP_VERSION);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_APP_VERSION);
	}
}
