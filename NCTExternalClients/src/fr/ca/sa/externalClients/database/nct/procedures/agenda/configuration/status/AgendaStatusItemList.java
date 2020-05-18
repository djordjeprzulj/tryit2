package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.status;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda status list holder
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaStatusItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<AgendaStatusItem> statusList;

	/**
	 * default constructor for Agenda Status Item List
	 */
	public AgendaStatusItemList() {
		super();
		this.statusList = new ArrayList<>();
	}

	/**
	 * Agenda Status Item List
	 * 
	 * @param statusList
	 * 				Status list
	 */
	public AgendaStatusItemList(List<AgendaStatusItem> statusList) {
		super();
		this.statusList = statusList;
	}

	public List<AgendaStatusItem> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<AgendaStatusItem> statusList) {
		this.statusList = statusList;
	}

	@Override
	public String toString() {
		return "AgendaStatusItemList [statusList=" + statusList + "]";
	}

}
