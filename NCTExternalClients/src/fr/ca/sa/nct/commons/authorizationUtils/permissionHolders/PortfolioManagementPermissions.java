package fr.ca.sa.nct.commons.authorizationUtils.permissionHolders;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.PermissionInterface;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class PortfolioManagementPermissions implements Serializable, PermissionInterface {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, Boolean> portfolioManagement;

	/**
	 * Portfolio Management Permissions
	 * 
	 * @param canAccessPortfolio
	 * 				Permission to access portfolio
	 */
	public PortfolioManagementPermissions(Boolean canAccessPortfolio) {
		this.portfolioManagement = new HashMap<>();
		this.portfolioManagement.put("CAN_ACCESS_PORTFOLIO", canAccessPortfolio);
	}

	@Override
	public void setPermissionSettings(Map<String, Boolean> permissions) {
		this.portfolioManagement = permissions;

	}

	@Override
	public void addPermissionSetting(String permissionName, Boolean permissionValue) {
		this.portfolioManagement.put(permissionName, permissionValue);
	}

	@Override
	public Map<String, Boolean> getPermissionSettings() {
		return portfolioManagement;
	}

}
