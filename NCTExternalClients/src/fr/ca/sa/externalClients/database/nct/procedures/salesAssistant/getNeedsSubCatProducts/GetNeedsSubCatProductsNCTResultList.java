package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getNeedsSubCatProducts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for needs subcat products list retrieved from database. Used in
 * pair with @GetNeedsNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetNeedsSubCatProductsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetNeedsSubCatProductsNCTResultItem> needsSubCatProducts;

	/**
	 * default constructor for Get Needs Subcategory Products NCT Result List
	 */
	public GetNeedsSubCatProductsNCTResultList() {
		this.needsSubCatProducts = new ArrayList<GetNeedsSubCatProductsNCTResultItem>();
	}

	/**
	 * Get Needs Subcategory Products NCT Result List
	 * 
	 * @param needsSubCatProducts
	 * 				Needs subcategory products
	 */
	public GetNeedsSubCatProductsNCTResultList(List<GetNeedsSubCatProductsNCTResultItem> needsSubCatProducts) {
		super();
		this.needsSubCatProducts = needsSubCatProducts;
	}

	public List<GetNeedsSubCatProductsNCTResultItem> getNeedsSubCatProducts() {
		return needsSubCatProducts;
	}

	public void setNeedsSubCatProducts(List<GetNeedsSubCatProductsNCTResultItem> needsSubCatProducts) {
		this.needsSubCatProducts = needsSubCatProducts;
	}

	@Override
	public String toString() {
		return "GetNeedsSubCatProductsNCTResultList [needsSubCatProducts=" + needsSubCatProducts + "]";
	}

}
