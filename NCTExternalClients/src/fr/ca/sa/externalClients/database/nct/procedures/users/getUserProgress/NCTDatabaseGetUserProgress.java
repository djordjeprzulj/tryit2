package fr.ca.sa.externalClients.database.nct.procedures.users.getUserProgress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.UnknownUserException;
import fr.ca.sa.commons.exceptions.databaseExceptions.UserCRUDException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure call for retrieving user progress
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetUserProgress extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetUserProgress.class);

	/**
	 * NCT Database Get User Progress
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetUserProgress(int userId) {
		this.userId = userId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetCollProgress ?,?");
		try {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.userId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.userId);
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
				retValue = new UserProgressHolder(this.getResultSet().getDouble("progress"));
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
