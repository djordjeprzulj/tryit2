package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Holder for REST response regarding client products
 * 
 * @author Sasa Radovanovic
 *
 */
public class TranslatableClientProductSubCategoryItem implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer subCategoryId;

	private Map<String, String> subCategoryNames;

	private List<TranslatableClientProduct> clientProducts;

	/**
	 * default constructor for Translatable Client Product SubCategory Item
	 */
	public TranslatableClientProductSubCategoryItem() {
		super();
		this.clientProducts = new ArrayList<>();
		this.subCategoryNames = new HashMap<>();
	}

	/**
	 * Translatable Client Product SubCategory Item
	 * 
	 * @param subCategoryId
	 * 				Subcategory ID
	 * 
	 * @param subCategoryNames
	 * 				Subcategory names
	 * 
	 * @param clientProducts
	 * 				Client products
	 */
	public TranslatableClientProductSubCategoryItem(Integer subCategoryId, Map<String, String> subCategoryNames,
			List<TranslatableClientProduct> clientProducts) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryNames = subCategoryNames;
		this.clientProducts = clientProducts;
	}

	public Integer getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public Map<String, String> getSubCategoryNames() {
		return subCategoryNames;
	}

	public void setSubCategoryNames(Map<String, String> subCategoryNames) {
		this.subCategoryNames = subCategoryNames;
	}

	public List<TranslatableClientProduct> getClientProducts() {
		return clientProducts;
	}

	public void setClientProducts(List<TranslatableClientProduct> clientProducts) {
		this.clientProducts = clientProducts;
	}

}
