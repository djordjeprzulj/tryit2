package fr.ca.sa.externalClients.database.procedures.auth.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.CriticalSystemErrorException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.UnknownUsernameException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for checking user account in DB on login
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseLogin extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseLogin.class);

	private String username;
	private Boolean functionMapping;

	/**
	 * NCT Database Login
	 * 
	 * @param username
	 *            Username
	 */
	public NCTDatabaseLogin(String username, Boolean functionMapping) {
		this.username = username;
		this.functionMapping = functionMapping;
	}

	/**
	 * Build Prepared Statement
	 * 
	 * @param connection
	 *            Connection
	 * 
	 * @return PreparedStatement Returns prepared statement
	 */
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spValidateUsername ?,?");
		try {
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_1, username);
			ps.setBoolean(NCTDatabaseConstants.SP_ARG_NR_2, functionMapping);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet()
			throws StatementExecutionException, UnknownUsernameException {
		StoreProcedureResult retValue = null;
		try {
			while (this.getResultSet().next()) {
				int result = this.getResultSet().getInt("UserId");
				if (result == NCTDatabaseConstants.getLoginUserNotActive()) {
					throw new UnknownUsernameException(ErrorConstants.ERROR_MSG_USER_NOT_ACTIVE);
				} else if (result == NCTDatabaseConstants.getLoginUserUnknown()) {
					throw new UnknownUsernameException();
				}

				retValue = new LoginNCTResult(result, this.getResultSet().getInt("UserIdCore"));
			}
		} catch (NumberFormatException ex) {
			LOGGER.error(ex);
			throw new CriticalSystemErrorException();
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new UnknownUsernameException();
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new UnknownUsernameException();
	}
}
