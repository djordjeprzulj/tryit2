package fr.ca.sa.externalClients.database.common.procedures.users.getUserInfo;

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
 * Store procedure handler for getting basic user information from DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetUserInfo extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetUserInfo.class);


	/**
	 * NCT Database Get User Info
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetUserInfo(int userId) {
		super(userId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetUserDetailsByUserId ?");
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
				retValue = new GetUserInfoNCTResult(this.getResultSet().getString("FIRST_NAME"),
						this.getResultSet().getString("LAST_NAME"), this.getResultSet().getString("FUNCTION_NAME"),
						this.getResultSet().getString("ENTITY_NAME"), this.getResultSet().getString("ENTITY_CODE"));
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
