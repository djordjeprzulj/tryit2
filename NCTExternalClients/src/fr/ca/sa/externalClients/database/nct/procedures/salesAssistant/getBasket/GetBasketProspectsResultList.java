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
public class GetBasketProspectsResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetBasketProspectsResultItem> prospectList;

	/**
	 * Get Basket Prospects Result List
	 * 
	 * @param prospectList
	 * 				Prospect list
	 */
	public GetBasketProspectsResultList(List<GetBasketProspectsResultItem> prospectList) {
		super();
		this.prospectList = prospectList;
	}

	/**
	 * default  constructor for Get Basket Prospects Result List
	 */
	public GetBasketProspectsResultList() {
		super();
		this.prospectList = new ArrayList<>();
	}

	public List<GetBasketProspectsResultItem> getProspectList() {
		return prospectList;
	}

	public void setProspectList(List<GetBasketProspectsResultItem> prospectList) {
		this.prospectList = prospectList;
	}

	@Override
	public String toString() {
		return "GetBasketProspectsResultList [prospectList=" + prospectList + "]";
	}

}
