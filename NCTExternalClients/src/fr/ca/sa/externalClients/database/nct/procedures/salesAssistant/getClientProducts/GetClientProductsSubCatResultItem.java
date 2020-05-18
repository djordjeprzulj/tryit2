package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientProducts;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Holder for sub category in client products
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetClientProductsSubCatResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer subCategoryId;

	private Map<String, String> names;

	private List<GetClientProductsNCTResultItem> products;

	/**
	 * default constructor for Get Client Products Sub Cat Result Item
	 */
	public GetClientProductsSubCatResultItem() {
		super();
	}

	/**
	 * Get Client Products Sub Cat Result Item
	 * 
	 * @param subCategoryId
	 * 				Subcategory ID
	 * 
	 * @param names
	 * 				Names
	 * 
	 * @param products
	 * 				Products
	 */
	public GetClientProductsSubCatResultItem(Integer subCategoryId, Map<String, String> names,
			List<GetClientProductsNCTResultItem> products) {
		super();
		this.subCategoryId = subCategoryId;
		this.names = names;
		this.products = products;
	}

	public Integer getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public Map<String, String> getNames() {
		return names;
	}

	public void setNames(Map<String, String> names) {
		this.names = names;
	}

	public List<GetClientProductsNCTResultItem> getProducts() {
		return products;
	}

	public void setProducts(List<GetClientProductsNCTResultItem> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "GetClientProductsSubCatResultItem [subCategoryId=" + subCategoryId + ", names=" + names + ", products="
				+ products + "]";
	}

}
