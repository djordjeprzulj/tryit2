package fr.ca.sa.externalClients.database.nctManagement.procedures.role.deleteRole;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class DeleteRoleNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int roleId;

	/**
	 * default constructor for Delete Role NCT Result Item
	 */
	public DeleteRoleNCTResultItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Delete Role NCT Result Item
	 * 
	 * @param roleId
	 * 				Role ID
	 */
	public DeleteRoleNCTResultItem(int roleId) {
		super();
		this.roleId = roleId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "DeleteRoleNCTResultItem [roleId=" + roleId + "]";
	}

}
