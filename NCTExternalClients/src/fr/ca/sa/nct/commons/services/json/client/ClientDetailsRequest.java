package fr.ca.sa.nct.commons.services.json.client;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request for client details from WSDL Service
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ClientDetailsRequest extends ClientGeneralInfoRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private boolean forceReload;
	private String syncToken;

	/**
	 * default constructor for Client Details Request
	 */
	public ClientDetailsRequest() {
		super();
	}

	/**
	 * Client Details Request
	 * 
	 * @param clientId    Client ID
	 * 
	 * @param portfolioId Portfolio ID
	 * 
	 * @param entityId    Entity ID
	 * 
	 * @param clientType  Client type
	 * 
	 * @param forceReload Force reload
	 */
	public ClientDetailsRequest(int clientId, Integer portfolioId, Integer entityId, String clientType,
			boolean forceReload, String syncToken) {
		super(clientId, portfolioId, entityId, clientType);
		this.forceReload = forceReload;
		this.syncToken = syncToken;
	}

	public boolean isForceReload() {
		return forceReload;
	}

	public void setForceReload(boolean forceReload) {
		this.forceReload = forceReload;
	}

	public String getSyncToken() {
		return syncToken;
	}

	public void setSyncToken(String syncToken) {
		this.syncToken = syncToken;
	}

}
