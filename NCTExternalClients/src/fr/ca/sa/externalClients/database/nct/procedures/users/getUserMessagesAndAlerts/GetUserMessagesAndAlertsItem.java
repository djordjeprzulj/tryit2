package fr.ca.sa.externalClients.database.nct.procedures.users.getUserMessagesAndAlerts;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * User messages and alerts item
 * 
 * @author Stefan Djokic
 *
 */
public class GetUserMessagesAndAlertsItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer messageId;
	private String messageText;
	private String clientType;
	private Integer clientId;
	private Integer clientEntityId;
	private Integer portfolioId;

	/**
	 * default constructor for Get User Messages And Alerts Item
	 */
	public GetUserMessagesAndAlertsItem() {
		super();
	}

	/**
	 * Get User Messages And Alerts Item
	 * 
	 * @param messageId
	 * 				Message ID
	 * 
	 * @param messageText
	 * 				Message text
	 * 
	 * @param clientType
	 * 				Client type
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param clientEntityId
	 * 				Client entity ID
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 */
	public GetUserMessagesAndAlertsItem(Integer messageId, String messageText, String clientType, Integer clientId,
			Integer clientEntityId, Integer portfolioId) {
		super();
		this.messageId = messageId;
		this.messageText = messageText;
		this.clientType = clientType;
		this.clientId = clientId;
		this.clientEntityId = clientEntityId;
		this.portfolioId = portfolioId;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getClientEntityId() {
		return clientEntityId;
	}

	public void setClientEntityId(Integer clientEntityId) {
		this.clientEntityId = clientEntityId;
	}

	public Integer getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}

	@Override
	public String toString() {
		return "GetUserMessagesAndAlertsItem [messageId=" + messageId + ", messageText=" + messageText + ", clientType="
				+ clientType + ", clientId=" + clientId + ", clientEntityId=" + clientEntityId + ", portfolioId="
				+ portfolioId + "]";
	}

}
