package fr.ca.sa.nct.commons.authorizationUtils.permissionHolders;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.PermissionInterface;

/**
 * 
 * Agenda items permission holder (Check implementation for specific permission
 * flags)
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaItemsPermission implements Serializable, PermissionInterface {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, Boolean> agendaPermissions;

	/**
	 * Agenda Items Permission
	 * 
	 * @param viewAvailibity
	 * 				View availability
	 * 
	 * @param viewSubject
	 * 				Permission to view subject
	 * 
	 * @param viewDetailed
	 * 				Permission to view detailed
	 * 
	 * @param create
	 * 				Permission to create
	 * 
	 * @param update
	 * 				Permission to update
	 * 
	 * @param reassign
	 * 				Permission to reassign
	 */
	public AgendaItemsPermission(Boolean viewAvailibity, Boolean viewSubject, Boolean viewDetailed, Boolean create,
			Boolean update, Boolean reassign) {
		super();
		this.agendaPermissions = new HashMap<>();
		this.agendaPermissions.put("VIEW_AVAILABILITY", viewAvailibity);
		this.agendaPermissions.put("VIEW_SUBJECT", viewSubject);
		this.agendaPermissions.put("VIEW_DETAILED", viewDetailed);
		this.agendaPermissions.put("CREATE", create);
		this.agendaPermissions.put("UPDATE", update);
		this.agendaPermissions.put("REASSIGN", reassign);
	}

	@Override
	public Map<String, Boolean> getPermissionSettings() {
		return agendaPermissions;
	}

	@Override
	public void setPermissionSettings(Map<String, Boolean> permissions) {
		this.agendaPermissions = permissions;
	}

	@Override
	public void addPermissionSetting(String permissionName, Boolean permissionValue) {
		this.agendaPermissions.put(permissionName, permissionValue);
	}

}
