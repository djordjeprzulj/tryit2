package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.BaseTranslatableProduct;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class BaseTranslatableClientProduct implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private BaseTranslatableProduct translatableProduct;
	
	/**
	 * default constructor for Translatable Client Opp Product
	 */
	public BaseTranslatableClientProduct() {
		super();
	}

	/**
	 * Translatable Client Opportunity Product
	 * 
	 * @param translatebleProduct
	 * 				Translatable Product
	 * 
	 */
	public BaseTranslatableClientProduct(BaseTranslatableProduct translatebleProduct) {
		super();
		this.translatableProduct = translatebleProduct;
	}

	public BaseTranslatableProduct getTranslatableProduct() {
		return translatableProduct;
	}

	public void setTranslatableProduct(BaseTranslatableProduct translatableProduct) {
		this.translatableProduct = translatableProduct;
	}
}
