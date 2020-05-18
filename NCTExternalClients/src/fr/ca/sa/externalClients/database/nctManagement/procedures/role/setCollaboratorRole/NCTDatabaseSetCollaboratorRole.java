package fr.ca.sa.externalClients.database.nctManagement.procedures.role.setCollaboratorRole;

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
 * Store procedure handler for setting collaborator role
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseSetCollaboratorRole extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetCollaboratorRole.class);

	private int collaboratorId;
	private Integer roleId;

	/**
	 * NCT Database Set Collaborator Role
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param collaboratorId
	 * 				Collaborator ID
	 * 
	 * @param roleId
	 * 				Role ID
	 */
	public NCTDatabaseSetCollaboratorRole(int userId, int collaboratorId, Integer roleId) {
		super(userId);
		this.collaboratorId = collaboratorId;
		this.roleId = roleId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spSetCollaboratorRole ?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.collaboratorId);
	
			if (this.roleId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.roleId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetCollaboratorRoleNCTResultItem retValue = new SetCollaboratorRoleNCTResultItem();
		try {
			while (this.getResultSet().next()) {
				retValue = new SetCollaboratorRoleNCTResultItem(this.getResultSet().getInt("CollaboratorId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new RoleCRUDException(ErrorConstants.ERROR_MSG_SET_COLLABORATOR_ROLE);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new RoleCRUDException(ErrorConstants.ERROR_MSG_SET_COLLABORATOR_ROLE);
	}
}
