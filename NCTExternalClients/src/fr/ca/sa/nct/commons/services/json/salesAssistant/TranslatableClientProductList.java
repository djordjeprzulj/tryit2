package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class TranslatableClientProductList implements Serializable {

	private List<TranslatableClientProduct> clientProducts;

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * default constructor for Translatable Client Product List
	 */
	public TranslatableClientProductList() {
		super();
		this.clientProducts = new ArrayList<>();
	}

	/**
	 * Translatable Client Product List
	 * 
	 * @param clientProducts
	 * 				Client products
	 */
	public TranslatableClientProductList(List<TranslatableClientProduct> clientProducts) {
		super();
		this.clientProducts = clientProducts;
	}

	public List<TranslatableClientProduct> getClientProducts() {
		return clientProducts;
	}

	public void setClientProducts(List<TranslatableClientProduct> clientProducts) {
		this.clientProducts = clientProducts;
	}

	@Override
	public String toString() {
		return "TranslatableClientProductList [clientProducts=" + clientProducts + "]";
	}

}
