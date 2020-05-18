package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientProducts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for products list retrieved from database. Used in pair
 * with @GetProductsNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientProductsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetClientProductsNCTResultItem> products;

	/**
	 * default constructor for Get Client Products NCT Result List
	 */
	public GetClientProductsNCTResultList() {
		super();
		this.products = new ArrayList<>();
	}

	/**
	 * Get Client Products NCT Result List
	 * 
	 * @param products
	 * 				Products
	 */
	public GetClientProductsNCTResultList(List<GetClientProductsNCTResultItem> products) {
		super();
		this.products = products;
	}

	public List<GetClientProductsNCTResultItem> getProducts() {
		return products;
	}

	public void setProducts(List<GetClientProductsNCTResultItem> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "GetProductsNCTResultList [products=" + products + "]";
	}

}
