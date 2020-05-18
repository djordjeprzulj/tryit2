package fr.ca.sa.externalClients.database.common.procedures.users.getUserRoles;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * User Role holder for retrieving user role from database
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetUserRoleNCTResult implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int roleId;

	private String roleName;

	/**
	 * default constructor for Get User Role NCT Result
	 */
	public GetUserRoleNCTResult() {
		super();
	}

	/**
	 * Get User Role NCT Result
	 * 
	 * @param roleId
	 * 				Role ID
	 * 
	 * @param roleName
	 * 				Role name
	 */
	public GetUserRoleNCTResult(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
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

	@Override
	public String toString() {
		return "GetUserRoleNCTResult [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
