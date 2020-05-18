package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getRoleObjectLevels;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetRoleObjectLevelsNCTResultList implements StoreProcedureResult {

	private List<GetRoleObjectLevelsNCTResultItem> objectLevels;

	/**
	 * default constructor for Get Role Object Levels NCT Result List
	 */
	public GetRoleObjectLevelsNCTResultList() {
		super();
		this.objectLevels = new ArrayList<GetRoleObjectLevelsNCTResultItem>();
	}

	public List<GetRoleObjectLevelsNCTResultItem> getObjectLevels() {
		return objectLevels;
	}

	public void setObjectLevels(List<GetRoleObjectLevelsNCTResultItem> objectLevels) {
		this.objectLevels = objectLevels;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetRoleObjectLevelsResultList [ ");
		if (this.objectLevels != null) {
			for (GetRoleObjectLevelsNCTResultItem objectLevel : this.objectLevels) {
				sbRetValue.append(objectLevel.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetRoleObjectLevelsResultList is empty!!!";
	}
}
