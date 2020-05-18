package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getProductCatalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for products list retrieved from database. Used in pair
 * with @GetProductCatalogNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetProductCatalogNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetProductCatalogNCTResultItem> productsCatalog;

	/**
	 * default constructor for Get Products Groups NCT Result List
	 */
	public GetProductCatalogNCTResultList() {
		super();
		productsCatalog = new ArrayList<>();
	}

	/**
	 * Get Products Groups NCT Result List
	 * 
	 * @param productsCatalog
	 *            Products catalog
	 */
	public GetProductCatalogNCTResultList(List<GetProductCatalogNCTResultItem> productsCatalog) {
		super();
		this.productsCatalog = productsCatalog;
	}

	public List<GetProductCatalogNCTResultItem> getProductsCatalog() {
		return productsCatalog;
	}

	public void setProductsCatalog(List<GetProductCatalogNCTResultItem> productsCatalog) {
		this.productsCatalog = productsCatalog;
	}

	@Override
	public String toString() {
		return "GetProductCatalogNCTResultList [productsCatalog=" + productsCatalog + "]";
	}

}
