package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getFunctionRoles;

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
 * Store procedure handler for getting funtion roles
 * 
 * @author Djordje Przulj
 *
 */
public class NCTDatabaseGetFunctionRoles extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetFunctionRoles.class);

	private Integer functionId;

	/**
	 * NCT Database Get Function Roles
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param functionId
	 * 				Function ID
	 */
	public NCTDatabaseGetFunctionRoles(int userId, Integer functionId) {
		super(userId);
		this.functionId = functionId;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetFunctionRoles ?,?");
		try {
			setUser(ps);	
			if (this.functionId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.functionId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetFunctionRolesNCTResultList retList = new GetFunctionRolesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getRoles()
						.add(new GetFunctionRolesNCTResultItem(this.getResultSet().getInt("FunctionId"), 
								this.getResultSet().getString("FunctionName"), 
								this.getResultSet().getInt("RoleId"), 
								this.getResultSet().getString("RoleName"),
								this.getResultSet().getString("RoleAssignedBy"), 
								this.getResultSet().getTimestamp("RoleAssignedDate")));
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
