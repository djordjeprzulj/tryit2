package fr.ca.sa.nct.commons.services.json.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response for fetching client details from external service
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ClientDetailsResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int clientId;

	private List<String> asyncMessagesTokens;

	private String syncToken;

	private Long lastUpdated;

	/**
	 * default constructor for Client Details Response
	 */
	public ClientDetailsResponse() {
		super();
	}

	/**
	 * Client Details Response
	 * 
	 * @param clientId
	 * 				Client ID
	 */
	public ClientDetailsResponse(int clientId) {
		super();
		this.clientId = clientId;
		this.asyncMessagesTokens = new ArrayList<String>();
	}

	/**
	 * Client Details Response
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param lastUpdated
	 * 				Last updated
	 */
	public ClientDetailsResponse(int clientId, Long lastUpdated) {
		super();
		this.clientId = clientId;
		this.asyncMessagesTokens = new ArrayList<String>();
		this.lastUpdated = lastUpdated;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public List<String> getAsyncMessagesTokens() {
		return asyncMessagesTokens;
	}

	public void setAsyncMessagesTokens(List<String> asyncMessagesTokens) {
		this.asyncMessagesTokens = asyncMessagesTokens;
	}

	public Long getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getSyncToken() {
		return syncToken;
	}

	public void setSyncToken(String syncToken) {
		this.syncToken = syncToken;
	}

}
