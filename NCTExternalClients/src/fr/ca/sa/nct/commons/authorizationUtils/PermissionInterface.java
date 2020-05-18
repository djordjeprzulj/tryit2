package fr.ca.sa.nct.commons.authorizationUtils;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * Permission interface (added in response decoration process)
 * 
 * @author Sasa Radovanovic
 *
 */
public interface PermissionInterface extends Serializable {

	/**
	 * Return permission settings
	 * 
	 * @return Map which keys are permission and values are true/false
	 */
	Map<String, Boolean> getPermissionSettings();

	/**
	 * Set permission settings
	 * 
	 * @param permissions
	 *            Map that contains pairs permission name / value (true/false)
	 */
	void setPermissionSettings(Map<String, Boolean> permissions);

	/**
	 * Add single permission setting
	 * 
	 * @param permissionName
	 *            Permission name
	 * @param permissionValue
	 *            Permission value (true/false)
	 */
	void addPermissionSetting(String permissionName, Boolean permissionValue);

}
