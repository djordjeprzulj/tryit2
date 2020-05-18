package fr.ca.sa.nct.commons.services.json.common;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Cancel opportunity request
 * 
 * @author Sasa Radovanovic
 *
 */
public class CancelOpportunity implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer opportunityId;
	private Integer reasonId;
	private String cancelComment;

	private Integer advisorId;
	private Integer portfolioId;
	private Integer entityId;

	/**
	 * default constructor for Cancel Opportunity
	 */
	public CancelOpportunity() {
		super();
	}

	/**
	 * Cancel Opportunity
	 * 
	 * @param opportunityId
	 * 				Opportunity ID
	 * 
	 * @param reasonId
	 * 				Reason ID
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 * 
	 * @param entityId
	 * 				Entity ID
	 * 
	 * @param cancelComment
	 * 				Cancel comment
	 */
	public CancelOpportunity(Integer opportunityId, Integer reasonId, Integer advisorId, Integer portfolioId,
			Integer entityId, String cancelComment) {
		super();
		this.opportunityId = opportunityId;
		this.reasonId = reasonId;
		this.advisorId = advisorId;
		this.portfolioId = portfolioId;
		this.entityId = entityId;
		this.cancelComment = cancelComment;
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

	public Integer getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Integer advisorId) {
		this.advisorId = advisorId;
	}

	public Integer getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getCancelComment() {
		return cancelComment;
	}

	public void setCancelComment(String cancelComment) {
		this.cancelComment = cancelComment;
	}
}
