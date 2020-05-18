package fr.ca.sa.externalClients.database.nctManagement.procedures.role.getFunctionRoles;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning function roles
 * 
 * @author Djordje Przulj
 *
 */
public class GetFunctionRolesNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int functionId;
	private String functionName;
	private int roleId;
	private String roleName;
	private String roleAssignedBy;
	private String roleAssignedDate;
	
	/**
	 * default constructor for Get Roles NCT Result Item
	 */
	public GetFunctionRolesNCTResultItem() {
		super();
	}

	/**
	 * Get Function Roles NCT Result Item
	 * 
	 * @param functionId
	 * 				Function ID
	 * 
	 * @param functionName
	 * 				Function name
	 * 
	 * @param roleId
	 * 				Role ID
	 * 
	 * @param roleName
	 * 				Role name
	 * 
	 */
	public GetFunctionRolesNCTResultItem(int functionId, String functionName, int roleId, String roleName, 
			String roleAssignedBy, Timestamp roleAssignedDate) {
		super();
		this.functionId = functionId;
		this.functionName = functionName;
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleAssignedBy = roleAssignedBy;
		
		if (roleAssignedDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
			this.roleAssignedDate = formatter.format(roleAssignedDate);
		} else {
			this.roleAssignedDate = null;
		}
	}
	
	public int getFunctionId() {
		return functionId;
	}

	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
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
	
	public String getRoleAssignedBy() {
		return roleAssignedBy;
	}

	public void setRoleAssignedBy(String roleAssignedBy) {
		this.roleAssignedBy = roleAssignedBy;
	}

	public String getRoleAssignedDate() {
		return roleAssignedDate;
	}

	public void setRoleAssignedDate(String roleAssignedDate) {
		this.roleAssignedDate = roleAssignedDate;
	}

	@Override
	public String toString() {
		return "GetFunctionRolesNCTResultItem [functionId=" + functionId + ", functionName=" + functionName + 
				", roleId=" + roleId + ", roleName=" + roleName + ", roleAssignedBy=" + roleAssignedBy + ", roleAssignedDate=" + roleAssignedDate + "]";
	}

}
