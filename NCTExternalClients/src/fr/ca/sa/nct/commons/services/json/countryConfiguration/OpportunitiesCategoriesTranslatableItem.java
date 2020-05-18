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
public class OpportunitiesCategoriesTranslatableItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int categoryId;
	private Map<String, String> categoryNames;
	private int categoryCount;
	private String categoryPictureUri;

	/**
	 * default constructor for Opportunities Categories Translatable Item
	 */
	public OpportunitiesCategoriesTranslatableItem() {
		super();
		this.categoryNames = new HashMap<String, String>();
	}

	/**
	 * Opportunities Categories Translatable Item
	 * 
	 * @param categoryId
	 * 				Category ID
	 * 
	 * @param categoryNames
	 * 				Category names
	 * 
	 * @param categoryCount
	 * 				Category count
	 * 
	 * @param categoryPictureUri
	 * 				Category picture URI
	 */
	public OpportunitiesCategoriesTranslatableItem(int categoryId, Map<String, String> categoryNames,
			int categoryCount, String categoryPictureUri) {
		super();
		this.categoryId = categoryId;
		this.categoryNames = categoryNames;
		this.categoryCount = categoryCount;
		this.categoryPictureUri = categoryPictureUri;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Map<String, String> getCategoryNames() {
		return categoryNames;
	}

	public void setCategoryNames(Map<String, String> categoryNames) {
		this.categoryNames = categoryNames;
	}

	public int getCategoryCount() {
		return categoryCount;
	}

	public void setCategoryCount(int categoryCount) {
		this.categoryCount = categoryCount;
	}

	public String getCategoryPictureUri() {
		return categoryPictureUri;
	}

	public void setCategoryPictureUri(String categoryPictureUri) {
		this.categoryPictureUri = categoryPictureUri;
	}

	@Override
	public String toString() {
		return "OpportunitiesCategoriesTranslatableItem [categoryId=" + categoryId + ", categoryNames=" + categoryNames
				+ ", categoryCount=" + categoryCount + ", categoryPictureUri=" + categoryPictureUri + "]";
	}

}
