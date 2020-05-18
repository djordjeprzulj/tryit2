package fr.ca.sa.nct.commons.authorizationUtils.permissionHolders;

import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.PermissionInterface;

/**
 * 
 * Search list permission holder (Check implementation for specific permission
 * flags)
 * 
 * @author Sasa Radovanovic
 *
 */
public class SearchListPermissions implements PermissionInterface {
	
	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, Boolean> searchListPermissionsList;

	/**
	 * Search List Permissions
	 * 
	 * @param canAccessClientData
	 * 				Permission to access client data
	 */
	public SearchListPermissions(Boolean canAccessClientData) {
		super();
		this.searchListPermissionsList = new HashMap<>();
		this.searchListPermissionsList.put("CAN_ACCESS_CLIENT_DATA", canAccessClientData);
	}

	/**
	 * Search List Permissions
	 * 
	 * @param canAccessClientData
	 * 				Permission to access client data
	 * 
	 * @param canEditLead
	 * 				Permission to edit lead
	 */
	public SearchListPermissions(Boolean canAccessClientData, Boolean canEditLead) {
		super();
		this.searchListPermissionsList = new HashMap<>();
		this.searchListPermissionsList.put("CAN_ACCESS_CLIENT_DATA", canAccessClientData);
		this.searchListPermissionsList.put("CAN_EDIT_LEAD", canEditLead);
	}

	/**
	 * Search List Permissions
	 * 
	 * @param searchListPermissions
	 * 				Search list permissions
	 */
	public SearchListPermissions(Map<String, Boolean> searchListPermissions) {
		super();
		this.searchListPermissionsList = searchListPermissions;
	}

	@Override
	public Map<String, Boolean> getPermissionSettings() {
		return searchListPermissionsList;
	}

	@Override
	public void setPermissionSettings(Map<String, Boolean> permissions) {
		this.searchListPermissionsList = permissions;
	}

	@Override
	public void addPermissionSetting(String permissionName, Boolean permissionValue) {
		this.addPermissionSetting(permissionName, permissionValue);
	}

}
