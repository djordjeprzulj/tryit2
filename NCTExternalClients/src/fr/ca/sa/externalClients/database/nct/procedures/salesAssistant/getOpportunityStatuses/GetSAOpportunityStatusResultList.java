package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getOpportunityStatuses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * List holder for SA Opportunity Statuses
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetSAOpportunityStatusResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetSAOpportunityStatusResultItem> opportunityStatuses;

	/**
	 * default constructor for Get Sales Assistant Opportunity Status Result List
	 */
	public GetSAOpportunityStatusResultList() {
		super();
		this.opportunityStatuses = new ArrayList<>();
	}

	/**
	 * Get Sales Assistant Opportunity Status Result List
	 * 
	 * @param opportunityStatuses
	 * 				Opportunity statuses list
	 */
	public GetSAOpportunityStatusResultList(List<GetSAOpportunityStatusResultItem> opportunityStatuses) {
		super();
		this.opportunityStatuses = opportunityStatuses;
	}

	public List<GetSAOpportunityStatusResultItem> getOpportunityStatuses() {
		return opportunityStatuses;
	}

	public void setOpportunityStatuses(List<GetSAOpportunityStatusResultItem> opportunityStatuses) {
		this.opportunityStatuses = opportunityStatuses;
	}

	@Override
	public String toString() {
		return "GetSAOpportunityStatusResultList [opportunityStatuses=" + opportunityStatuses + "]";
	}
}
