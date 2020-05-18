package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response holder for REST operation
 * 
 * @author Sasa Radovanovic
 *
 */
public class TranslatableSubCategoriesProductList implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<TranslatableClientProductSubCategoryItem> subCategoryProductList;

	/**
	 * default constructor for Translatable SubCategories Product List
	 */
	public TranslatableSubCategoriesProductList() {
		super();
		this.subCategoryProductList = new ArrayList<>();
	}

	/**
	 * Translatable SubCategories Product List
	 * 
	 * @param subCategoryProductList
	 * 				Subcategory product list
	 */
	public TranslatableSubCategoriesProductList(
			List<TranslatableClientProductSubCategoryItem> subCategoryProductList) {
		super();
		this.subCategoryProductList = subCategoryProductList;
	}

	public List<TranslatableClientProductSubCategoryItem> getSubCategoryProductList() {
		return subCategoryProductList;
	}

	public void setSubCategoryProductList(List<TranslatableClientProductSubCategoryItem> subCategoryProductList) {
		this.subCategoryProductList = subCategoryProductList;
	}
}
