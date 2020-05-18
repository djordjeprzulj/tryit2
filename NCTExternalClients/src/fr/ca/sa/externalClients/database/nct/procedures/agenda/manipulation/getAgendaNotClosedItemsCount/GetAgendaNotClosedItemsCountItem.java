package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaNotClosedItemsCount;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetAgendaNotClosedItemsCountItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int notClosedItemsCount;

	/**
	 * default constructor for Get Agenda Not Closed Items Count Item
	 */
	public GetAgendaNotClosedItemsCountItem() {
		super();
	}

	/**
	 * Get Agenda Not Closed Items Count Item
	 * 
	 * @param notClosedItemsCount
	 * 				Not closed items count
	 */
	public GetAgendaNotClosedItemsCountItem(int notClosedItemsCount) {
		super();
		this.notClosedItemsCount = notClosedItemsCount;
	}

	public int getNotClosedItemsCount() {
		return notClosedItemsCount;
	}

	public void setNotClosedItemsCount(int notClosedItemsCount) {
		this.notClosedItemsCount = notClosedItemsCount;
	}

	@Override
	public String toString() {
		return "GetAgendaNotClosedItemsCountItem [notClosedItemsCount=" + notClosedItemsCount + "]";
	}

}
