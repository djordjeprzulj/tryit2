package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getClientActiveOpportunities;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.Opportunity;

/**
 * 
 * Wrapper for returning single item of users opportunity in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientActiveOpportunitiesNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Opportunity opportunity;
	private String opportunitySubCatategoryL1;
	private String opportunitySubCatategoryL2;
	
	
	private Integer opportunityStateId;
	private String opportunityScriptLink;
	private String opportunityPictureUri;
	private Integer cancel;
	private Integer treatOL;
	private Integer treatQCR;

	/**
	 * default constructor for Get Client Active Opportunities NCT Result Item
	 */
	public GetClientActiveOpportunitiesNCTResultItem() {
		super();
	}

	/**
	 * Get Client Active Opportunities NCT Result Item
	 * 
	 * @param opportunity
	 * 				Opportunity
	 * 
	 * @param opportunitySubCatategoryL1
	 * 				Opportunity subcategory in first language
	 * 
	 * @param opportunitySubCatategoryL2
	 * 				Opportunity subcategory in second language
	 * 
	 * @param opportunityStateId
	 * 				Opportunity state ID
	 * 
	 * @param opportunityScriptLink
	 * 				Opportunity script link
	 * 
	 * @param opportunityPictureUri
	 * 				Opportunity picture URI
	 * 
	 * @param cancel
	 * 				Cancel
	 * 
	 * @param treatOL
	 * 				Treat on opportunity list
	 * 
	 * @param treatQCR
	 * 				Treat on quick contact report
	 */
	public GetClientActiveOpportunitiesNCTResultItem(Opportunity opportunity,
			String opportunitySubCatategoryL1, String opportunitySubCatategoryL2,
			Integer opportunityStateId, String opportunityScriptLink, String opportunityPictureUri, 
			Integer cancel, Integer treatOL, Integer treatQCR) {
		super();
		this.opportunity = opportunity;
		this.opportunitySubCatategoryL1 = opportunitySubCatategoryL1;
		this.opportunitySubCatategoryL2 = opportunitySubCatategoryL2;
		this.opportunityStateId = opportunityStateId;
		this.opportunityScriptLink = opportunityScriptLink;
		this.opportunityPictureUri = opportunityPictureUri;
		this.cancel = cancel;
		this.treatOL = treatOL;
		this.treatQCR = treatQCR;
	}

	/**
	 * @return the opportunityId
	 */
	public Opportunity getOpportunity() {
		return opportunity;
	}

	/**
	 * @param opportunityId the opportunityId to set
	 */
	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}

	/**
	 * @return the opportunitySubCatategoryL1
	 */
	public String getOpportunitySubCatategoryL1() {
		return opportunitySubCatategoryL1;
	}

	/**
	 * @param opportunitySubCatategoryL1 the opportunitySubCatategoryL1 to set
	 */
	public void setOpportunitySubCatategoryL1(String opportunitySubCatategoryL1) {
		this.opportunitySubCatategoryL1 = opportunitySubCatategoryL1;
	}

	/**
	 * @return the opportunitySubCatategoryL2
	 */
	public String getOpportunitySubCatategoryL2() {
		return opportunitySubCatategoryL2;
	}

	/**
	 * @param opportunitySubCatategoryL2 the opportunitySubCatategoryL2 to set
	 */
	public void setOpportunitySubCatategoryL2(String opportunitySubCatategoryL2) {
		this.opportunitySubCatategoryL2 = opportunitySubCatategoryL2;
	}

	/**
	 * @return the opportunityStateId
	 */
	public Integer getOpportunityStateId() {
		return opportunityStateId;
	}

	/**
	 * @param opportunityStateId the opportunityStateId to set
	 */
	public void setOpportunityStateId(Integer opportunityStateId) {
		this.opportunityStateId = opportunityStateId;
	}

	/**
	 * @return the opportunityScriptLink
	 */
	public String getOpportunityScriptLink() {
		return opportunityScriptLink;
	}

	/**
	 * @param opportunityScriptLink the opportunityScriptLink to set
	 */
	public void setOpportunityScriptLink(String opportunityScriptLink) {
		this.opportunityScriptLink = opportunityScriptLink;
	}

	/**
	 * @return the opportunityPictureUri
	 */
	public String getOpportunityPictureUri() {
		return opportunityPictureUri;
	}

	/**
	 * @param opportunityPictureUri the opportunityPictureUri to set
	 */
	public void setOpportunityPictureUri(String opportunityPictureUri) {
		this.opportunityPictureUri = opportunityPictureUri;
	}

	/**
	 * @return the cancel
	 */
	public Integer getCancel() {
		return cancel;
	}

	/**
	 * @param cancel the cancel to set
	 */
	public void setCancel(Integer cancel) {
		this.cancel = cancel;
	}

	/**
	 * @return the treatOL
	 */
	public Integer getTreatOL() {
		return treatOL;
	}

	/**
	 * @param treatOL the treatOL to set
	 */
	public void setTreatOL(Integer treatOL) {
		this.treatOL = treatOL;
	}

	/**
	 * @return the treatQCR
	 */
	public Integer getTreatQCR() {
		return treatQCR;
	}

	/**
	 * @param treatQCR the treatQCR to set
	 */
	public void setTreatQCR(Integer treatQCR) {
		this.treatQCR = treatQCR;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GetClientActiveOpportunitiesNCTResultItem [opportunity=" + opportunity + 
				", opportunitySubCatategoryL1=" + opportunitySubCatategoryL1
				+ ", opportunitySubCatategoryL2=" + opportunitySubCatategoryL2 
				+ ", opportunityStateId=" + opportunityStateId
				+ ", opportunityScriptLink=" + opportunityScriptLink + ", opportunityPictureUri="
				+ opportunityPictureUri + ", cancel=" + cancel + ", treatOL=" + treatOL + ", treatQCR=" + treatQCR
				+ "]";
	}


}
