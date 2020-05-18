package fr.ca.sa.externalClients.database.nctManagement.procedures.role.setRoleDetails;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning role ID in JSON response
 * 
 * @author Stefan Djokic
 *
 */
public class SetRoleDetailsNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int roleId;

	/**
	 * default constructor for Set Role Details NCT Result Item
	 */
	public SetRoleDetailsNCTResultItem() {
		super();
	}

	/**
	 * Set Role Details NCT Result Item
	 * 
	 * @param roleId
	 * 				Role ID
	 */
	public SetRoleDetailsNCTResultItem(int roleId) {
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
		return "SetRoleDetailsResultItem [roleId=" + roleId + "]";
	}

}
