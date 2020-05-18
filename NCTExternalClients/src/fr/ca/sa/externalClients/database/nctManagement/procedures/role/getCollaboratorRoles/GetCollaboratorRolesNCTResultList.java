package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getCollaboratorRoles;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetCollaboratorRolesNCTResultList implements StoreProcedureResult {

	private List<GetCollaboratorRolesNCTResultItem> collaboratorRoles;

	/**
	 * default constructor for Get Collaborator Roles NCT Result List
	 */
	public GetCollaboratorRolesNCTResultList() {
		super();
		this.collaboratorRoles = new ArrayList<GetCollaboratorRolesNCTResultItem>();
	}

	public List<GetCollaboratorRolesNCTResultItem> getCollaboratorRoles() {
		return collaboratorRoles;
	}

	public void setCollaboratorRoles(List<GetCollaboratorRolesNCTResultItem> collaboratorRoles) {
		this.collaboratorRoles = collaboratorRoles;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetCollaboratorRolesNCTResultList [ ");
		if (this.collaboratorRoles != null) {
			for (GetCollaboratorRolesNCTResultItem role : this.collaboratorRoles) {
				sbRetValue.append(role.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetCollaboratorRolesNCTResultList is empty!!!";
	}

}
