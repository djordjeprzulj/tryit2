package fr.ca.sa.nctManagement.commons.authorizationUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Holder for global permissions, post-auth
 * 
 * @author Sasa Radovanovic
 *
 */
public class GlobalPermissions implements MngmtPermissionInterface, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, Boolean> permissionSettings;

	/**
	 * 
	 * @param languageCanView
	 * @param languageCanChange
	 * @param listOfValuesView
	 * @param listOfValuesChange
	 * @param logoView
	 * @param logoChange
	 * @param dateTimeFormatsView
	 * @param dateTimeFormatsChange
	 * @param configParametersView
	 * @param configParametersChange
	 * @param homepageLinksView
	 * @param homepageLinksChange
	 * @param campaignsView
	 * @param campaignsChange
	 * @param rolesView
	 * @param rolesChange
	 * @param batchJobsView
	 * @param batchJobsChange
	 * @param nonWorkingDaysView
	 * @param nonWorkingDaysChange
	 * @param bankWorktimeView
	 * @param bankWorktimeChange
	 */
	public GlobalPermissions(Boolean languageCanView, Boolean languageCanChange, Boolean listOfValuesView,
			Boolean listOfValuesChange, Boolean logoView, Boolean logoChange, Boolean dateTimeFormatsView,
			Boolean dateTimeFormatsChange, Boolean configParametersView, Boolean configParametersChange,
			Boolean homepageLinksView, Boolean homepageLinksChange, Boolean campaignsView, Boolean campaignsChange,
			Boolean rolesView, Boolean rolesChange, Boolean batchJobsView, Boolean batchJobsChange,
			Boolean nonWorkingDaysView, Boolean nonWorkingDaysChange, Boolean bankWorktimeView,
			Boolean bankWorktimeChange) {
		super();
		this.permissionSettings = new HashMap<>();
		this.permissionSettings.put("LANG_CAN_VIEW", languageCanView);
		this.permissionSettings.put("LANG_CAN_EDIT", languageCanChange);
		this.permissionSettings.put("LIST_OF_VALUES_CAN_VIEW", listOfValuesView);
		this.permissionSettings.put("LIST_OF_VALUES_CAN_EDIT", listOfValuesChange);
		this.permissionSettings.put("LOGO_CAN_VIEW", logoView);
		this.permissionSettings.put("LOGO_CAN_EDIT", logoChange);
		this.permissionSettings.put("DATE_TIME_FORMATS_CAN_VIEW", dateTimeFormatsView);
		this.permissionSettings.put("DATE_TIME_FORMATS_CAN_EDIT", dateTimeFormatsChange);
		this.permissionSettings.put("CONFIG_PARAMS_CAN_VIEW", configParametersView);
		this.permissionSettings.put("CONFIG_PARAMS_CAN_EDIT", configParametersChange);
		this.permissionSettings.put("HOMEPAGE_LINKS_CAN_VIEW", homepageLinksView);
		this.permissionSettings.put("HOMEPAGE_LINKS_CAN_EDIT", homepageLinksChange);
		this.permissionSettings.put("CAMPAIGNS_CAN_VIEW", campaignsView);
		this.permissionSettings.put("CAMPAIGNS_CAN_EDIT", campaignsChange);
		this.permissionSettings.put("ROLES_CAN_VIEW", rolesView);
		this.permissionSettings.put("ROLES_CAN_EDIT", rolesChange);
		this.permissionSettings.put("BATCH_JOBS_CAN_VIEW", batchJobsView);
		this.permissionSettings.put("BATCH_JOBS_CAN_EDIT", batchJobsChange);
		this.permissionSettings.put("NON_WORKING_DAYS_CAN_VIEW", nonWorkingDaysView);
		this.permissionSettings.put("NON_WORKING_DAYS_CAN_EDIT", nonWorkingDaysChange);
		this.permissionSettings.put("BANK_WORKTIME_CAN_VIEW", bankWorktimeView);
		this.permissionSettings.put("BANK_WORKTIME_CAN_EDIT", bankWorktimeChange);
	}

	@Override
	public Map<String, Boolean> getPermissionSettings() {
		return permissionSettings;
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
