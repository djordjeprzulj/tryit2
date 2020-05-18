package fr.ca.sa.nct.commons.services.json.event;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class TreatOpportunity implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer opportunityId;
	private Integer reasonId;
	private String comment;

	/**
	 * default constructor for Treat Opportunity
	 */
	public TreatOpportunity() {
		super();
	}

	/**
	 * Treat Opportunity
	 * 
	 * @param opportunityId
	 * 				Opportunity ID
	 * 
	 * @param reasonId
	 * 				Reason ID
	 * 
	 * @param comment
	 * 				Comment
	 */
	public TreatOpportunity(Integer opportunityId, Integer reasonId, String comment) {
		super();
		this.opportunityId = opportunityId;
		this.reasonId = reasonId;
		this.comment = comment;
	}

	public Integer getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(Integer opportunityId) {
		this.opportunityId = opportunityId;
	}

	public Integer getReasonId() {
		return reasonId;
	}

	public void setReasonId(Integer reasonId) {
		this.reasonId = reasonId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "TreatOpportunity [opportunityId=" + opportunityId + ", reasonId=" + reasonId + ", comment=" + comment
				+ "]";
	}

}
