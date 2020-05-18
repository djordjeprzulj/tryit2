package fr.ca.sa.nct.commons.services.json.salesAssistant;

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
public class TranslatableNeedSubCategory implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int subCategoryId;

	private Map<String, String> subCategoryNames;

	private List<TranslatableNeedSubCategoryProducts> products;

	/**
	 * default constructor for Translatable Need SubCategory
	 */
	public TranslatableNeedSubCategory() {
		super();
		this.products = new ArrayList<TranslatableNeedSubCategoryProducts>();
		this.subCategoryNames = new HashMap<String, String>();
	}

	/**
	 * Translatable Need SubCategory
	 * 
	 * @param subCategoryId
	 * 				Subcategory ID
	 */
	public TranslatableNeedSubCategory(int subCategoryId) {
		super();
		this.subCategoryId = subCategoryId;
		this.products = new ArrayList<TranslatableNeedSubCategoryProducts>();
		this.subCategoryNames = new HashMap<String, String>();
	}

	/**
	 * Translatable Need SubCategory
	 * 
	 * @param subCategoryId
	 * 				Subcategory ID
	 * 
	 * @param subCategoryNames
	 * 				Subcategory names
	 * 
	 * @param products
	 * 				Products
	 */
	public TranslatableNeedSubCategory(int subCategoryId, Map<String, String> subCategoryNames,
			List<TranslatableNeedSubCategoryProducts> products) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryNames = subCategoryNames;
		this.products = products;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public Map<String, String> getSubCategoryNames() {
		return subCategoryNames;
	}

	public void setSubCategoryNames(Map<String, String> subCategoryNames) {
		this.subCategoryNames = subCategoryNames;
	}

	public List<TranslatableNeedSubCategoryProducts> getProducts() {
		return products;
	}

	public void setProducts(List<TranslatableNeedSubCategoryProducts> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "TranslatableNeedSubCategory [subCategoryId=" + subCategoryId + ", subCategoryNames=" + subCategoryNames
				+ ", products=" + products + "]";
	}

}
