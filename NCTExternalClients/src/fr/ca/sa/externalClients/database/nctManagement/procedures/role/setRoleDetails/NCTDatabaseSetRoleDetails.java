package fr.ca.sa.externalClients.database.nctManagement.procedures.role.setRoleDetails;

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
import fr.ca.sa.externalClients.database.nctManagement.procedures.role.setRole.SetRoleNCTResultItem;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseSetRoleDetails extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetRoleDetails.class);

	private int roleId;
	private int objectId;
	private Integer perimeterId;
	private int levelId;
	private int isAdminRole;

	/**
	 * NCT Database Set Role Details
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param roleId
	 * 				Role ID
	 * 
	 * @param objectId
	 * 				Object ID
	 * 
	 * @param perimeterId
	 * 				Perimeter ID
	 * 
	 * @param levelId
	 * 				Level ID
	 * 
	 * @param isAdminRole
	 * 				Is admin role
	 */
	public NCTDatabaseSetRoleDetails(int userId, int roleId, int objectId, Integer perimeterId, int levelId,
			int isAdminRole) {
		super(userId);
		this.roleId = roleId;
		this.objectId = objectId;
		this.perimeterId = perimeterId;
		this.levelId = levelId;
		this.isAdminRole = isAdminRole;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spSetRoleDetails ?,?,?,?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.roleId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.objectId);
	
			if (this.perimeterId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.perimeterId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.INTEGER);
			}
	
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.levelId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.isAdminRole);
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

			throw new RoleCRUDException(ErrorConstants.ERROR_MSG_SET_ROLE_DETAILS);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new RoleCRUDException(ErrorConstants.ERROR_MSG_SET_ROLE_DETAILS);
	}
}
