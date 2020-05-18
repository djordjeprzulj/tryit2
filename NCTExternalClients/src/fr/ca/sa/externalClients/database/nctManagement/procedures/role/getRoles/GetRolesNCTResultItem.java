package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getRoles;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning role
 * 
 * @author Stefan Djokic
 *
 */
public class GetRolesNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int roleId;
	private String roleName;
	private int objectId;
	private String objectName;
	private int perimeterId;
	private String perimeterName;
	private int levelId;
	private String levelDescription;

	/**
	 * default constructor for Get Roles NCT Result Item
	 */
	public GetRolesNCTResultItem() {
		super();
	}

	/**
	 * Get Roles NCT Result Item
	 * 
	 * @param roleId
	 * 				Role ID
	 * 
	 * @param roleName
	 * 				Role name
	 * 
	 * @param objectId
	 * 				Object ID
	 * 
	 * @param objectName
	 * 				Object name
	 * 
	 * @param perimeterId
	 * 				Perimeter ID
	 * 
	 * @param perimeterName
	 * 				Perimeter name
	 * 
	 * @param levelId
	 * 				Level ID
	 * 
	 * @param levelDescription
	 * 				Level description
	 */
	public GetRolesNCTResultItem(int roleId, String roleName, int objectId, String objectName, int perimeterId,
			String perimeterName, int levelId, String levelDescription) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.objectId = objectId;
		this.objectName = objectName;
		this.perimeterId = perimeterId;
		this.perimeterName = perimeterName;
		this.levelId = levelId;
		this.levelDescription = levelDescription;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public int getPerimeterId() {
		return perimeterId;
	}

	public void setPerimeterId(int perimeterId) {
		this.perimeterId = perimeterId;
	}

	public String getPerimeterName() {
		return perimeterName;
	}

	public void setPerimeterName(String perimeterName) {
		this.perimeterName = perimeterName;
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
		return "GetRolesResultItem [roleId=" + roleId + ", roleName=" + roleName + ", objectId=" + objectId
				+ ", objectName=" + objectName + ", perimeterId=" + perimeterId + ", perimeterName=" + perimeterName
				+ ", levelId=" + levelId + ", levelDescription=" + levelDescription + "]";
	}

}
