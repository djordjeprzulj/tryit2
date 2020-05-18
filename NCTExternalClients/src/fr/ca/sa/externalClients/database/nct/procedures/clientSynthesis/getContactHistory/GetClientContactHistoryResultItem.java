package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getContactHistory;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Result Item for client contact history store procedure
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetClientContactHistoryResultItem implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer contactId;
	private Integer contactTypeId;
	private String contactDate;
	private Integer channelId;
	private Integer numberOfSoldProducts;
	private String externalLink;
	private String clientType;
	private Integer dataSource;

	/**
	 * Get Client Contact History Result Item
	 * 
	 * @param contactId
	 * 				Contact ID
	 * 
	 * @param contactTypeId
	 * 				Contact type ID
	 * 
	 * @param contactDate
	 * 				Contact date
	 * 
	 * @param channelId
	 * 				Channel ID
	 * 
	 * @param numberOfSoldProducts
	 * 				Number of sold products
	 * 
	 * @param externalLink
	 * 				External link
	 * 
	 * @param clientType
	 * 				Client type
	 */
	public GetClientContactHistoryResultItem(Integer contactId, Integer contactTypeId, Timestamp contactDate,
			Integer channelId, Integer numberOfSoldProducts, String externalLink, String clientType, Integer dataSource) {
		super();
		this.contactId = contactId;
		this.contactTypeId = contactTypeId;
		SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
		this.contactDate = formatter.format(contactDate);
		this.channelId = channelId;
		this.numberOfSoldProducts = numberOfSoldProducts;
		this.externalLink = externalLink;
		this.clientType = clientType;
		this.dataSource = dataSource;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public Integer getContactTypeId() {
		return contactTypeId;
	}

	public void setContactTypeId(Integer contactTypeId) {
		this.contactTypeId = contactTypeId;
	}

	public String getContactDate() {
		return contactDate;
	}

	public void setContactDate(String contactDate) {
		this.contactDate = contactDate;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public Integer getNumberOfSoldProducts() {
		return numberOfSoldProducts;
	}

	public void setNumberOfSoldProducts(Integer numberOfSoldProducts) {
		this.numberOfSoldProducts = numberOfSoldProducts;
	}

	public String getExternalLink() {
		return externalLink;
	}

	public void setExternalLink(String externalLink) {
		this.externalLink = externalLink;
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
		return "GetClientContactHistoryResultItem [contactId=" + contactId + ", contactTypeId=" + contactTypeId
				+ ", contactDate=" + contactDate + ", channelId=" + channelId + ", numberOfSoldProducts="
				+ numberOfSoldProducts + ", externalLink=" + externalLink + ", clientType=" + clientType + ", dataSource=" + dataSource + "]";
	}
}
