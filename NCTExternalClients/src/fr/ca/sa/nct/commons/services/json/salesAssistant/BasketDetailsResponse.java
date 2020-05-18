package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket.GetBasketAgreedOffersList;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket.GetBasketNeedsResult;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket.GetBasketNotIntOfferList;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket.GetBasketOpportunityResultList;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket.GetBasketPostponedOffersList;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket.GetBasketProjectResultList;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket.GetBasketProspectsResultList;
import fr.ca.sa.model.Basket;

/**
 * 
 * @author sasa.radovanovic
 *
 */
public class BasketDetailsResponse implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Basket basket;

	private GetBasketOpportunityResultList pendingOpportunities;
	private GetBasketOpportunityResultList cancelledOpportunities;
	private GetBasketOpportunityResultList treatedOpportunities;
	private GetBasketNeedsResult needs;
	private GetBasketProjectResultList projects;
	private GetBasketProspectsResultList prospects;
	private GetBasketAgreedOffersList agreed;
	private GetBasketPostponedOffersList postponed;
	private GetBasketNotIntOfferList notInterested;
	
	private String dataSource;

	/**
	 * default constructor for Basket Details Response
	 */
	public BasketDetailsResponse() {
		super();
	}

	/**
	 * Basket Details Response
	 * 
	 * @param basket
	 * 				Basket
	 * 
	 */
	public BasketDetailsResponse(Basket basket,
			GetBasketOpportunityResultList pendingOpportunities, GetBasketOpportunityResultList cancelledOpportunities,
			GetBasketOpportunityResultList treatedOpportunities, GetBasketNeedsResult needs,
			GetBasketProjectResultList projects, GetBasketProspectsResultList prospects,
			GetBasketAgreedOffersList agreed, GetBasketPostponedOffersList postponed,
			GetBasketNotIntOfferList notInterested, 
			String timeSpent, int advisorId, Integer channelId, String dataSource) {
		super();
		this.basket = basket;
		this.pendingOpportunities = pendingOpportunities;
		this.cancelledOpportunities = cancelledOpportunities;
		this.treatedOpportunities = treatedOpportunities;
		this.needs = needs;
		this.projects = projects;
		this.prospects = prospects;
		this.agreed = agreed;
		this.postponed = postponed;
		this.notInterested = notInterested;
		this.dataSource = dataSource;
	}
	
	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public GetBasketAgreedOffersList getAgreed() {
		return agreed;
	}

	public void setAgreed(GetBasketAgreedOffersList agreed) {
		this.agreed = agreed;
	}

	public GetBasketOpportunityResultList getPendingOpportunities() {
		return pendingOpportunities;
	}

	public void setPendingOpportunities(GetBasketOpportunityResultList pendingOpportunities) {
		this.pendingOpportunities = pendingOpportunities;
	}

	public GetBasketOpportunityResultList getCancelledOpportunities() {
		return cancelledOpportunities;
	}

	public void setCancelledOpportunities(GetBasketOpportunityResultList cancelledOpportunities) {
		this.cancelledOpportunities = cancelledOpportunities;
	}

	public GetBasketOpportunityResultList getTreatedOpportunities() {
		return treatedOpportunities;
	}

	public void setTreatedOpportunities(GetBasketOpportunityResultList treatedOpportunities) {
		this.treatedOpportunities = treatedOpportunities;
	}

	public GetBasketNeedsResult getNeeds() {
		return needs;
	}

	public void setNeeds(GetBasketNeedsResult needs) {
		this.needs = needs;
	}

	public GetBasketProjectResultList getProjects() {
		return projects;
	}

	public void setProjects(GetBasketProjectResultList projects) {
		this.projects = projects;
	}

	public GetBasketProspectsResultList getProspects() {
		return prospects;
	}

	public void setProspects(GetBasketProspectsResultList prospects) {
		this.prospects = prospects;
	}

	public GetBasketPostponedOffersList getPostponed() {
		return postponed;
	}

	public void setPostponed(GetBasketPostponedOffersList postponed) {
		this.postponed = postponed;
	}

	public GetBasketNotIntOfferList getNotInterested() {
		return notInterested;
	}

	public void setNotInterested(GetBasketNotIntOfferList notInterested) {
		this.notInterested = notInterested;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	

}
