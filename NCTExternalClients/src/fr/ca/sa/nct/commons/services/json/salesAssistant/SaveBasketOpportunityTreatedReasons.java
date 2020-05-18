package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SaveBasketOpportunityTreatedReasons implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int opportunityId;
	private int opportunityTreatedReasonId;

	/**
	 * default constructor for Save Basket Opportunity Treated Reasons
	 */
	public SaveBasketOpportunityTreatedReasons() {
		super();
	}

	/**
	 * Save Basket Opportunity Treated Reasons
	 * 
	 * @param opportunityId
	 * 				Opportunity ID
	 * 
	 * @param opportunityTreatedReasonId
	 * 				Opportunity treated reason ID
	 */
	public SaveBasketOpportunityTreatedReasons(int opportunityId, int opportunityTreatedReasonId) {
		super();
		this.opportunityId = opportunityId;
		this.opportunityTreatedReasonId = opportunityTreatedReasonId;
	}

	public int getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(int opportunityId) {
		this.opportunityId = opportunityId;
	}

	public int getOpportunityTreatedReasonId() {
		return opportunityTreatedReasonId;
	}

	public void setOpportunityTreatedReasonId(int opportunityTreatedReasonId) {
		this.opportunityTreatedReasonId = opportunityTreatedReasonId;
	}

}
