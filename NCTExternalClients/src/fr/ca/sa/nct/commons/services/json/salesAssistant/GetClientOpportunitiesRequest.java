package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request for getting client opportunities from catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientOpportunitiesRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int clientId;

	/**
	 * default constructor for Get Client Opportunities Request
	 */
	public GetClientOpportunitiesRequest() {
		super();
	}

	/**
	 * Get Client Opportunities Request
	 * 
	 * @param clientId
	 * 				Client ID
	 */
	public GetClientOpportunitiesRequest(Integer clientId) {
		super();
		this.clientId = clientId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "GetClientOpportunitiesRequest [clientId=" + clientId + "]";
	}

}
