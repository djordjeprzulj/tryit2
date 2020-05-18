package fr.ca.sa.externalClients.database.nctManagement.procedures.role.setCollaboratorRole;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class SetCollaboratorRoleNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int collaboratorId;

	/**
	 * default constructor for Set Collaborator Role NCT Result Item
	 */
	public SetCollaboratorRoleNCTResultItem() {
		super();
	}

	/**
	 * Set Collaborator Role NCT Result Item
	 * 
	 * @param collaboratorId
	 * 				Collaborator ID
	 */
	public SetCollaboratorRoleNCTResultItem(int collaboratorId) {
		super();
		this.collaboratorId = collaboratorId;
	}

	public int getCollaboratorId() {
		return collaboratorId;
	}

	public void setCollaboratorId(int collaboratorId) {
		this.collaboratorId = collaboratorId;
	}

	@Override
	public String toString() {
		return "SetCollaboratorRoleNCTResultItem [collaboratorId=" + collaboratorId + "]";
	}

}
