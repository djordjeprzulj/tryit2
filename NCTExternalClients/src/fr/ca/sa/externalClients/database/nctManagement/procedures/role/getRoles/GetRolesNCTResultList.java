package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getRoles;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetRolesNCTResultList implements StoreProcedureResult {

	private List<GetRolesNCTResultItem> roles;

	/**
	 * default constructor for Get Roles NCT Result List
	 */
	public GetRolesNCTResultList() {
		super();
		this.roles = new ArrayList<GetRolesNCTResultItem>();
	}

	public List<GetRolesNCTResultItem> getRoles() {
		return roles;
	}

	public void setRoles(List<GetRolesNCTResultItem> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetRoleNCTResultList [ ");
		if (this.roles != null) {
			for (GetRolesNCTResultItem role : this.roles) {
				sbRetValue.append(role.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetRoleNCTResultList is empty!!!";
	}

}
