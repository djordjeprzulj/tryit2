package fr.ca.sa.externalClients.database.nct.procedures.todoList.getToDoList;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.Client;

/**
 * 
 * Wrapper for returning single item of TO DO list in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetToDoListNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String reminderDate;
	private String subject;
	private String comment;
	private int eventId;
	private int status;

	private Client client;	

	/**
	 * default constructor for Get ToDo List NCT Result Item
	 */
	public GetToDoListNCTResultItem() {
		super();
	}

	/**
	 * Get ToDo List NCT Result Item
	 * 
	 * @param reminderDate
	 * 				Reminder date
	 * 
	 * @param subject
	 * 				Subject
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param comment
	 * 				Comment
	 * 
	 * @param eventId
	 * 				Event ID
	 * 
	 * @param status
	 * 				Status 
	 * 
	 * @param name
	 * 				Name
	 * 
	 * @param surname
	 * 				Surname 
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 * 
	 * @param entityId
	 * 				Entity ID
	 * 
	 * @param clientType
	 * 				Client type
	 */
	public GetToDoListNCTResultItem(String reminderDate, String subject, String comment, int eventId,
			int status, Client client) {
		super();
		this.reminderDate = reminderDate;
		this.subject = subject;
		this.comment = comment;
		this.eventId = eventId;
		this.status = status;
		this.client = client;
	}

	public String getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(String reminderDate) {
		this.reminderDate = reminderDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "GetToDoListNCTResultItem [reminderDate=" + reminderDate + ", subject=" + subject + ", client="
				+ client + ", comment=" + comment + ", eventId=" + eventId + ", status=" + status + "]";
	}

}
