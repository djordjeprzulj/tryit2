package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getCollaboratorRoles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.RoleCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.model.Collaborator;
import fr.ca.sa.model.Entity;
import fr.ca.sa.model.Role;

/**
 * 
 * Store procedure handler for getting collaborator roles
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetCollaboratorRoles extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetCollaboratorRoles.class);

	private Integer entityId;
	private Integer advisorId;
	private Integer advisorIdCore;

	/**
	 * NCT Database Get Collaborator Roles
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param entityId
	 * 				Entity ID
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 * 
	 * @param advisorIdCore
	 * 				Advisor ID core
	 */
	public NCTDatabaseGetCollaboratorRoles(int userId, Integer entityId, Integer advisorId, Integer advisorIdCore) {
		super(userId);
		this.entityId = entityId;
		this.advisorId = advisorId;
		this.advisorIdCore = advisorIdCore;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetCollaboratorRoles ?,?,?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, NCTDatabaseConstants.getUserRolesLimit());
	
			if (this.entityId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.entityId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
	
			if (this.advisorId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.advisorId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.INTEGER);
			}
	
			if (this.advisorIdCore != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.advisorIdCore);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetCollaboratorRolesNCTResultList retList = new GetCollaboratorRolesNCTResultList();
		try {
			
			Collaborator collaborator = new Collaborator(this.getResultSet().getInt("CollaboratorId"),
					this.getResultSet().getString("FirstName"),
					this.getResultSet().getString("LastName"), null);
			collaborator.setIdExt(this.getResultSet().getInt("CollaboratorIdCore"));
			collaborator.setCode(this.getResultSet().getString("CollaboratorCode"));
			collaborator.setName(this.getResultSet().getString("FullName"));
			collaborator.setActive(this.getResultSet().getInt("IsActive") == 1);
			
			Entity entity = new Entity(null, null, this.getResultSet().getString("EntityCode"), this.getResultSet().getString("EntityName"));
			
			Timestamp tsAssignedDate = this.getResultSet().getTimestamp("RoleAssignedDate");
			String strAssignedDate = null;
			if (tsAssignedDate != null) {
				SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
				strAssignedDate = formatter.format(tsAssignedDate);
			} 
			
			Role role = new Role(this.getResultSet().getInt("RoleId"),
					this.getResultSet().getString("RoleName"), this.getResultSet().getString("RoleAssignedBy"),
					strAssignedDate);
			
			while (this.getResultSet().next()) {
				retList.getCollaboratorRoles().add(new GetCollaboratorRolesNCTResultItem(entity,  						
						this.getResultSet().getString("FunctionName"), collaborator, role));				
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new RoleCRUDException(ErrorConstants.ERROR_MSG_GET_COLLABORATOR_ROLES);
		}

		return retList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new RoleCRUDException(ErrorConstants.ERROR_MSG_GET_COLLABORATOR_ROLES);
	}
}
