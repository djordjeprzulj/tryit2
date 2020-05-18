package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getCategories;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Wrapper for returning single item of opportunity category in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunitiesCategoriesNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int categoryId;
	private String categoryName;
	private int categoryCount;
	private String categoryPictureUri;

	/**
	 * default constructor for Get Opportunities Categories NCT Result Item
	 */
	public GetOpportunitiesCategoriesNCTResultItem() {
		super();
	}

	/**
	 * Get Opportunities Categories NCT Result Item
	 * 
	 * @param categoryId
	 * 				Category ID
	 * 
	 * @param categoryName
	 * 				Category name
	 * 
	 * @param categoryCount
	 * 				Category count
	 * 
	 * @param categoryPictureUri
	 * 				Category picture URI
	 */
	public GetOpportunitiesCategoriesNCTResultItem(int categoryId, String categoryName, int categoryCount,
			String categoryPictureUri) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryCount = categoryCount;
		this.categoryPictureUri = categoryPictureUri;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
		return "GetOpportunitiesCategoriesNCTResultItem [categoryId=" + categoryId + ", categoryName=" + categoryName
				+ ", categoryCount=" + categoryCount + ", categoryPictureUri=" + categoryPictureUri + "]";
	}

}
