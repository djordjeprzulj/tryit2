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
public class StatisticsPermissions implements Serializable, PermissionInterface {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, Boolean> statistics;
	/**
	 * 
	 * @param canAccessStatistics
	 */
	public StatisticsPermissions(Boolean canAccessStatistics) {
		this.statistics = new HashMap<>();
		this.statistics.put("CAN_ACCESS_STATISTICS", canAccessStatistics);
	}
	@Override
	public Map<String, Boolean> getPermissionSettings() {
		return this.statistics;
	}

	@Override
	public void setPermissionSettings(Map<String, Boolean> permissions) {
		this.statistics = permissions;

	}

	@Override
	public void addPermissionSetting(String permissionName, Boolean permissionValue) {
		this.statistics.put(permissionName, permissionValue);
	}
}
