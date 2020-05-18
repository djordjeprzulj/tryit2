package fr.ca.sa.nct.commons.services.json.agenda;

import java.util.List;

import fr.ca.sa.externalClients.database.common.procedures.worktime.getWorktime.GetBankEntityWorkTimeNCTResultList;
import fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgenda.GetAgendaItemList;
import fr.ca.sa.nct.commons.authorizationUtils.PermissionInterface;
import fr.ca.sa.nct.commons.authorizationUtils.permissionHolders.AgendaItemsPermission;

/**
 * 
 * Response on agenda request
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaResponse {

	private PermissionInterface permissions;

	private List<GetBankEntityWorkTimeNCTResultList> workTimes;

	private GetAgendaItemList agendaItemEntries;

	/**
	 * default constructor for Agenda Response
	 */
	public AgendaResponse() {
		super();
		this.permissions = new AgendaItemsPermission(false, false, false, false, false, false);
		this.agendaItemEntries = new GetAgendaItemList();
	}

	/**
	 * Agenda Response
	 * 
	 * @param permissions
	 * 				Permissions
	 * 
	 * @param workTimes
	 * 				Work times
	 * 
	 * @param agendaItems
	 * 				Agenda items
	 */
	public AgendaResponse(PermissionInterface permissions, List<GetBankEntityWorkTimeNCTResultList> workTimes,
			GetAgendaItemList agendaItems) {
		super();
		this.permissions = permissions;
		this.workTimes = workTimes;
		this.agendaItemEntries = agendaItems;
	}

	public PermissionInterface getPermissions() {
		return permissions;
	}

	public void setPermissions(PermissionInterface permissions) {
		this.permissions = permissions;
	}

	public List<GetBankEntityWorkTimeNCTResultList> getWorkTimes() {
		return workTimes;
	}

	public void setWorkTimes(List<GetBankEntityWorkTimeNCTResultList> workTimes) {
		this.workTimes = workTimes;
	}

	public GetAgendaItemList getAgendaItemEntries() {
		return agendaItemEntries;
	}

	public void setAgendaItemEntries(GetAgendaItemList agendaItemEntries) {
		this.agendaItemEntries = agendaItemEntries;
	}
}
