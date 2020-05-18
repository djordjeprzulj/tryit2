package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class OpportunitiesSubCategoriesTranslatableItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int subcategoryId;
	private int categoryId;
	private Map<String, String> subcategoryNames;

	/**
	 * default constructor for Opportunities SubCategories Translatable Item
	 */
	public OpportunitiesSubCategoriesTranslatableItem() {
		super();
		this.subcategoryNames = new HashMap<String, String>();
	}

	/**
	 * Opportunities SubCategories Translatable Item
	 * 
	 * @param subcategoryId
	 * 				Subcategory ID
	 * 
	 * @param categoryId
	 * 				Category ID
	 * 
	 * @param subcategoryNames
	 * 				Subcategory names
	 */
	public OpportunitiesSubCategoriesTranslatableItem(int subcategoryId, int categoryId,
			Map<String, String> subcategoryNames) {
		super();
		this.subcategoryId = subcategoryId;
		this.categoryId = categoryId;
		this.subcategoryNames = subcategoryNames;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public Map<String, String> getSubcategoryNames() {
		return subcategoryNames;
	}

	public void setSubcategoryNames(Map<String, String> subcategoryNames) {
		this.subcategoryNames = subcategoryNames;
	}

	@Override
	public String toString() {
		return "OpportunitiesSubCategoriesTranslatableItem [categoryId=" + categoryId + ", subcategoryId="
				+ subcategoryId + ", subcategoryNames=" + subcategoryNames + "]";
	}

}
