package fr.ca.sa.nct.commons.services.json.event;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunityDetailsRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer opportunityId;

	/**
	 * default constructor for Get Opportunity Details Request
	 */
	public GetOpportunityDetailsRequest() {
		super();
	}

	/**
	 * Get Opportunity Details Request
	 * 
	 * @param opportunityId
	 * 				Opportunity ID
	 */
	public GetOpportunityDetailsRequest(Integer opportunityId) {
		super();
		this.opportunityId = opportunityId;
	}

	public Integer getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(Integer opportunityId) {
		this.opportunityId = opportunityId;
	}

	@Override
	public String toString() {
		return "GetOpportunityDetailsRequest [opportunityId=" + opportunityId + "]";
	}

}
