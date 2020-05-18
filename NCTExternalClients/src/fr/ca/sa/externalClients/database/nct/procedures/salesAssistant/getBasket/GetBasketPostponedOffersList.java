package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketPostponedOffersList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetBasketPostponedOffersItem> postponedList;

	/**
	 * default constructor for Get Basket Postponed Offers List
	 */
	public GetBasketPostponedOffersList() {
		super();
		this.postponedList = new ArrayList<>();
	}

	/**
	 * Get Basket Postponed Offers List
	 * 
	 * @param postponedList
	 * 					Postponed offers list
	 */
	public GetBasketPostponedOffersList(List<GetBasketPostponedOffersItem> postponedList) {
		super();
		this.postponedList = postponedList;
	}

	public List<GetBasketPostponedOffersItem> getPostponedList() {
		return postponedList;
	}

	public void setPostponedList(List<GetBasketPostponedOffersItem> postponedList) {
		this.postponedList = postponedList;
	}

	@Override
	public String toString() {
		return "GetBasketPostponedOffersList [postponedList=" + postponedList + "]";
	}

}
