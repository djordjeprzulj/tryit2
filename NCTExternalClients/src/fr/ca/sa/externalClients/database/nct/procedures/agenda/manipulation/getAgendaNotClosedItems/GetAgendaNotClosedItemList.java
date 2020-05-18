package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaNotClosedItems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.model.AgendaElement;

/**
 * 
 * Agenda item List (not closed appointments)
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetAgendaNotClosedItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<AgendaElement> agendaElements;

	/**
	 * default constructor for Get Agenda Not Closed Item List
	 */
	public GetAgendaNotClosedItemList() {
		super();
		this.agendaElements = new ArrayList<>();
	}

	/**
	 * Get Agenda Not Closed Item List
	 * 
	 * @param agendaelements
	 * 				Agenda items
	 */
	public GetAgendaNotClosedItemList(List<AgendaElement> agendaelements) {
		super();
		this.agendaElements = agendaelements;
	}

	public List<AgendaElement> getAgendaElements() {
		return agendaElements;
	}

	public void setAgendaItems(List<AgendaElement> agendaElements) {
		this.agendaElements = agendaElements;
	}

	@Override
	public String toString() {
		return "GetAgendaNotClosedItemList [agendaElements=" + agendaElements + "]";
	}

}
