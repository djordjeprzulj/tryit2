package fr.ca.sa.externalClients.database.nctManagement.procedures.role.setRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.RoleCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for setting roles
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseSetRole extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetRole.class);

	private Integer roleId;
	private String roleName;
	private String roleDescription;

	/**
	 * NCT Database Set Role
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param roleId
	 * 				Role ID
	 * 
	 * @param roleName
	 * 				Role name
	 * 
	 * @param roleDescription
	 * 				Role description
	 */
	public NCTDatabaseSetRole(int userId, Integer roleId, String roleName, String roleDescription) {
		super(userId);
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spSetRole ?,?,?,?");
		try {
			setUser(ps);
	
			if (this.roleId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.roleId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
	
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.roleName);
	
			if (this.roleDescription != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.roleDescription);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.VARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetRoleNCTResultItem retValue = new SetRoleNCTResultItem();
		try {
			while (this.getResultSet().next()) {
				retValue = new SetRoleNCTResultItem(this.getResultSet().getInt("RoleId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new RoleCRUDException(ErrorConstants.ERROR_MSG_SET_ROLE);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new RoleCRUDException(ErrorConstants.ERROR_MSG_SET_ROLE);
	}
}
