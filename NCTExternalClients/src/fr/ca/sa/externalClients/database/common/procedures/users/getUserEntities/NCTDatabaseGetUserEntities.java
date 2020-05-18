package fr.ca.sa.externalClients.database.common.procedures.users.getUserEntities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.UserCRUDException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Database procedure for retrieving for all user entities from Database
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetUserEntities extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetUserEntities.class);

	/**
	 * NCT Database Get User Entities
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetUserEntities(int userId) {
		super(userId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetUserEntitiesByUserId ?");
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
		UserEntitiesList retList = new UserEntitiesList();
		try {
			while (this.getResultSet().next()) {
				retList.getUserEntities().add(new UserEntityItem(this.getResultSet().getString("ENTITY_CODE"),
						this.getResultSet().getString("ENTITY_NAME"), this.getResultSet().getInt("ENTITY_ID")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new UserCRUDException(ErrorConstants.ERROR_MSG_GET_USER_DATA);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new UserCRUDException(ErrorConstants.ERROR_MSG_GET_USER_DATA);
	}
}
