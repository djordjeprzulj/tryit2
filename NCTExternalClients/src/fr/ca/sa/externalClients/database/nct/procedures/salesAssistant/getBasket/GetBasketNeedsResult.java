package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for needs
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketNeedsResult implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<Integer> basketNeeds;

	/**
	 * Get Basket Needs Result
	 * 
	 * @param basketNeeds
	 * 				Basket needs
	 */
	public GetBasketNeedsResult(List<Integer> basketNeeds) {
		super();
		this.basketNeeds = basketNeeds;
	}

	/**
	 * default constructor for Get Basket Needs Result
	 */
	public GetBasketNeedsResult() {
		super();
		this.basketNeeds = new ArrayList<>();
	}

	public List<Integer> getBasketNeeds() {
		return basketNeeds;
	}

	public void setBasketNeeds(List<Integer> basketNeeds) {
		this.basketNeeds = basketNeeds;
	}

	@Override
	public String toString() {
		return "GetBasketNeedsResult [basketNeeds=" + basketNeeds + "]";
	}

}
