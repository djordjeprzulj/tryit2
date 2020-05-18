package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgenda;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.model.AgendaElement;

/**
 * 
 * Agenda item holder (with basic info)
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetAgendaItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private AgendaElement agendaElement;


	/**
	 * default constructor for Get Agenda Item
	 */
	public GetAgendaItem() {
		super();
	}

	/**
	 * Get Agenda Item
	 * 
	 * @param agendaElement
	 * 				Agenda element
	 * 
	 */
	public GetAgendaItem(AgendaElement agendaElement) {
		super();
		this.agendaElement = agendaElement;
	}

	public AgendaElement getAgendaElement() {
		return agendaElement;
	}

	public void setAgendaElementId(AgendaElement agendaElement) {
		this.agendaElement = agendaElement;
	}

	/**
	 * Set only Availability 
	 */
	public void defineOnlyAvailability() {
		this.agendaElement.setId(-1);
		this.agendaElement.setTypeId(-1);
		this.agendaElement.setTitle(null);
		this.agendaElement.setTypeBackColor(null);
		this.agendaElement.setAvailable(-1);
		this.agendaElement.setIsParticipant(false);
	}


	@Override
	public String toString() {
		return "GetAgendaItem [agendaElement=" + agendaElement + "]";
	}

}
