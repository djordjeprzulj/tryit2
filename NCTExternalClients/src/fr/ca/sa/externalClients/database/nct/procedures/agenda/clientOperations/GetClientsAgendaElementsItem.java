package fr.ca.sa.externalClients.database.nct.procedures.agenda.clientOperations;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.AgendaElement;

/**
 * 
 * Holder client agenda elements, single item
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetClientsAgendaElementsItem implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private AgendaElement agendaElement;
	
	/**
	 * default constructor for Get Clients Agenda Elements Item
	 */
	public GetClientsAgendaElementsItem() {
		super();
	}

	/**
	 * Get Clients Agenda Elements Item
	 * 
	 * @param agendaElement
	 * 				Agenda element
	 * 
	 */
	public GetClientsAgendaElementsItem(AgendaElement agendaElement) {
		super();
		this.agendaElement = agendaElement;
	}

	public AgendaElement getAgendaElement() {
		return agendaElement;
	}

	public void setAgendaElementId(AgendaElement agendaElement) {
		this.agendaElement = agendaElement;
	}

	@Override
	public String toString() {
		return "GetClientsAgendaElementsItem [agendaElement=" + agendaElement + "]";
	}

}
