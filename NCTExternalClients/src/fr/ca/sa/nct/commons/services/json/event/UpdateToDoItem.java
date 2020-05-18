package fr.ca.sa.nct.commons.services.json.event;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * Wrapper for update TO DO item JSON messages
 * 
 * @author Jelena Stankovski
 *
 */
public class UpdateToDoItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int eventId;
	private String subject;
	private String reminderDate;
	private Integer clientId;
	private String comment;
	private int status;

	/**
	 * default constructor for Update ToDo Item
	 */
	public UpdateToDoItem() {
		super();
	}

	/**
	 * Update ToDo Item
	 * 
	 * @param eventId
	 * 				Event ID
	 * 
	 * @param subject
	 * 				Subject
	 * 
	 * @param reminderDate
	 * 				Reminder date
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param comment
	 * 				Comment
	 * 
	 * @param status
	 * 				Status
	 */
	public UpdateToDoItem(int eventId, String subject, String reminderDate, Integer clientId, String comment,
			int status) {
		super();
		this.eventId = eventId;
		this.subject = subject;
		this.reminderDate = reminderDate;
		this.clientId = clientId;
		this.comment = comment;
		this.status = status;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(String reminderDate) {
		this.reminderDate = reminderDate;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UpdateToDoItem [eventId=" + eventId + ", subject=" + subject + ", reminderDate=" + reminderDate
				+ ", clientId=" + clientId + ", comment=" + comment + ", status=" + status + "]";
	}

}
