package fr.ca.sa.model;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

public class ContactHistory implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer id;
	private IdName type;
	private String contactDate;
	private String offerType;
	private int offerId;
	private String offerName;
	private String offerStatus;
	private String channelName;
	private String originName;
	private String comment;
	private Integer dataSource;
	
	private Client client = new Client();
	private Collaborator advisor = new Collaborator();
	
	public ContactHistory() {
		
	}
	
	public ContactHistory(Integer id, IdName type, Client client, Collaborator advisor) {
		super();
		this.id = id;
		this.type = type;
		this.client = client;
		this.advisor = advisor;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IdName getType() {
		return type;
	}

	public void setType(IdName type) {
		this.type = type;
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

	public String getContactDate() {
		return contactDate;
	}

	public void setContactDate(String contactDate) {
		this.contactDate = contactDate;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getDataSource() {
		return dataSource;
	}

	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public String toString() {
		return "ContactHistory [id=" + id + ", type=" + type + ", contactDate=" + contactDate + ", offerType="
				+ offerType + ", offerId=" + offerId + ", offerName=" + offerName + ", offerStatus=" + offerStatus
				+ ", channelName=" + channelName + ", originName=" + originName + ", comment=" + comment
				+ ", dataSource=" + dataSource + ", client=" + client + ", advisor=" + advisor + "]";
	}
	
}
