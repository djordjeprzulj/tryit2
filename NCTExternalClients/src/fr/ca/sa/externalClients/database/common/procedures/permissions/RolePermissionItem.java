package fr.ca.sa.externalClients.database.common.procedures.permissions;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Single Item in Role permission holder
 * 
 * @author Sasa Radovanovic
 *
 */
public class RolePermissionItem implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int roleId;

	private String roleName;

	private int objectId;

	private String objectName;

	private int perimeterId;

	private String perimeterName;

	private int level;

	/**
	 * Role Permission Item
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
	 * @param level
	 * 				Level
	 */
	public RolePermissionItem(int roleId, String roleName, int objectId, String objectName, int perimeterId,
			String perimeterName, int level) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.objectId = objectId;
		this.objectName = objectName;
		this.perimeterId = perimeterId;
		this.perimeterName = perimeterName;
		this.level = level;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "RolePermissionItem [roleId=" + roleId + ", roleName=" + roleName + ", objectId=" + objectId
				+ ", objectName=" + objectName + ", perimeterId=" + perimeterId + ", perimeterName=" + perimeterName
				+ ", level=" + level + "]";
	}
}
