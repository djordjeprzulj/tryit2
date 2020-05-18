package fr.ca.sa.externalClients.ldap.nctManagement;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nctManagement.commons.authorizationUtils.GlobalPermissions;

/**
 * 
 * Identity holder for management service callers
 * 
 * @author Sasa Radovanovic
 *
 */
public class UsernameManagementHolder implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String username;

	private Integer roleId;

	private Integer userId;

	private GlobalPermissions permissions;

	/**
	 * @param default
	 *            constructor
	 */
	public UsernameManagementHolder() {
		super();
	}

	/**
	 * 
	 * @param username
	 * @param roleId
	 * @param userId
	 * @param permissions
	 */
	public UsernameManagementHolder(String username, Integer roleId, Integer userId, GlobalPermissions permissions) {
		super();
		this.username = username;
		this.roleId = roleId;
		this.userId = userId;
		this.permissions = permissions;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public GlobalPermissions getPermissions() {
		return permissions;
	}

}
