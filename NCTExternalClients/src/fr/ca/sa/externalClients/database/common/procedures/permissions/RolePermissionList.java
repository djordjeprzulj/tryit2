package fr.ca.sa.externalClients.database.common.procedures.permissions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Result list for Role permission store procedure
 * 
 * @author Sasa Radovanovic
 *
 */
public class RolePermissionList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<RolePermissionItem> permissionList;

	/**
	 * default constructor for Role Permission List
	 */
	public RolePermissionList() {
		super();
		this.permissionList = new ArrayList<>();
	}

	/**
	 * Role Permission List
	 * 
	 * @param permissionList
	 * 				Permission list
	 */
	public RolePermissionList(List<RolePermissionItem> permissionList) {
		super();
		this.permissionList = permissionList;
	}

	public List<RolePermissionItem> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<RolePermissionItem> permissionList) {
		this.permissionList = permissionList;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("RolePermissionList [ ");
		if (permissionList != null) {
			for (RolePermissionItem rolePermItem : permissionList) {
				sbRetValue.append(rolePermItem.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "RolePermissionList is empty!!!";
	}


}
