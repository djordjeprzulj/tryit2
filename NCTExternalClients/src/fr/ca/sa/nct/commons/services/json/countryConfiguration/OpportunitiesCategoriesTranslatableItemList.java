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
public class OpportunitiesCategoriesTranslatableItemList implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<OpportunitiesCategoriesTranslatableItem> opportunityCategories;

	/**
	 * default constructor for Opportunities Categories Translatable Item List
	 */
	public OpportunitiesCategoriesTranslatableItemList() {
		super();
		this.opportunityCategories = new ArrayList<OpportunitiesCategoriesTranslatableItem>();
	}

	/**
	 * Opportunities Categories Translatable Item List
	 * 
	 * @param opportunityCategories
	 * 				Opportunity categories
	 */
	public OpportunitiesCategoriesTranslatableItemList(
			List<OpportunitiesCategoriesTranslatableItem> opportunityCategories) {
		super();
		this.opportunityCategories = opportunityCategories;
	}

	public List<OpportunitiesCategoriesTranslatableItem> getOpportunityCategories() {
		return opportunityCategories;
	}

	public void setOpportunityCategories(List<OpportunitiesCategoriesTranslatableItem> opportunityCategories) {
		this.opportunityCategories = opportunityCategories;
	}

	@Override
	public String toString() {
		return "OpportunitiesCategoriesTranslatableItemList [opportunityCategories=" + opportunityCategories + "]";
	}

}
