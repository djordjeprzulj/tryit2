package fr.ca.sa.nct.commons.authorizationUtils.permissionHolders;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.PermissionInterface;

public class AuditPermissions  implements Serializable, PermissionInterface {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, Boolean> audit;

	public AuditPermissions(Boolean canAccessAudit) {
		this.audit = new HashMap<>();
		this.audit.put("CAN_ACCESS_AUDIT", canAccessAudit);
	}
	@Override
	public Map<String, Boolean> getPermissionSettings() {
		return this.audit;
	}

	@Override
	public void setPermissionSettings(Map<String, Boolean> permissions) {
		this.audit = permissions;

	}

	@Override
	public void addPermissionSetting(String permissionName, Boolean permissionValue) {
		this.audit.put(permissionName, permissionValue);
	}
}
