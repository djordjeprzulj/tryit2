package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for agreed offers list
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketAgreedOffersList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetBasketAgreedOffersItem> agreedList;

	/**
	 * default constructor for Get Basket Agreed Offers List
	 */
	public GetBasketAgreedOffersList() {
		super();
		this.agreedList = new ArrayList<>();
	}

	/**
	 * Get Basket Agreed Offers List
	 * 
	 * @param agreedList
	 * 				Agreed list with offers
	 */
	public GetBasketAgreedOffersList(List<GetBasketAgreedOffersItem> agreedList) {
		super();
		this.agreedList = agreedList;
	}

	public List<GetBasketAgreedOffersItem> getAgreedList() {
		return agreedList;
	}

	public void setAgreedList(List<GetBasketAgreedOffersItem> agreedList) {
		this.agreedList = agreedList;
	}

	@Override
	public String toString() {
		return "GetBasketAgreedOffersList [agreedList=" + agreedList + "]";
	}

}
