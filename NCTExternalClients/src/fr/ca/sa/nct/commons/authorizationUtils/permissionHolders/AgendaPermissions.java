package fr.ca.sa.nct.commons.authorizationUtils.permissionHolders;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.PermissionInterface;

/**
 * 
 * Admin agenda permission holder (Check implementation for specific permission
 * flags)
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaPermissions implements Serializable, PermissionInterface {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, Boolean> adminAgendaPermissions;

	/**
	 * Agenda Permissions
	 * 
	 * @param canChangeWorkHours
	 * 				Permission to change working hours
	 * 
	 * @param canChangeOwnEntity
	 * 				Permission to change own entity
	 * 
	 * @param canChangeUnderneath
	 * 				Permission to change underneath
	 * 
	 * @param canChangeSameLevel
	 * 				Permission to change same level
	 * 
	 * @param canChangeSameLevelAndBellow
	 * 				Permission to change same level and bellow
	 * 
	 * @param canAccessOwnCalender
	 * 				Permission to access own calendar
	 * 
	 * @param canAccessCalenderOwnEntity
	 * 				Permission to access calendar own entity
	 * 
	 * @param canAccessCalenderUnderneath
	 * 				Permission to access calendar underneath
	 * 
	 * @param canAccessCalenderSameLevel
	 * 				Permission to access calendar same level
	 * 
	 * @param canAccessCalenderSameLevelAndBellow
	 * 				Permission to access calendar same level and below
	 * 
	 * @param canAccessAll
	 * 				
	 */
	public AgendaPermissions(Boolean canChangeWorkHours, Boolean canChangeOwnEntity, Boolean canChangeUnderneath,
			Boolean canChangeSameLevel, Boolean canChangeSameLevelAndBellow, Boolean canAccessOwnCalender,
			Boolean canAccessCalenderOwnEntity, Boolean canAccessCalenderUnderneath, Boolean canAccessCalenderSameLevel,
			Boolean canAccessCalenderSameLevelAndBellow, Boolean canAccessAll) {
		super();
		this.adminAgendaPermissions = new HashMap<>();
		this.adminAgendaPermissions.put("CAN_CHANGE_WORKHOURS", canChangeWorkHours);
		this.adminAgendaPermissions.put("CAN_CHANGE_OWN_ENTITY", canChangeOwnEntity);
		this.adminAgendaPermissions.put("CAN_CHANGE_DIRECT_UNDERNEATH", canChangeUnderneath);
		this.adminAgendaPermissions.put("CAN_CHANGE_SAME_LEVEL", canChangeSameLevel);
		this.adminAgendaPermissions.put("CAN_CHANGE_ALL_SAME_LEVEL_AND_BELLOW", canChangeSameLevelAndBellow);
		this.adminAgendaPermissions.put("CALENDER_CAN_ACCESS_OWN", canAccessOwnCalender);
		this.adminAgendaPermissions.put("CALENDER_CAN_ACCESS_OWN_ENTITY", canAccessCalenderOwnEntity);
		this.adminAgendaPermissions.put("CALENDER_CAN_ACCESS_DIRECT_UNDERNEATH", canAccessCalenderUnderneath);
		this.adminAgendaPermissions.put("CALENDER_CAN_ACCESS_SAME_LEVEL", canAccessCalenderSameLevel);
		this.adminAgendaPermissions.put("CALENDER_CAN_ACCESS_ALL_SAME_LEVEL_AND_BELLOW",
				canAccessCalenderSameLevelAndBellow);
		this.adminAgendaPermissions.put("CALENDER_CAN_ACCESS_ALL", canAccessAll);
	}

	/**
	 * Agenda Permissions
	 * 
	 * @param canChangeWorkHours
	 * 				Permission to change working hours
	 * 
	 * @param canAccessOwnCalender
	 * 				Permission to access own calendar
	 * 
	 * @param canAccessOtherCalenders
	 * 				Permission to access other calendars
	 */
	public AgendaPermissions(Boolean canChangeWorkHours, Boolean canAccessOwnCalender,
			Boolean canAccessOtherCalenders) {
		super();
		this.adminAgendaPermissions = new HashMap<>();
		if (!canChangeWorkHours) {
			this.adminAgendaPermissions.put("CAN_CHANGE_WORKHOURS", false);
			this.adminAgendaPermissions.put("CAN_CHANGE_OWN_ENTITY", false);
			this.adminAgendaPermissions.put("CAN_CHANGE_DIRECT_UNDERNEATH", false);
			this.adminAgendaPermissions.put("CAN_CHANGE_SAME_LEVEL", false);
			this.adminAgendaPermissions.put("CAN_CHANGE_ALL_SAME_LEVEL_AND_BELLOW", false);
		}
		this.adminAgendaPermissions.put("CALENDER_CAN_ACCESS_OWN", canAccessOwnCalender);
		if (!canAccessOtherCalenders) {
			this.adminAgendaPermissions.put("CALENDER_CAN_ACCESS_OWN_ENTITY", false);
			this.adminAgendaPermissions.put("CALENDER_CAN_ACCESS_DIRECT_UNDERNEATH", false);
			this.adminAgendaPermissions.put("CALENDER_CAN_ACCESS_SAME_LEVEL", false);
			this.adminAgendaPermissions.put("CALENDER_CAN_ACCESS_ALL_SAME_LEVEL_AND_BELLOW", false);
			this.adminAgendaPermissions.put("CALENDER_CAN_ACCESS_ALL", false);
		}
	}

	/**
	 * 
	 * Agenda Permissions
	 * 
	 * @param adminAgendaPermissions
	 * 				Admin permission for agenda
	 */
	public AgendaPermissions(Map<String, Boolean> adminAgendaPermissions) {
		super();
		this.adminAgendaPermissions = adminAgendaPermissions;
	}

	@Override
	public Map<String, Boolean> getPermissionSettings() {
		return this.adminAgendaPermissions;
	}

	@Override
	public void setPermissionSettings(Map<String, Boolean> permissions) {
		this.adminAgendaPermissions = permissions;
	}

	@Override
	public void addPermissionSetting(String permissionName, Boolean permissionValue) {
		this.adminAgendaPermissions.put(permissionName, permissionValue);
	}

}
