package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getProductCatalog;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.Product;

/**
 * 
 * Single product catalog data holder retrieved from database
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetProductCatalogNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Product product;	

	/**
	 * default constructor for Get Products Groups NCT Result Item
	 */
	public GetProductCatalogNCTResultItem() {
		super();
	}

	/**
	 * Get Product Catalog NCT Result Item
	 * 
	 * @param product
	 * 			Product
	 * 
	 */
	public GetProductCatalogNCTResultItem(Product product) {
		super();
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
