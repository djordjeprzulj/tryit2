package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.model.Basket;

/**
 * 
 * Data holder for basket details
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketDetailsResponse implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Basket basket;

	/**
	 * Get Basket Details Response
	 * 
	 * @param basker
	 * 				Basket
	 */
	public GetBasketDetailsResponse(Basket basket) {
		super();
		this.basket = basket;
	}
	public Basket getBasket() {
		return basket;
	}
	
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	
	@Override
	public String toString() {
		return "GetBasketDetailsResponse [basket=" + basket + "]";
	}
}
