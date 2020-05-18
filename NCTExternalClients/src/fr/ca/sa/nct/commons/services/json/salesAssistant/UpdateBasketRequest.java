package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 *
 * Update basket request
 * 
 * @author Sasa Radovanovic
 *
 */
public class UpdateBasketRequest implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String clientOrLead;

	private Integer portfolioId;

	private Integer clientEntityId;

	private Integer basketAdvisorId;

	private Integer basketId;

	private String comment;

	private Integer originId;

	private Integer channelId;

	private List<SaveBasketAgreedProduct> agreedProducts;

	/**
	 * default constructor for Update Basket Request
	 */
	public UpdateBasketRequest() {
		super();
	}

	/**
	 * Update Basket Request
	 * 
	 * @param clientOrLead
	 * 				Client or lead
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 * 
	 * @param clientEntityId
	 * 				Client entity ID
	 * 
	 * @param basketAdvisorId
	 * 				Basket advisor ID
	 * 
	 * @param basketId
	 * 				Basket ID
	 * 
	 * @param comment
	 * 				Comment
	 * 
	 * @param originId
	 * 				Origin ID
	 * 
	 * @param agreedProducts
	 * 				Agreed products
	 * 
	 * @param channelId
	 * 				Channel ID
	 */
	public UpdateBasketRequest(String clientOrLead, Integer portfolioId, Integer clientEntityId,
			Integer basketAdvisorId, Integer basketId, String comment, Integer originId,
			List<SaveBasketAgreedProduct> agreedProducts, Integer channelId) {
		super();
		this.clientOrLead = clientOrLead;
		this.portfolioId = portfolioId;
		this.clientEntityId = clientEntityId;
		this.basketAdvisorId = basketAdvisorId;
		this.basketId = basketId;
		this.comment = comment;
		this.originId = originId;
		this.agreedProducts = agreedProducts;
		this.channelId = channelId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getOriginId() {
		return originId;
	}

	public void setOriginId(Integer originId) {
		this.originId = originId;
	}

	public List<SaveBasketAgreedProduct> getAgreedProducts() {
		return agreedProducts;
	}

	public void setAgreedProducts(List<SaveBasketAgreedProduct> agreedProducts) {
		this.agreedProducts = agreedProducts;
	}

	public Integer getBasketId() {
		return basketId;
	}

	public void setBasketId(Integer basketId) {
		this.basketId = basketId;
	}

	public String getClientOrLead() {
		return clientOrLead;
	}

	public void setClientOrLead(String clientOrLead) {
		this.clientOrLead = clientOrLead;
	}

	public Integer getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}

	public Integer getClientEntityId() {
		return clientEntityId;
	}

	public void setClientEntityId(Integer clientEntityId) {
		this.clientEntityId = clientEntityId;
	}

	public Integer getBasketAdvisorId() {
		return basketAdvisorId;
	}

	public void setBasketAdvisorId(Integer basketAdvisorId) {
		this.basketAdvisorId = basketAdvisorId;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

}
