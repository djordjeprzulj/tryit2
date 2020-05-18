package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda item List (basic info)
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetAgendaItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetAgendaItem> agendaItems;

	/**
	 * default constructor for Get Agenda Item List
	 */
	public GetAgendaItemList() {
		super();
		this.agendaItems = new ArrayList<>();
	}

	/**
	 * Get Agenda Item List
	 * 
	 * @param agendaItems
	 * 				Agenda items
	 */
	public GetAgendaItemList(List<GetAgendaItem> agendaItems) {
		super();
		this.agendaItems = agendaItems;
	}

	public List<GetAgendaItem> getAgendaItems() {
		return agendaItems;
	}

	public void setAgendaItems(List<GetAgendaItem> agendaItems) {
		this.agendaItems = agendaItems;
	}

	/**
	 * Set Only Availability
	 */
	public void defineOnlyAvailability() {
		this.agendaItems.forEach(agendaItem -> {
			agendaItem.defineOnlyAvailability();
		});
	}

	@Override
	public String toString() {
		return "GetAgendaItemList [agendaItems=" + agendaItems + "]";
	}

}
