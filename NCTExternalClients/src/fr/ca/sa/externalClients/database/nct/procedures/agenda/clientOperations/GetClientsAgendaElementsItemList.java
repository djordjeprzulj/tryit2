package fr.ca.sa.externalClients.database.nct.procedures.agenda.clientOperations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Holder agenda elements item list
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetClientsAgendaElementsItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetClientsAgendaElementsItem> clientsAgendaItems;

	/**
	 * default constructor for Get Clients Agenda Elements ItemList
	 */
	public GetClientsAgendaElementsItemList() {
		super();
		this.clientsAgendaItems = new ArrayList<>();
	}

	/**
	 * Get Clients Agenda Elements Item List
	 * 
	 * @param clientsAgendaItems
	 * 				Clients agenda items
	 */
	public GetClientsAgendaElementsItemList(List<GetClientsAgendaElementsItem> clientsAgendaItems) {
		super();
		this.clientsAgendaItems = clientsAgendaItems;
	}

	public List<GetClientsAgendaElementsItem> getClientsAgendaItems() {
		return clientsAgendaItems;
	}

	public void setClientsAgendaItems(List<GetClientsAgendaElementsItem> clientsAgendaItems) {
		this.clientsAgendaItems = clientsAgendaItems;
	}

	@Override
	public String toString() {
		return "GetClientsAgendaElementsItemList [clientsAgendaItems=" + clientsAgendaItems + "]";
	}

}
