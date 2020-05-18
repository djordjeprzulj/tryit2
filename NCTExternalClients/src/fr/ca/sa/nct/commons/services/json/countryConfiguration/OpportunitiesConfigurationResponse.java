package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.nct.procedures.opportunities.getPriorities.GetOpportunitiesPrioritiesNCTResultItem;

/**
 * 
 * Response JSON wrapper for get opportunities configuration
 * 
 * @author Nemanja Ignjatov
 *
 */
public class OpportunitiesConfigurationResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetOpportunitiesPrioritiesNCTResultItem> priorities;
	private List<OpportunitiesSubCategoriesTranslatableItem> subcategories;
	private List<OpportunitiesCategoriesTranslatableItem> categories;
	private List<OpportunitiesCategoriesTranslatableItem> allCategories;
	private List<OpportunitiesCancellationReasonsTranslatableItem> cancelReasons;

	/**
	 * default constructor for Opportunities Configuration Response
	 */
	public OpportunitiesConfigurationResponse() {
		super();
	}

	/**
	 * Opportunities Configuration Response
	 * 
	 * @param priorities    Priorities
	 * 
	 * @param subcategories Subcategories
	 * 
	 * @param categories    Categories
	 * 
	 * @param allCategories All categories
	 * 
	 * @param cancelReasons Cancel reasons
	 */
	public OpportunitiesConfigurationResponse(List<GetOpportunitiesPrioritiesNCTResultItem> priorities,
			List<OpportunitiesSubCategoriesTranslatableItem> subcategories,
			List<OpportunitiesCategoriesTranslatableItem> categories,
			List<OpportunitiesCategoriesTranslatableItem> allCategories,
			List<OpportunitiesCancellationReasonsTranslatableItem> cancelReasons) {
		super();
		this.priorities = priorities;
		this.subcategories = subcategories;
		this.categories = categories;
		this.allCategories=allCategories;
		this.cancelReasons = cancelReasons;
	}

	public List<GetOpportunitiesPrioritiesNCTResultItem> getPriorities() {
		return priorities;
	}

	public void setPriorities(List<GetOpportunitiesPrioritiesNCTResultItem> priorities) {
		this.priorities = priorities;
	}

	public List<OpportunitiesSubCategoriesTranslatableItem> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<OpportunitiesSubCategoriesTranslatableItem> subcategories) {
		this.subcategories = subcategories;
	}

	public List<OpportunitiesCategoriesTranslatableItem> getCategories() {
		return categories;
	}

	public void setCategories(List<OpportunitiesCategoriesTranslatableItem> categories) {
		this.categories = categories;
	}

	public List<OpportunitiesCancellationReasonsTranslatableItem> getCancelReasons() {
		return cancelReasons;
	}

	public void setCancelReasons(List<OpportunitiesCancellationReasonsTranslatableItem> cancelReasons) {
		this.cancelReasons = cancelReasons;
	}

	public List<OpportunitiesCategoriesTranslatableItem> getAllCategories() {
		return allCategories;
	}

	public void setAllCategories(List<OpportunitiesCategoriesTranslatableItem> allCategories) {
		this.allCategories = allCategories;
	}

}
