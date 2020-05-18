package fr.ca.sa.externalClients.database.nct.procedures.permissions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.procedures.permissions.RolePermissionItem;
import fr.ca.sa.externalClients.database.common.procedures.permissions.RolePermissionList;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure call for retrieving bank roles permissions
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetBankRolesPermissions extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankRolesPermissions.class);

	public NCTDatabaseGetBankRolesPermissions() {
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement("exec spGetBankRolesPermissions");
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		RolePermissionList permissionList = new RolePermissionList();
		try {
			while (this.getResultSet().next()) {
				permissionList.getPermissionList().add(new RolePermissionItem(this.getResultSet().getInt("ROLE_ID"),
						this.getResultSet().getString("ROLE_NAME"), this.getResultSet().getInt("OBJECT_ID"),
						this.getResultSet().getString("OBJECT_NAME"), this.getResultSet().getInt("PERIMETER_ID"),
						this.getResultSet().getString("PERIMETER_NAME"), this.getResultSet().getInt("LEVEL")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException(ErrorConstants.ERROR_PERMISSION_MATRIX_LOAD);
		}
		return permissionList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException(ErrorConstants.ERROR_PERMISSION_MATRIX_LOAD);
	}

}
