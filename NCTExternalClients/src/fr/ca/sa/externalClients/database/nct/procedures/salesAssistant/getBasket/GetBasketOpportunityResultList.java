package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for opportunity result list
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketOpportunityResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetBasketOpportunityResultItem> opportunityList;

	/**
	 * Get Basket Opportunity Result List
	 * 
	 * @param opportunityList
	 * 				Opportunity list
	 */
	public GetBasketOpportunityResultList(List<GetBasketOpportunityResultItem> opportunityList) {
		super();
		this.opportunityList = opportunityList;
	}

	/**
	 * default constructor for Get Basket Opportunity Result List
	 */
	public GetBasketOpportunityResultList() {
		super();
		this.opportunityList = new ArrayList<>();
	}

	public List<GetBasketOpportunityResultItem> getOpportunityList() {
		return opportunityList;
	}

	public void setOpportunityList(List<GetBasketOpportunityResultItem> opportunityList) {
		this.opportunityList = opportunityList;
	}

	@Override
	public String toString() {
		return "GetBasketOpportunityResultList [opportunityList=" + opportunityList + "]";
	}

}
