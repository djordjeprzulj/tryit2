package fr.ca.sa.nct.commons.services.json.event;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Wrapper for insert TO DO item JSON messages response
 * 
 * @author Nemanja Ignjatov
 *
 */

public class InsertToDoItemResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer collaboratorId;
	private int eventId;
	private String subject;
	private String reminderDate;
	private Integer clientId;
	private String comment;
	private int status;

	/**
	 * default constructor for Insert ToDo Item Response
	 */
	public InsertToDoItemResponse() {
	}

	/**
	 * Insert ToDo Item Response
	 * 
	 * @param collaboratorId
	 * 				Collaborator ID
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
	 * 				Client
	 * 
	 * @param eventId
	 * 				Event ID
	 * 
	 * @param status
	 * 				Status 
	 */
	public InsertToDoItemResponse(Integer collaboratorId, String subject, String reminderDate, Integer clientId,
			String comment, int eventId, int status) {
		super();
		this.collaboratorId = collaboratorId;
		this.subject = subject;
		this.reminderDate = reminderDate;
		this.clientId = clientId;
		this.comment = comment;
		this.eventId = eventId;
		this.status = status;
	}

	public Integer getCollaboratorId() {
		return collaboratorId;
	}

	public void setCollaboratorId(Integer collaboratorId) {
		this.collaboratorId = collaboratorId;
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
		return "InsertToDoItemResponse [collaboratorId=" + collaboratorId + ", eventId=" + eventId + ", subject="
				+ subject + ", reminderDate=" + reminderDate + ", clientId=" + clientId + ", comment=" + comment
				+ ", status=" + status + "]";
	}

}
