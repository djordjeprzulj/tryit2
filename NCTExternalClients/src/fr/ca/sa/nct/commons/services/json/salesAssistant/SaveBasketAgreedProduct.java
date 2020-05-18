package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Partial holder for basket interface
 * 
 * @author Sasa Radovanovic
 *
 */
public class SaveBasketAgreedProduct implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer productId;
	private Double amount;
	private Integer numberOfPieces;
	private Integer currencyId;
	private Integer agreedOfferStatusId;
	private Integer agreedOfferTypeId;
	private Integer opportunityId;

	/**
	 * default constructor for Save Basket Agreed Product
	 */
	public SaveBasketAgreedProduct() {
		super();
	}

	/***
	 * Save Basket Agreed Product
	 * 
	 * @param productId
	 * 				Product ID
	 * 
	 * @param amount
	 * 				Amount
	 * 
	 * @param numberOfPieces
	 * 				Number of pieces
	 * 
	 * @param currencyId
	 * 				Currency ID
	 * 
	 * @param agreedOfferStatusId
	 * 				Agreed offer status ID
	 * 
	 * @param agreedOfferTypeId
	 * 				Agreed offer type ID
	 */
	public SaveBasketAgreedProduct(Integer productId, Double amount, Integer numberOfPieces, Integer currencyId,
			Integer agreedOfferStatusId, Integer agreedOfferTypeId, Integer opportunityId) {
		super();
		this.productId = productId;
		this.amount = amount;
		this.numberOfPieces = numberOfPieces;
		this.currencyId = currencyId;
		this.agreedOfferStatusId = agreedOfferStatusId;
		this.agreedOfferTypeId = agreedOfferTypeId;
		this.opportunityId = opportunityId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getNumberOfPieces() {
		return numberOfPieces;
	}

	public void setNumberOfPieces(Integer numberOfPieces) {
		this.numberOfPieces = numberOfPieces;
	}

	public Integer getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Integer getAgreedOfferStatusId() {
		return agreedOfferStatusId;
	}

	public void setAgreedOfferStatusId(Integer agreedOfferStatusId) {
		this.agreedOfferStatusId = agreedOfferStatusId;
	}

	public Integer getAgreedOfferTypeId() {
		return agreedOfferTypeId;
	}

	public void setAgreedOfferTypeId(Integer agreedOfferTypeId) {
		this.agreedOfferTypeId = agreedOfferTypeId;
	}

	public Integer getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(Integer opportunityId) {
		this.opportunityId = opportunityId;
	}

}
