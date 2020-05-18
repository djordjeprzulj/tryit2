package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for offers list
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketNotIntOfferList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetBasketNotIntOfferItem> notInterestedList;

	/**
	 * default constructor for Get Basket Not Interested Offer List
	 */
	public GetBasketNotIntOfferList() {
		super();
		this.notInterestedList = new ArrayList<>();
	}

	/**
	 * Get Basket Not Interested Offer List
	 * 
	 * @param notInterestedList
	 * 				Not interested list
	 */
	public GetBasketNotIntOfferList(List<GetBasketNotIntOfferItem> notInterestedList) {
		super();
		this.notInterestedList = notInterestedList;
	}

	public List<GetBasketNotIntOfferItem> getNotInterestedList() {
		return notInterestedList;
	}

	public void setNotInterestedList(List<GetBasketNotIntOfferItem> notInterestedList) {
		this.notInterestedList = notInterestedList;
	}

	@Override
	public String toString() {
		return "GetBasketNotIntOfferList [notInterestedList=" + notInterestedList + "]";
	}
}
