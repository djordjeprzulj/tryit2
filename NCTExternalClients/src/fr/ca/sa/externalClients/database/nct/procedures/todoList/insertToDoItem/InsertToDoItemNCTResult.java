package fr.ca.sa.externalClients.database.nct.procedures.todoList.insertToDoItem;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning added eventId on TODO list item insert
 * 
 * @author Nemanja Ignjatov
 *
 */
public class InsertToDoItemNCTResult implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int eventId;

	/**
	 * default constructor for Insert ToDo Item NCT Result
	 */
	public InsertToDoItemNCTResult() {
		super();
	}

	/**
	 * Insert ToDo Item NCT Result
	 * 
	 * @param eventId
	 * 				Event ID
	 */
	public InsertToDoItemNCTResult(int eventId) {
		super();
		this.eventId = eventId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "InsertToDoItemNCTResult [eventId= " + eventId + " ]";
	}

}
