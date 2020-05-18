package fr.ca.sa.nct.commons.authorizationUtils.permissionHolders;

import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.PermissionInterface;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class LeadClientPermissions implements PermissionInterface {
	
	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, Boolean> leadPermissions;

	/**
	 * Lead Client Permissions
	 * 
	 * @param canAddLeads
	 * 			Permission to add leads
	 */
	public LeadClientPermissions(Boolean canAddLeads) {
		super();
		this.leadPermissions = new HashMap<>();
		this.leadPermissions.put("CAN_ADD_LEADS", canAddLeads);
	}

	@Override
	public Map<String, Boolean> getPermissionSettings() {
		return leadPermissions;
	}

	@Override
	public void setPermissionSettings(Map<String, Boolean> permissions) {
		this.leadPermissions = permissions;
	}

	@Override
	public void addPermissionSetting(String permissionName, Boolean permissionValue) {
		this.leadPermissions.put(permissionName, permissionValue);
	}

}
