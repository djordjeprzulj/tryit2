package fr.ca.sa.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;

public class AgendaElement implements Serializable {
	
	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer id;
	private Integer typeId;
	private String startTime;
	private String endTime;
	private String title;
	private Integer agendaId;
	private String typeBackColor;
	private Integer available;
	private Boolean visible;
	private Boolean isParticipant;
	private Integer statusId;
	private String owner;
	
	private String preparationComment;
	private String comment;

	private Integer contactId;
	private Integer messageTypeId;
	private String messageText;
	private Integer purposeId;	//	ObjectId from the database
	private String place;
	private Integer weeklyFrequency;
	private Integer reminderTime;
	private Integer closeReasonId;
	private String closureComment;
	private Integer locationId;
	private Integer originId;
	private Integer durationId;
	private Integer cancelReasonId;
	private String cancelComment;
	private List<Collaborator> participants = new ArrayList<Collaborator>();
	private String creationDate;
	private String createdBy;
	private String lastModificationDate;
	private String lastModifiedBy;
	private Integer purpose;
	private Integer salesbasketListId;
	private String participantList;
	private Collaborator advisor = new Collaborator();
	
	private Client client = new Client();
	private Entity entity = new Entity();
	
	public AgendaElement() {
		super();
	}
	
	public AgendaElement(Integer id, Integer typeId, Timestamp startTime, Timestamp endTime) {
		super();
		this.id = id;
		this.typeId = typeId;
		SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
		Date startDate = new Date(startTime.getTime());
		Date endDate = new Date(endTime.getTime());
		this.startTime = formatter.format(startDate);
		this.endTime = formatter.format(endDate);
	}

	public AgendaElement(Integer id, Integer typeId, Timestamp startTime, Timestamp endTime,
			String title, Integer agendaId, String typeBackColor, Integer available, Integer visible,
			Integer participant, Integer statusId, String owner) {
		this(id, typeId, startTime, endTime);
		this.title = title;
		this.agendaId = agendaId;
		this.typeBackColor = typeBackColor;
		this.available = available;
		if (participant != null) {
			this.isParticipant = (participant != 0);
		} else {
			this.isParticipant = false;
		}
		
		this.visible = (visible != 0);
		this.statusId = statusId;
		this.owner = owner;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(Integer agendaId) {
		this.agendaId = agendaId;
	}

	public String getTypeBackColor() {
		return typeBackColor;
	}

	public void setTypeBackColor(String typeBackColor) {
		this.typeBackColor = typeBackColor;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer avaliable) {
		this.available = avaliable;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getIsParticipant() {
		return this.isParticipant;
	}

	public void setIsParticipant(Boolean isParticipant) {
		this.isParticipant = isParticipant;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}	

	public String getPreparationComment() {
		return preparationComment;
	}

	public void setPreparationComment(String preparationComment) {
		this.preparationComment = preparationComment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collaborator getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Collaborator advisor) {
		this.advisor = advisor;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public Integer getMessageTypeId() {
		return messageTypeId;
	}

	public void setMessageTypeId(Integer messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Integer getPurposeId() {
		return purposeId;
	}

	public void setPurposeId(Integer purposeId) {
		this.purposeId = purposeId;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Integer getWeeklyFrequency() {
		return weeklyFrequency;
	}

	public void setWeeklyFrequency(Integer weeklyFrequency) {
		this.weeklyFrequency = weeklyFrequency;
	}

	public Integer getReminderTime() {
		return reminderTime;
	}

	public void setReminderTime(Integer reminderTime) {
		this.reminderTime = reminderTime;
	}

	public Integer getCloseReasonId() {
		return closeReasonId;
	}

	public void setCloseReasonId(Integer closeReasonId) {
		this.closeReasonId = closeReasonId;
	}

	public String getClosureComment() {
		return closureComment;
	}

	public void setClosureComment(String closureComment) {
		this.closureComment = closureComment;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Integer getOriginId() {
		return originId;
	}

	public void setOriginId(Integer originId) {
		this.originId = originId;
	}

	public Integer getDurationId() {
		return durationId;
	}

	public void setDurationId(Integer durationId) {
		this.durationId = durationId;
	}

	public Integer getCancelReasonId() {
		return cancelReasonId;
	}

	public void setCancelReasonId(Integer cancelReasonId) {
		this.cancelReasonId = cancelReasonId;
	}

	public String getCancelComment() {
		return cancelComment;
	}

	public void setCancelComment(String cancelComment) {
		this.cancelComment = cancelComment;
	}

	public List<Collaborator> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Collaborator> participants) {
		this.participants = participants;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(String lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Integer getPurpose() {
		return purpose;
	}

	public void setPurpose(Integer purpose) {
		this.purpose = purpose;
	}

	public List<Integer> getParticipantsIds() {
		List<Integer> participantsIds = this.participants.stream()
				.map(p -> p.getId())
				.collect(Collectors.toList());
		return participantsIds;
	}

	public Integer getSalesbasketListId() {
		return salesbasketListId;
	}

	public void setSalesbasketListId(Integer salesbasketListId) {
		this.salesbasketListId = salesbasketListId;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public String getParticipantList() {
		return participantList;
	}

	public void setParticipantList(String participantList) {
		this.participantList = participantList;
	}

}
