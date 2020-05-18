package fr.ca.sa.nct.commons.authorizationUtils.permissionHolders;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.PermissionInterface;

/**
 * 
 * Opportunities permission holder (Check implementation for specific permission
 * flags)
 * 
 * @author Sasa Radovanovic
 *
 */
public class OpportunityItemPermission implements Serializable, PermissionInterface {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, Boolean> opportunityMap;

	/**
	 * default constructor for Opportunity Item Permission
	 */
	public OpportunityItemPermission() {
		super();
		this.opportunityMap = new HashMap<>();
	}

	/**
	 * Opportunity Item Permission
	 * 
	 * @param canAccessClientSynthesis
	 * 				Permission to access client synthesis
	 * 
	 * @param modify
	 * 				Permission to modify
	 * 
	 * @param canReassign
	 * 				Permission to reassign
	 */
	public OpportunityItemPermission(Boolean canAccessClientSynthesis, Boolean modify, Boolean canReassign) {
		super();
		this.opportunityMap = new HashMap<>();
		this.opportunityMap.put("CAN_ACCESS_CLIENT_DATA", canAccessClientSynthesis);
		this.opportunityMap.put("CAN_MODIFY", modify);
		this.opportunityMap.put("CAN_REASSIGN", canReassign);
	}

	@Override
	public Map<String, Boolean> getPermissionSettings() {
		return opportunityMap;
	}

	@Override
	public void setPermissionSettings(Map<String, Boolean> permissions) {
		this.opportunityMap = permissions;
	}

	@Override
	public void addPermissionSetting(String permissionName, Boolean permissionValue) {
		this.opportunityMap.put(permissionName, permissionValue);
	}

}
