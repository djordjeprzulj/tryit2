package fr.ca.sa.externalClients.database.nctManagement.procedures.role.deleteRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.RoleCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseDeleteRole extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseDeleteRole.class);

	private int roleId;

	/**
	 * NCT Database Delete Role
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param roleId
	 * 				Role ID
	 */
	public NCTDatabaseDeleteRole(int userId, int roleId) {
		super(userId);
		this.roleId = roleId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spDeleteRole ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.roleId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new RoleCRUDException(ErrorConstants.ERROR_MSG_DELETE_ROLE);
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		DeleteRoleNCTResultItem retValue = new DeleteRoleNCTResultItem();
		try {
			while (this.getResultSet().next()) {
				retValue = new DeleteRoleNCTResultItem(this.getResultSet().getInt("RoleId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new RoleCRUDException(ErrorConstants.ERROR_MSG_DELETE_ROLE);
		}

		return retValue;
	}

}
