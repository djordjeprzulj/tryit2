package fr.ca.sa.nct.commons.services.json.quickContactReport;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class QCROpportunityStatesRequest implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer opportunityId;

	private Integer oldStateId;

	private Integer newStateId;

	/**
	 * default constructor for QCR Opportunity States Request
	 */
	public QCROpportunityStatesRequest() {
		super();
	}

	/**
	 * QCR Opportunity States Request
	 * 
	 * @param opportunityId
	 * 				Opportunity ID
	 * 
	 * @param oldStateId
	 * 				Old state ID
	 * 
	 * @param newStateId
	 * 				New state ID
	 */
	public QCROpportunityStatesRequest(Integer opportunityId, Integer oldStateId, Integer newStateId) {
		super();
		this.opportunityId = opportunityId;
		this.oldStateId = oldStateId;
		this.newStateId = newStateId;
	}

	public Integer getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(Integer opportunityId) {
		this.opportunityId = opportunityId;
	}

	public Integer getOldStateId() {
		return oldStateId;
	}

	public void setOldStateId(Integer oldStateId) {
		this.oldStateId = oldStateId;
	}

	public Integer getNewStateId() {
		return newStateId;
	}

	public void setNewStateId(Integer newStateId) {
		this.newStateId = newStateId;
	}
}
