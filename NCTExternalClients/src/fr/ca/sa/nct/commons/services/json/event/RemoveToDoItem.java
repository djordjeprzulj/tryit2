package fr.ca.sa.nct.commons.services.json.event;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Wrapper for remove TO DO item JSON messages
 * 
 * @author Nemanja Ignjatov
 *
 */
public class RemoveToDoItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int eventId;

	public RemoveToDoItem() {
	}

	/**
	 * Remove todo Item
	 * 
	 * @param eventId
	 * 				Event ID
	 */
	public RemoveToDoItem(int eventId) {
		super();
		this.eventId = eventId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

}
