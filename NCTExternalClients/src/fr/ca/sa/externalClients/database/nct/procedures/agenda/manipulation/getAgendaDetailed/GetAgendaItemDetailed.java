package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaDetailed;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.model.AgendaElement;

/**
 * 
 * Agenda Item holder (with details)
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetAgendaItemDetailed implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private AgendaElement agendaElement;

	/**
	 * default constructor for Get Agenda Item Detailed
	 */
	public GetAgendaItemDetailed() {
		super();
	}

	/**
	 * Get Agenda Item Detailed
	 * 
	 * @param agendaElement
	 * 				Agenda element
	 *  
	 */
	public GetAgendaItemDetailed(AgendaElement agendaElement) {
		super();
		this.agendaElement = agendaElement;
	}

	public AgendaElement getAgendaElement() {
		return agendaElement;
	}

	public void setAgendaId(AgendaElement agendaElement) {
		this.agendaElement = agendaElement;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GetAgendaItemDetailed [agendaElement=" + agendaElement + "]";
	}
}
