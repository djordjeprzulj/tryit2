package fr.ca.sa.externalClients.database.common.procedures.users.getUserRoles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.UnknownUserException;
import fr.ca.sa.commons.exceptions.databaseExceptions.UserCRUDException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Retrieve user role from database
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetUserRole extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetUserRole.class);

	/**
	 * NCT Database Get User Role
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetUserRole(int userId) {
		super(userId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetUserRolesByUserId ?");
		try {
			setUser(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		StoreProcedureResult retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue = new GetUserRoleNCTResult(this.getResultSet().getInt("ROLE_ID"),
						this.getResultSet().getString("ROLE_NAME"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new UserCRUDException(ErrorConstants.ERROR_MSG_GET_USER_DATA);
		}

		if (retValue == null) {
			throw new UnknownUserException();
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new UserCRUDException(ErrorConstants.ERROR_MSG_GET_USER_DATA);
	}

}
