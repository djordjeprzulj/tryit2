package fr.ca.sa.nct.commons.authorizationUtils.permissionHolders;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.PermissionInterface;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class OpportunityPermissions implements Serializable, PermissionInterface {
	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	private Map<String, Boolean> permissionSettings;

	/**
	 * default constructor for Opportunity Permissions
	 */
	public OpportunityPermissions() {
		super();
		this.permissionSettings = new HashMap<>();
	}

	/**
	 * 
	 * @param canViewMyTasksPage
	 * @param canViewOpportunityPage
	 */
	public OpportunityPermissions(Boolean canViewMyTasksPage, Boolean canViewOpportunityPage) {
		super();
		this.permissionSettings = new HashMap<>();
		this.permissionSettings.put("CAN_VIEW_MY_TASKS_PAGE", canViewMyTasksPage);
		this.permissionSettings.put("CAN_VIEW_OPPORTUNITY_PAGE", canViewOpportunityPage);

	}

	/**
	 * 
	 * @param opportunityPermissions
	 */
	public OpportunityPermissions(Map<String, Boolean> opportunityPermissions) {
		super();
		this.permissionSettings = opportunityPermissions;
	}

	@Override
	public Map<String, Boolean> getPermissionSettings() {
		return this.permissionSettings;
	}

	@Override
	public void setPermissionSettings(Map<String, Boolean> permissions) {
		this.permissionSettings = permissions;
	}

	@Override
	public void addPermissionSetting(String permissionName, Boolean permissionValue) {
		this.permissionSettings.put(permissionName, permissionValue);

	}

}
