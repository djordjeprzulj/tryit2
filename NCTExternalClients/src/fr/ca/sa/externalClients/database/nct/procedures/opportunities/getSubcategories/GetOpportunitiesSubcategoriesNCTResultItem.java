package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getSubcategories;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Wrapper for returning single item of opportunity subcategory in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunitiesSubcategoriesNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int categoryId;
	private int subcategoryId;
	private String subcategoryName;

	/**
	 * default constructor Get Opportunities Subcategories NCT Result Item
	 */
	public GetOpportunitiesSubcategoriesNCTResultItem() {
		super();
	}

	/**
	 * Get Opportunities Subcategories NCT Result Item
	 * 
	 * @param categoryId
	 * 				Category ID
	 * 
	 * @param subcategoryId
	 * 				Subcategory ID
	 * 
	 * @param subcategoryName
	 * 				Subcategory name
	 */
	public GetOpportunitiesSubcategoriesNCTResultItem(int categoryId, int subcategoryId, String subcategoryName) {
		super();
		this.categoryId = categoryId;
		this.subcategoryId = subcategoryId;
		this.subcategoryName = subcategoryName;
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

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	@Override
	public String toString() {
		return "GetOpportunitiesSubcategoriesNCTResultItem [subcategoryId=" + subcategoryId + ", subcategoryName="
				+ subcategoryName + "]";
	}

}
