package fr.ca.sa.nct.commons.services.json.client;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.Collaborator;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class TranslatableClientContactHistoryDetails implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int clientId;
	private int contactId;
	private int contactTypeId;
	private Map<String, String> contactType;
	private String contactDate;
	private Collaborator advisor;
	private Map<String, String> offerType;
	private int offerId;
	private Map<String, String> offerName;
	private Map<String, String> offerStatus;
	private Map<String, String> channelName;
	private Map<String, String> originName;
	private String comment;
	private String clientType;
	private Integer dataSource;

	/**
	 * default constructor for Translatable Client Contact History Details
	 */
	public TranslatableClientContactHistoryDetails() {
		super();
		this.contactType = new HashMap<String, String>();
		this.offerType = new HashMap<String, String>();
		this.offerName = new HashMap<String, String>();
		this.offerStatus = new HashMap<String, String>();
		this.channelName = new HashMap<String, String>();
		this.originName = new HashMap<String, String>();
	}

	/**
	 * Translatable Client Contact History Details
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param contactId
	 * 				Contact ID
	 * 
	 * @param contactTypeId
	 * 				Contact type ID
	 * 
	 * @param contactType
	 * 				Contact type
	 * 
	 * @param contactDate
	 * 				Contact date
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 * 
	 * @param advisorFirstName
	 * 				Advisor first name
	 * 
	 * @param advisorLastName
	 * 				Advisor last name
	 * 
	 * @param offerType
	 * 				Offer type
	 * 
	 * @param offerId
	 * 				Offer ID
	 * 
	 * @param offerName
	 * 				Offer name
	 * 
	 * @param offerStatus
	 * 				Offer status
	 * 
	 * @param channelName
	 * 				Channel name
	 * 
	 * @param originName
	 * 				Origin name
	 * 
	 * @param comment
	 * 				Comment
	 * 
	 * @param clientType
	 * 				Client type
	 */
	public TranslatableClientContactHistoryDetails(int clientId, int contactId, int contactTypeId,
			Map<String, String> contactType, String contactDate, Collaborator advisor, 
			Map<String, String> offerType, int offerId, Map<String, String> offerName,
			Map<String, String> offerStatus, Map<String, String> channelName,
			Map<String, String> originName, String comment, String clientType, Integer dataSource) {
		super();
		this.clientId = clientId;
		this.contactId = contactId;
		this.contactTypeId = contactTypeId;
		this.contactType = contactType;
		this.contactDate = contactDate;
		this.advisor = advisor;
		this.offerType = offerType;
		this.offerId = offerId;
		this.offerName = offerName;
		this.offerStatus = offerStatus;
		this.channelName = channelName;
		this.originName = originName;
		this.comment = comment;
		this.clientType = clientType;
		this.dataSource = dataSource;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public int getContactTypeId() {
		return contactTypeId;
	}

	public void setContactTypeId(int contactTypeId) {
		this.contactTypeId = contactTypeId;
	}

	public Map<String, String> getContactType() {
		return contactType;
	}

	public void setContactType(Map<String, String> contactType) {
		this.contactType = contactType;
	}

	public String getContactDate() {
		return contactDate;
	}

	public void setContactDate(String contactDate) {
		this.contactDate = contactDate;
	}

	public Collaborator getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Collaborator advisor) {
		this.advisor = advisor;
	}

	public Map<String, String> getOfferType() {
		return offerType;
	}

	public void setOfferType(Map<String, String> offerType) {
		this.offerType = offerType;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public Map<String, String> getOfferName() {
		return offerName;
	}

	public void setOfferName(Map<String, String> offerName) {
		this.offerName = offerName;
	}

	public Map<String, String> getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(Map<String, String> offerStatus) {
		this.offerStatus = offerStatus;
	}

	public Map<String, String> getChannelName() {
		return channelName;
	}

	public void setChannelName(Map<String, String> channelName) {
		this.channelName = channelName;
	}

	public Map<String, String> getOriginName() {
		return originName;
	}

	public void setOriginName(Map<String, String> originName) {
		this.originName = originName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public Integer getDataSource() {
		return dataSource;
	}

	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public String toString() {
		return "TranslatableClientContactHistoryDetails [clientId=" + clientId + ", contactId=" + contactId
				+ ", contactTypeId=" + contactTypeId + ", contactType=" + contactType + ", contactDate=" + contactDate
				+ ", advisor=" + advisor 
				+ ", offerType=" + offerType + ", offerId=" + offerId + ", offerName=" + offerName
				+ ", offerStatus=" + offerStatus + ", channelName=" + channelName + ", originName=" + originName
				+ ", comment=" + comment + ", clientType=" + clientType + ", dataSource=" + dataSource+ "]";
	}

}
