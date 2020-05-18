package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getRoleObjectLevels;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning role object levels
 * 
 * @author Stefan Djokic
 *
 */
public class GetRoleObjectLevelsNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int objectId;
	private String objectName;
	private int levelId;
	private String levelDescription;

	/**
	 * default constructor for Get Role Object Levels NCT Result Item
	 */
	public GetRoleObjectLevelsNCTResultItem() {
		super();
	}

	/**
	 * Get Role Object Levels NCT Result Item
	 * 
	 * @param objectId
	 * 				Object ID
	 * 
	 * @param objectName
	 * 				Object name
	 * 
	 * @param levelId
	 * 				Level ID
	 * 
	 * @param levelDescription
	 * 				Level description
	 */
	public GetRoleObjectLevelsNCTResultItem(int objectId, String objectName, int levelId, String levelDescription) {
		super();
		this.objectId = objectId;
		this.objectName = objectName;
		this.levelId = levelId;
		this.levelDescription = levelDescription;
	}

	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
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
		return "GetRoleObjectLevelsResultItem [objectId=" + objectId + ", objectName=" + objectName + ", levelId="
				+ levelId + ", levelDescription=" + levelDescription + "]";
	}

}
