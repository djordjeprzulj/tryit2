package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getRoles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
 * Store procedure handler for getting role
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetRoles extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetRoles.class);

	private Integer roleId;
	private int isAdminRole;

	/**
	 * NCT Database Get Roles
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param roleId
	 * 				Role ID
	 * 
	 * @param isAdminRole
	 * 				Is admin role
	 */
	public NCTDatabaseGetRoles(int userId, Integer roleId, int isAdminRole) {
		super(userId);
		this.roleId = roleId;
		this.isAdminRole = isAdminRole;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetRoles ?,?,?");
		try {
			setUser(ps);
	
			if (this.roleId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.roleId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.isAdminRole);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetRolesNCTResultList retList = new GetRolesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getRoles()
						.add(new GetRolesNCTResultItem(this.getResultSet().getInt("RoleId"),
								this.getResultSet().getString("RoleName"), this.getResultSet().getInt("ObjectId"),
								this.getResultSet().getString("ObjectName"), this.getResultSet().getInt("PerimeterId"),
								this.getResultSet().getString("PerimeterName"), this.getResultSet().getInt("LevelId"),
								this.getResultSet().getString("LevelDescription")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new RoleCRUDException(ErrorConstants.ERROR_MSG_GET_ROLES);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new RoleCRUDException(ErrorConstants.ERROR_MSG_GET_ROLES);
	}
}
