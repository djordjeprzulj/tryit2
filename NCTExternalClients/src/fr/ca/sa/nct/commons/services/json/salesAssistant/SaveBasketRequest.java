package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.Basket;

/**
 * 
 * Create new Basket for specific client
 * 
 * @author Sasa Radovanovic
 *
 */
public class SaveBasketRequest implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Basket basket;

	private List<Integer> pendingOpportunityIds;

	private List<Integer> treatedOpportunityIds;

	private List<Integer> canceledOpportunityIds;

	private List<SaveSalesAssistantProjectDetails> projectDetails;

	private SaveBasketNotInterestedProduct notInterestedProducts;

	private SaveBasketTreatedNeed treatedNeeds;

	private List<SaveBasketAgreedProduct> agreedProducts;

	private List<SaveBasketReminderProduct> reminderProducts;

	private List<Integer> recommendedProspectIds;

	private List<SaveBasketOpportunityTreatedReasons> opportunityTreatedReasons;

	private int langId;

	/**
	 * default constructor for Save Basket Request
	 */
	public SaveBasketRequest() {
		super();
	}

	/**
	 * Save Basket Request
	 * 
	 * @param basket
	 * 				Basket
	 *  
	 * @param pendingOpportunityIds
	 * 				Pending opportunity IDs
	 * 
	 * @param treatedOpportunityIds
	 * 				Treated opportunity IDs
	 * 
	 * @param canceledOpportunityIds
	 * 				Cancelled opportunity IDs
	 * 
	 * @param projectDetails
	 * 				Project details
	 * 
	 * @param notInterestedProducts
	 * 				Not interested products
	 * 
	 * @param treatedNeeds
	 * 				Treated needs
	 * 
	 * @param agreedProducts
	 * 				Agreed products
	 * 
	 * @param reminderProducts
	 * 				Reminder products
	 * 
	 * @param recommendedProspectIds
	 * 				Recommended prospect IDs
	 *  
	 * @param opportunityTreatedReasons
	 * 				Opportunity treated reasons
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public SaveBasketRequest(Basket basket, List<Integer> pendingOpportunityIds,
			List<Integer> treatedOpportunityIds, List<Integer> canceledOpportunityIds,
			List<SaveSalesAssistantProjectDetails> projectDetails,
			SaveBasketNotInterestedProduct notInterestedProducts, SaveBasketTreatedNeed treatedNeeds,
			List<SaveBasketAgreedProduct> agreedProducts, List<SaveBasketReminderProduct> reminderProducts,
			List<Integer> recommendedProspectIds, 
			List<SaveBasketOpportunityTreatedReasons> opportunityTreatedReasons, int langId) {
		super();
		this.basket = basket;
		this.pendingOpportunityIds = pendingOpportunityIds;
		this.treatedOpportunityIds = treatedOpportunityIds;
		this.canceledOpportunityIds = canceledOpportunityIds;
		this.projectDetails = projectDetails;
		this.notInterestedProducts = notInterestedProducts;
		this.treatedNeeds = treatedNeeds;
		this.agreedProducts = agreedProducts;
		this.reminderProducts = reminderProducts;
		this.recommendedProspectIds = recommendedProspectIds;
		this.opportunityTreatedReasons = opportunityTreatedReasons;
		this.langId = langId;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public List<SaveBasketReminderProduct> getReminderProducts() {
		return reminderProducts;
	}

	public void setReminderProducts(List<SaveBasketReminderProduct> reminderProducts) {
		this.reminderProducts = reminderProducts;
	}

	public List<Integer> getRecommendedProspectIds() {
		return recommendedProspectIds;
	}

	public void setRecommendedProspectIds(List<Integer> recommendedProspectIds) {
		this.recommendedProspectIds = recommendedProspectIds;
	}

	public List<Integer> getPendingOpportunityIds() {
		return pendingOpportunityIds;
	}

	public void setPendingOpportunityIds(List<Integer> pendingOpportunityIds) {
		this.pendingOpportunityIds = pendingOpportunityIds;
	}

	public List<Integer> getTreatedOpportunityIds() {
		return treatedOpportunityIds;
	}

	public List<Integer> getCanceledOpportunityIds() {
		return canceledOpportunityIds;
	}

	public void setCanceledOpportunityIds(List<Integer> canceledOpportunityIds) {
		this.canceledOpportunityIds = canceledOpportunityIds;
	}

	public List<SaveSalesAssistantProjectDetails> getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(List<SaveSalesAssistantProjectDetails> projectDetails) {
		this.projectDetails = projectDetails;
	}

	public SaveBasketNotInterestedProduct getNotInterestedProducts() {
		return notInterestedProducts;
	}

	public void setNotInterestedProducts(SaveBasketNotInterestedProduct notInterestedProducts) {
		this.notInterestedProducts = notInterestedProducts;
	}

	public void setTreatedOpportunityIds(List<Integer> treatedOpportunityIds) {
		this.treatedOpportunityIds = treatedOpportunityIds;
	}

	public SaveBasketTreatedNeed getTreatedNeeds() {
		return treatedNeeds;
	}

	public void setTreatedNeeds(SaveBasketTreatedNeed treatedNeeds) {
		this.treatedNeeds = treatedNeeds;
	}

	public List<SaveBasketAgreedProduct> getAgreedProducts() {
		return agreedProducts;
	}

	public void setAgreedProducts(List<SaveBasketAgreedProduct> agreedProducts) {
		this.agreedProducts = agreedProducts;
	}

	public List<SaveBasketOpportunityTreatedReasons> getOpportunityTreatedReasons() {
		return opportunityTreatedReasons;
	}

	public void setOpportunityTreatedReasons(List<SaveBasketOpportunityTreatedReasons> opportunityTreatedReasons) {
		this.opportunityTreatedReasons = opportunityTreatedReasons;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

}
