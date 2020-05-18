package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientOpportunityProducts;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Single product data holder retrieved from database
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunityProductsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int opportunityId;
	private int productId;
	private Boolean productOwnedByClient;
	private int productGroupId;

	/**
	 * default constructor for Get Opportunity Products NCT Result Item
	 */
	public GetOpportunityProductsNCTResultItem() {
		super();
	}

	/**
	 * Get Opportunity Products NCT Result Item
	 * 
	 * @param opportunityId
	 * 			  Opportunity ID
	 * 
	 * @param productId
	 *            Product ID
	 * @param productOwnedByClient
	 *            Product owned by client
	 * 
	 * @param productGroupId
	 *            Product Group ID
	 */
	public GetOpportunityProductsNCTResultItem(int opportunityId, int productId, int productOwnedByClient,
			int productGroupId) {
		super();
		this.opportunityId = opportunityId;
		this.productId = productId;
		this.productOwnedByClient = productOwnedByClient == 1;
		this.productGroupId = productGroupId;

	}

	public int getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(int opportunityId) {
		this.opportunityId = opportunityId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Boolean getProductOwnedByClient() {
		return productOwnedByClient;
	}

	public void setProductOwnedByClient(Boolean productOwnedByClient) {
		this.productOwnedByClient = productOwnedByClient;
	}

	public int getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(int productGroupId) {
		this.productGroupId = productGroupId;
	}

	@Override
	public String toString() {
		return "GetOpportunityProductsNCTResultItem [opportunityId=" + opportunityId + ", productId=" + productId
				+ ", productOwnedByClient=" + productOwnedByClient + ", productGroupId=" + productGroupId + "]";
	}

}
