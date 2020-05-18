package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityTreatedReasons;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunityTreatedReasonsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int opportunityTreatedReasonId;
	private String opportunityTreatedReasonName;

	/**
	 * default constructor for Get Opportunity Treated Reasons NCT Result Item
	 */
	public GetOpportunityTreatedReasonsNCTResultItem() {
		super();
	}

	/**
	 * Get Opportunity Treated Reasons NCT Result Item
	 * 
	 * @param opportunityTreatedReasonId
	 * 				Opportunity treated reason ID
	 * 
	 * @param opportunityTreatedReasonName
	 * 				Opportunity treated reason name
	 */
	public GetOpportunityTreatedReasonsNCTResultItem(int opportunityTreatedReasonId,
			String opportunityTreatedReasonName) {
		super();
		this.opportunityTreatedReasonId = opportunityTreatedReasonId;
		this.opportunityTreatedReasonName = opportunityTreatedReasonName;
	}

	public int getOpportunityTreatedReasonId() {
		return opportunityTreatedReasonId;
	}

	public void setOpportunityTreatedReasonId(int opportunityTreatedReasonId) {
		this.opportunityTreatedReasonId = opportunityTreatedReasonId;
	}

	public String getOpportunityTreatedReasonName() {
		return opportunityTreatedReasonName;
	}

	public void setOpportunityTreatedReasonName(String opportunityTreatedReasonName) {
		this.opportunityTreatedReasonName = opportunityTreatedReasonName;
	}

	@Override
	public String toString() {
		return "GetOpportunityTreatedReasonsNCTResultItem [opportunityTreatedReasonId=" + opportunityTreatedReasonId
				+ ", opportunityTreatedReasonName=" + opportunityTreatedReasonName + "]";
	}

}
