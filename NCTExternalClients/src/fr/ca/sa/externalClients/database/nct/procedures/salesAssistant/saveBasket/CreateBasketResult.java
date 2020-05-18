package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.saveBasket;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Result on creating basket
 * 
 * @author Sasa Radovanovic
 *
 */
public class CreateBasketResult implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int basketId;

	/**
	 * Create Basket Result
	 * 
	 * @param basketId
	 * 				Basket ID
	 */
	public CreateBasketResult(int basketId) {
		super();
		this.basketId = basketId;
	}

	public int getBasketId() {
		return basketId;
	}

	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}

	@Override
	public String toString() {
		return "CreateBasketResult [basketId=" + basketId + "]";
	}

}
