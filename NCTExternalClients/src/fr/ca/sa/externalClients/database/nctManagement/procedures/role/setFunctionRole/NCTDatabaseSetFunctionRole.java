package fr.ca.sa.externalClients.database.nctManagement.procedures.role.setFunctionRole;

import java.sql.CallableStatement;
import java.sql.Connection;
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
 * Store procedure handler for setting function role
 * 
 * @author Djordje Przulj
 *
 */
public class NCTDatabaseSetFunctionRole extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetFunctionRole.class);

	private int functionId;
	private Integer roleId;

	/**
	 * NCT Database Set Function Role
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param functionId
	 * 				Function ID
	 * 
	 * @param roleId
	 * 				Role ID
	 */
	public NCTDatabaseSetFunctionRole(int userId, int functionId, Integer roleId) {
		super(userId);
		this.functionId = functionId;
		this.roleId = roleId;
	}

	@Override
	public CallableStatement buildPreparedStatement(Connection connection) throws SQLException { 
		CallableStatement cs = connection.prepareCall("exec spSetFunctionRole ?,?,?");
		try {
			setUser(cs);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.functionId);
	
			if (this.roleId != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.roleId);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {	
		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new RoleCRUDException(ErrorConstants.ERROR_MSG_SET_FUNCTION_ROLE);
	}
}
