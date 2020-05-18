package fr.ca.sa.model;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

public class Basket implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer originId;
	
	private Collaborator advisor = new Collaborator();
	
	private Client client = new Client();
	
	private String basketDate;
	
	private String timeSpent;

	private Integer channelId;
	
	private String comment;
	
	private String createdDate;

	private String createdBy;
	
	private String modifiedDate;
	
	private Integer agendaElementId;
	
	public Basket() {
		
	}

	public Basket(Integer originId, Collaborator advisor, Client client, String basketDate, String timeSpent,
			Integer channelId, String comment, String createdDate, String modifiedDate) {
		super();
		this.originId = originId;
		this.advisor = advisor;
		this.client = client;
		this.basketDate = basketDate;
		this.timeSpent = timeSpent;
		this.channelId = channelId;
		this.comment = comment;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public Integer getOriginId() {
		return originId;
	}

	public void setOriginId(Integer originId) {
		this.originId = originId;
	}

	public Collaborator getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Collaborator advisor) {
		this.advisor = advisor;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getBasketDate() {
		return basketDate;
	}

	public void setBasketDate(String basketDate) {
		this.basketDate = basketDate;
	}

	public String getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(String timeSpent) {
		this.timeSpent = timeSpent;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public Integer getAgendaElementId() {
		return agendaElementId;
	}

	public void setAgendaElementId(Integer agendaElementId) {
		this.agendaElementId = agendaElementId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "Basket [originId=" + originId + ", advisor=" + advisor + ", client=" + client + ", basketDate="
				+ basketDate + ", timeSpent=" + timeSpent + ", channelId=" + channelId + ", comment=" + comment
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
