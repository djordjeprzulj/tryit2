package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getRoleAdminLevels;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetRoleAdminLevelsNCTResultList implements StoreProcedureResult {

	private List<GetRoleAdminLevelsNCTResultItem> roleAdminLevels;

	/**
	 * default constructor for Get Role Admin Levels NCT Result List
	 */
	public GetRoleAdminLevelsNCTResultList() {
		super();
		this.roleAdminLevels = new ArrayList<GetRoleAdminLevelsNCTResultItem>();
	}

	public List<GetRoleAdminLevelsNCTResultItem> getRoleAdminLevels() {
		return roleAdminLevels;
	}

	public void setRoleAdminLevels(List<GetRoleAdminLevelsNCTResultItem> roleAdminLevels) {
		this.roleAdminLevels = roleAdminLevels;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetRoleAdminLevelsNCTResultList [ ");
		if (this.roleAdminLevels != null) {
			for (GetRoleAdminLevelsNCTResultItem roleAdminLevel : this.roleAdminLevels) {
				sbRetValue.append(roleAdminLevel.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetRoleAdminLevelsNCTResultList is empty!!!";
	}

}
