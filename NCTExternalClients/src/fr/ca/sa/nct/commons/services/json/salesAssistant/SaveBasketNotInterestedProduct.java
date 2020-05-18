package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Holder for partial request
 * 
 * @author Sasa Radovanovic
 *
 */
public class SaveBasketNotInterestedProduct implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<NotInterestedPairProduct> productList;

	/**
	 * default constructor for Save Basket Not Interested Product
	 */
	public SaveBasketNotInterestedProduct() {
		super();
	}

	/**
	 * Save Basket Not Interested Product
	 * 
	 * @param productList
	 * 				Product list
	 */
	public SaveBasketNotInterestedProduct(List<NotInterestedPairProduct> productList) {
		super();
		this.productList = productList;
	}

	public List<NotInterestedPairProduct> getProductList() {
		return productList;
	}

	public void setProductList(List<NotInterestedPairProduct> productList) {
		this.productList = productList;
	}

}
