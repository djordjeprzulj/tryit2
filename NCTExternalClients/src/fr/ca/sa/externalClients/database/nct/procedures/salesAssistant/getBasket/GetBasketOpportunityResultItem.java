package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.model.Opportunity;

/**
 * 
 * Data holder for opportunity result item
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketOpportunityResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Opportunity opportunity;

	/**
	 * default constructor for Get Basket Opportunity Result Item
	 */
	public GetBasketOpportunityResultItem() {
		super();
	}

	/**
	 * Get Basket Opportunity 
	 * 
	 * @param opportunity
	 * 				Opportunity
	 * 
	 */
	public GetBasketOpportunityResultItem(Opportunity opportunity) {
		super();
		this.opportunity = opportunity;
	}

	public Opportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}

}
