package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class OpportunitiesSubCategoriesTranslatableItemList implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<OpportunitiesSubCategoriesTranslatableItem> opportunitySubCategories;

	/**
	 * default constructor for Opportunities SubCategories Translatable Item List
	 */
	public OpportunitiesSubCategoriesTranslatableItemList() {
		super();
		this.opportunitySubCategories = new ArrayList<OpportunitiesSubCategoriesTranslatableItem>();
	}

	/**
	 * Opportunities SubCategories Translatable Item List
	 * 
	 * @param opportunitySubCategories
	 * 				Opportunity subcategories
	 */
	public OpportunitiesSubCategoriesTranslatableItemList(
			List<OpportunitiesSubCategoriesTranslatableItem> opportunitySubCategories) {
		super();
		this.opportunitySubCategories = opportunitySubCategories;
	}

	public List<OpportunitiesSubCategoriesTranslatableItem> getOpportunitySubCategories() {
		return opportunitySubCategories;
	}

	public void setOpportunitySubCaytegories(
			List<OpportunitiesSubCategoriesTranslatableItem> opportunitySubCategories) {
		this.opportunitySubCategories = opportunitySubCategories;
	}

	@Override
	public String toString() {
		return "OpportunitiesSubCategoriesTranslatableItemList [opportunitySubCategories=" + opportunitySubCategories
				+ "]";
	}

}
