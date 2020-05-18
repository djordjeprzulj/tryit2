package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for agreed offers
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketAgreedOffersItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer productId;

	private String productNameL1;

	private String productNameL2;

	private Double amount;

	private Integer currencyId;

	private Integer numberOfPieces;

	private Boolean productOwnedByClient;

	private String productGroupPicture;

	private Integer agreedOfferStatusId;

	private Integer agreedOfferTypeId;

	private Integer productGroupId;

	/**
	 * default constructor for Get Basket Agreed Offers Item
	 */
	public GetBasketAgreedOffersItem() {
		super();
	}

	/**
	 * Get Basket Agreed Offers Item
	 * 
	 * @param productId
	 *            Product ID
	 * 
	 * @param productNameL1
	 *            Product name in first language
	 * 
	 * @param productNameL2
	 *            Product name in second language
	 * 
	 * @param amount
	 *            Amount
	 * 
	 * @param currencyId
	 *            Currency ID
	 * 
	 * @param numberOfPieces
	 *            Number of pieces
	 * 
	 * @param productOwnedByClient
	 *            Is product owned by client
	 * 
	 * @param agreedOfferStatusId
	 *            Agreed offer status ID
	 * 
	 * @param agreedOfferTypeId
	 *            Agreed offer type ID
	 *     
	 * @param productGroupId
	 * 			  Product group ID
	 */
	public GetBasketAgreedOffersItem(Integer productId, String productNameL1, String productNameL2, Double amount,
			Integer currencyId, Integer numberOfPieces, Integer productOwnedByClient, Integer agreedOfferStatusId,
			Integer agreedOfferTypeId, Integer productGroupId) {
		super();
		this.productId = productId;
		this.productNameL1 = productNameL1;
		this.productNameL2 = productNameL2;
		this.amount = amount;
		this.currencyId = currencyId;
		this.numberOfPieces = numberOfPieces;
		this.productOwnedByClient = productOwnedByClient == 1;
		this.agreedOfferStatusId = agreedOfferStatusId;
		this.agreedOfferTypeId = agreedOfferTypeId;
		this.productGroupId = productGroupId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductNameL1() {
		return productNameL1;
	}

	public void setProductNameL1(String productNameL1) {
		this.productNameL1 = productNameL1;
	}

	public String getProductNameL2() {
		return productNameL2;
	}

	public void setProductNameL2(String productNameL2) {
		this.productNameL2 = productNameL2;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Integer getNumberOfPieces() {
		return numberOfPieces;
	}

	public void setNumberOfPieces(Integer numberOfPieces) {
		this.numberOfPieces = numberOfPieces;
	}

	public Boolean getProductOwnedByClient() {
		return productOwnedByClient;
	}

	public void setProductOwnedByClient(Boolean productOwnedByClient) {
		this.productOwnedByClient = productOwnedByClient;
	}

	public String getProductGroupPicture() {
		return productGroupPicture;
	}

	public void setProductGroupPicture(String productGroupPicture) {
		this.productGroupPicture = productGroupPicture;
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

	public Integer getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(Integer productGroupId) {
		this.productGroupId = productGroupId;
	}

	@Override
	public String toString() {
		return "GetBasketAgreedOffersItem [productId=" + productId + ", productNameL1=" + productNameL1
				+ ", productNameL2=" + productNameL2 + ", amount=" + amount + ", currencyId=" + currencyId
				+ ", numberOfPieces=" + numberOfPieces + ", productOwnedByClient=" + productOwnedByClient
				+ ", productGroupPicture=" + productGroupPicture + ", agreedOfferStatusId=" + agreedOfferStatusId
				+ ", agreedOfferTypeId=" + agreedOfferTypeId + ", productGroupId=" + productGroupId + "]";
	}

}
