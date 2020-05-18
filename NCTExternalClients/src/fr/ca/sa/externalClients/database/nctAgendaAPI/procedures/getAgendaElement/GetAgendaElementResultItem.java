package fr.ca.sa.externalClients.database.nctAgendaAPI.procedures.getAgendaElement;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.AgendaElement;

/**
 * 
 * @author Jelena Raca
 *
 */
public class GetAgendaElementResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private AgendaElement agendaElement;

	/**
	 * default constructor for Get Agenda Element Result Item
	 */
	public GetAgendaElementResultItem() {
		super();
	}

	/**
	 * Get Agenda Element Result Item
	 * 
	 * @param agendaElement
	 * 			Agenda element
	 * 
	 */
	public GetAgendaElementResultItem(AgendaElement agendaElement) {
		super();
		this.agendaElement = agendaElement;		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GetAgendaElementResultItem [agendaElement=" + agendaElement + "]";
	}
}
