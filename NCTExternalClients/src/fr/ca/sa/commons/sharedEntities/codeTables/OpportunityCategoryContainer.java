package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class OpportunityCategoryContainer implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int categoryId;
	private Map<String, String> oppCategoryNames;
	private List<OpportunitySubCategoryContainer> oppSubCategories;

	/**
	 * default constructor for Opportunity Category Container
	 */
	public OpportunityCategoryContainer() {
		super();
		this.oppCategoryNames = new HashMap<String, String>();
		this.oppSubCategories = new ArrayList<OpportunitySubCategoryContainer>();
	}

	/**
	 * Opportunity Category Container
	 * 
	 * @param categoryId
	 * 				Category ID
	 * 
	 * @param oppCategoryNames
	 * 				Opportunity category name
	 * 
	 * @param oppSubCategories
	 * 				Opportunity sub categories
	 */
	public OpportunityCategoryContainer(int categoryId, Map<String, String> oppCategoryNames,
			List<OpportunitySubCategoryContainer> oppSubCategories) {
		super();
		this.categoryId = categoryId;
		this.oppCategoryNames = oppCategoryNames;
		this.oppSubCategories = oppSubCategories;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Map<String, String> getOppCategoryNames() {
		return oppCategoryNames;
	}

	public void setOppCategoryNames(Map<String, String> oppCategoryNames) {
		this.oppCategoryNames = oppCategoryNames;
	}

	public List<OpportunitySubCategoryContainer> getOppSubCategories() {
		return oppSubCategories;
	}

	public void setOppSubCategories(List<OpportunitySubCategoryContainer> oppSubCategories) {
		this.oppSubCategories = oppSubCategories;
	}

	@Override
	public String toString() {
		return "OpportunityCategoryContainer [categoryId=" + categoryId + ", oppCategoryNames=" + oppCategoryNames
				+ ", oppSubCategories=" + oppSubCategories + "]";
	}

}
