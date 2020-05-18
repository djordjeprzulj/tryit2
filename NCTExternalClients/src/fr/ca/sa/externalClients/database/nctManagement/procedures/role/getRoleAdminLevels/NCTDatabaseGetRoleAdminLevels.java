package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getRoleAdminLevels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.RoleCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting admin role levels
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetRoleAdminLevels extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetRoleAdminLevels.class);

	/**
	 * NCT Database Get Role Admin Levels
	 * 
	 * @param userId
	 */
	public NCTDatabaseGetRoleAdminLevels(Integer userId) {
		super(userId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetRoleAdminLevels ?");
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
		GetRoleAdminLevelsNCTResultList retList = new GetRoleAdminLevelsNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getRoleAdminLevels().add(new GetRoleAdminLevelsNCTResultItem(
						this.getResultSet().getInt("LevelId"), this.getResultSet().getString("LevelDescription")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new RoleCRUDException(ErrorConstants.ERROR_MSG_GET_ROLE_ADMIN_LEVELS);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new RoleCRUDException(ErrorConstants.ERROR_MSG_GET_ROLE_ADMIN_LEVELS);
	}
}
