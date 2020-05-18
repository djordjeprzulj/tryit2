package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityCategory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunityCategoryNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetOpportunityCategoryNCTResultItem> opportunityCategories;

	/**
	 * default constructor for Get Opportunity Category NCT Result List
	 */
	public GetOpportunityCategoryNCTResultList() {
		super();
		this.opportunityCategories = new ArrayList<GetOpportunityCategoryNCTResultItem>();
	}

	/**
	 * Get Opportunity Category NCT Result List
	 * 
	 * @param opportunityCategories
	 * 				Opportunity categories
	 */
	public GetOpportunityCategoryNCTResultList(List<GetOpportunityCategoryNCTResultItem> opportunityCategories) {
		super();
		this.opportunityCategories = opportunityCategories;
	}

	public List<GetOpportunityCategoryNCTResultItem> getOpportunityCategories() {
		return opportunityCategories;
	}

	public void setOpportunityCategories(List<GetOpportunityCategoryNCTResultItem> opportunityCategories) {
		this.opportunityCategories = opportunityCategories;
	}

	@Override
	public String toString() {
		return "GetOpportunityCategoryNCTResultList [opportunityCategories=" + opportunityCategories + "]";
	}

}
