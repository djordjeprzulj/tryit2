package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getCollaboratorRoles;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.model.Collaborator;
import fr.ca.sa.model.Entity;
import fr.ca.sa.model.Role;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetCollaboratorRolesNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/*
	private String entityCode;
	private String entityName;
	*/
	private Entity entity;
	
	private String functionName;
	
	private Collaborator collaborator;
	/*
	private int collaboratorId;
	private int collaboratorIdCore;
	private String collaboratorCode;
	private String firstName;
	private String lastName;
	private String fullName;
	private boolean active;
	*/
	
	private Role role;
	/*
	private Integer roleId;
	private String roleName;
	private String roleAssignedBy;
	private String roleAssignedDate;
*/
	/**
	 * default constructor for Get Collaborator Roles NCT Result Item
	 */
	public GetCollaboratorRolesNCTResultItem() {
		super();
	}

	/**
	 * Get Collaborator Roles NCT Result Item
	 * 
	 * @param entity
	 * 				Entity
	 * 
	 * @param functionName
	 * 				Function name
	 * 
	 * @param collaborator
	 * 				Collaborator
	 *  
	 * @param role
	 * 				Role
	 * 
	 */
	public GetCollaboratorRolesNCTResultItem(Entity entity, String functionName,
			Collaborator collaborator, Role role) {
		super();
		this.entity = entity;
		this.functionName = functionName;
		this.collaborator = collaborator;
		this.role = role;
/*
		if (roleAssignedDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
			this.roleAssignedDate = formatter.format(roleAssignedDate);
		} else {
			this.roleAssignedDate = null;
		}
*/
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public Collaborator getCollaborator() {
		return collaborator;
	}

	public void setCollaboratorId(Collaborator collaborator) {
		this.collaborator = collaborator;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "GetCollaboratorRolesNCTResultItem [entity=" + entity + ", functionName=" + functionName
				+ ", collaborator=" + collaborator + ", role=" + role + "]";
	}
}
