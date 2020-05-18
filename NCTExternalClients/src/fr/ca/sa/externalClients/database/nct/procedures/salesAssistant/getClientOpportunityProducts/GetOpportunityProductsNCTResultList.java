package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientOpportunityProducts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for opportunity products list retrieved from database. Used in
 * pair with @GetOpportunityProductsNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunityProductsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetOpportunityProductsNCTResultItem> products;

	/**
	 * default constructor for Get Opportunity Products NCT Result List
	 */
	public GetOpportunityProductsNCTResultList() {
		super();
		products = new ArrayList<>();
	}

	/**
	 * Get Opportunity Products NCT Result List
	 * 
	 * @param products
	 * 				Products
	 */
	public GetOpportunityProductsNCTResultList(List<GetOpportunityProductsNCTResultItem> products) {
		super();
		this.products = products;
	}

	public List<GetOpportunityProductsNCTResultItem> getProducts() {
		return products;
	}

	public void setProducts(List<GetOpportunityProductsNCTResultItem> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "GetOpportunityProductsNCTResultList [products=" + products + "]";
	}

}
