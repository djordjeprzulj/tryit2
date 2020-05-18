package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getRoleAdminLevels;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetRoleAdminLevelsNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int levelId;
	private String levelDescription;

	/**
	 * default constructor for Get Role Admin Levels NCT Result Item
	 */
	public GetRoleAdminLevelsNCTResultItem() {
		super();
	}

	/**
	 * Get Role Admin Levels NCT Result Item
	 * 
	 * @param levelId
	 * 				Level ID
	 * 
	 * @param levelDescription
	 * 				Level description
	 */
	public GetRoleAdminLevelsNCTResultItem(int levelId, String levelDescription) {
		super();
		this.levelId = levelId;
		this.levelDescription = levelDescription;
	}

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public String getLevelDescription() {
		return levelDescription;
	}

	public void setLevelDescription(String levelDescription) {
		this.levelDescription = levelDescription;
	}

	@Override
	public String toString() {
		return "GetRoleAdminLevelsNCTResultItem [levelId=" + levelId + ", levelDescription=" + levelDescription + "]";
	}

}
