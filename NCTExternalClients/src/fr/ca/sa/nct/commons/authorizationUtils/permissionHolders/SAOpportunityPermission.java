package fr.ca.sa.nct.commons.authorizationUtils.permissionHolders;

import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.PermissionInterface;

/**
 * 
 * Holder for permissions for Sales Assistant
 * 
 * @author Sasa Radovanovic
 *
 */
public class SAOpportunityPermission implements PermissionInterface {
	
	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, Boolean> opportunityPermissions;

	/**
	 * Sales Assistant Opportunity Permission
	 * 
	 * @param canCancel
	 * 			Permission to cancel
	 */
	public SAOpportunityPermission(Boolean canCancel) {
		super();
		this.opportunityPermissions = new HashMap<>();
		this.opportunityPermissions.put("CAN_CANCEL", canCancel);
	}

	/**
	 * Sales Assistant Opportunity Permission
	 * 
	 * @param opportunityPermissions
	 * 				Opportunity permissions
	 */
	public SAOpportunityPermission(Map<String, Boolean> opportunityPermissions) {
		super();
		this.opportunityPermissions = opportunityPermissions;
	}

	@Override
	public Map<String, Boolean> getPermissionSettings() {
		return opportunityPermissions;
	}

	@Override
	public void setPermissionSettings(Map<String, Boolean> permissions) {
		this.opportunityPermissions = permissions;
	}

	@Override
	public void addPermissionSetting(String permissionName, Boolean permissionValue) {
		this.opportunityPermissions.put(permissionName, permissionValue);
	}

}
