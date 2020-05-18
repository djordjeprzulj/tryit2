package fr.ca.sa.nctManagement.commons.authorizationUtils;

import java.util.Map;

/**
 * 
 * Permission interface (added in response decoration process)
 * 
 * @author Sasa Radovanovic
 *
 */
public interface MngmtPermissionInterface {
	/**
	 * 
	 * @return permission settings
	 */
	public Map<String, Boolean> getPermissionSettings();

	/**
	 * Set permission settings
	 * 
	 * @param permissions
	 */
	public void setPermissionSettings(Map<String, Boolean> permissions);

	/**
	 * Add permission settings
	 * 
	 * @param permissionName
	 * @param permissionValue
	 */
	public void addPermissionSetting(String permissionName, Boolean permissionValue);

}
