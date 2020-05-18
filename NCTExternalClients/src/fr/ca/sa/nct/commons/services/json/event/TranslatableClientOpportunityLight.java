package fr.ca.sa.nct.commons.services.json.event;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Translatable Holder for Client opportunities on CS and QCR endpoints
 * 
 * @author Nemanja Ignjatov
 *
 */
public class TranslatableClientOpportunityLight implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int opportunityId;
	private int opportunityTypeId;
	private Map<String, String> opportunityNames;
	private int opportunityStateId;
	private String opportunityStartDate;
	private String opportunityExpirationDate;
	private String treatmentPeriod;
	private String opportunityScriptLink;
	private String opportunityPictureUri;
	private Integer cancel;
	private Integer treatOL;
	private Integer treatQCR;
	
	/**
	 * Translatable Client Opportunity Light
	 * 
	 * @param opportunityId
	 * 				Opportunity ID
	 * 
	 * @param opportunityTypeId
	 * 				Opportunity type ID
	 * 
	 * @param opportunityStateId
	 * 				Opportunity state ID
	 * 
	 * @param opportunityStartDate
	 * 				Opportunity start date
	 * 
	 * @param opportunityExpirationDate
	 * 				Opportunity expiration date
	 * 
	 * @param treatmentPeriod
	 * 				Treatment period
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
	 * 				Treat on quick report
	 */
	public TranslatableClientOpportunityLight(int opportunityId, int opportunityTypeId, int opportunityStateId,
			String opportunityStartDate, String opportunityExpirationDate, String treatmentPeriod,
			String opportunityScriptLink, String opportunityPictureUri, Integer cancel, Integer treatOL,
			Integer treatQCR) {
		super();
		this.opportunityId = opportunityId;
		this.opportunityTypeId = opportunityTypeId;
		this.opportunityStateId = opportunityStateId;
		this.opportunityStartDate = opportunityStartDate;
		this.opportunityExpirationDate = opportunityExpirationDate;
		this.treatmentPeriod = treatmentPeriod;
		this.opportunityScriptLink = opportunityScriptLink;
		this.opportunityPictureUri = opportunityPictureUri;
		this.opportunityNames = new HashMap<String, String>();
		this.cancel = cancel;
		this.treatOL = treatOL;
		this.treatQCR = treatQCR;
	}

	public int getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(int opportunityId) {
		this.opportunityId = opportunityId;
	}

	public int getOpportunityTypeId() {
		return opportunityTypeId;
	}

	public void setOpportunityTypeId(int opportunityTypeId) {
		this.opportunityTypeId = opportunityTypeId;
	}

	public Map<String, String> getOpportunityNames() {
		return opportunityNames;
	}

	public void setOpportunityNames(Map<String, String> opportunityNames) {
		this.opportunityNames = opportunityNames;
	}

	public int getOpportunityStateId() {
		return opportunityStateId;
	}

	public void setOpportunityStateId(int opportunityStateId) {
		this.opportunityStateId = opportunityStateId;
	}

	public String getOpportunityStartDate() {
		return opportunityStartDate;
	}

	public void setOpportunityStartDate(String opportunityStartDate) {
		this.opportunityStartDate = opportunityStartDate;
	}

	public String getOpportunityExpirationDate() {
		return opportunityExpirationDate;
	}

	public void setOpportunityExpirationDate(String opportunityExpirationDate) {
		this.opportunityExpirationDate = opportunityExpirationDate;
	}

	public String getTreatmentPeriod() {
		return treatmentPeriod;
	}

	public void setTreatmentPeriod(String treatmentPeriod) {
		this.treatmentPeriod = treatmentPeriod;
	}

	public String getOpportunityScriptLink() {
		return opportunityScriptLink;
	}

	public void setOpportunityScriptLink(String opportunityScriptLink) {
		this.opportunityScriptLink = opportunityScriptLink;
	}

	public String getOpportunityPictureUri() {
		return opportunityPictureUri;
	}

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
		return "TranslatableClientOpportunityLight [opportunityId=" + opportunityId + ", opportunityTypeId="
				+ opportunityTypeId + ", opportunityNames=" + opportunityNames + ", opportunityStateId="
				+ opportunityStateId + ", opportunityStartDate=" + opportunityStartDate + ", opportunityExpirationDate="
				+ opportunityExpirationDate + ", treatmentPeriod=" + treatmentPeriod + ", opportunityScriptLink="
				+ opportunityScriptLink + ", opportunityPictureUri=" + opportunityPictureUri + ", cancel=" + cancel
				+ ", treatOL=" + treatOL + ", treatQCR=" + treatQCR + "]";
	}

	
}
