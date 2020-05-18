package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request for opportunity product from catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunityProductsRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer opportunityId;

	private int clientId;

	/**
	 * default constructor for Get Opportunity Products Request
	 */
	public GetOpportunityProductsRequest() {
		super();
	}

	/**
	 * Get Opportunity Products Request
	 * 
	 * @param opportunityId
	 * 				Opportunity ID
	 * 
	 * @param clientId
	 * 				Client ID
	 */
	public GetOpportunityProductsRequest(Integer opportunityId, int clientId) {
		super();
		this.opportunityId = opportunityId;
		this.clientId = clientId;
	}

	public Integer getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(Integer opportunityId) {
		this.opportunityId = opportunityId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "GetOpportunityProductsRequest [opportunityId=" + opportunityId + ", clientId=" + clientId + "]";
	}

}
