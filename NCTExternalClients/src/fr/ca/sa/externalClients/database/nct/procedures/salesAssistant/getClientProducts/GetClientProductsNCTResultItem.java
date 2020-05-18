package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientProducts;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Single product data holder retrieved from database
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientProductsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int productGroupId;
	private Boolean isBestOfferProductGroup;

	private int productSubGroupId;
	private String productSubgroupNameL1;
	private String productSubgroupNameL2;

	private int productId;
	private Boolean productOwnedByClient;
	private String bestOfferDescription;

	/**
	 * default constructor for Get Client Products NCT Result Item
	 */
	public GetClientProductsNCTResultItem() {
		super();
	}

	
	/**
	 * Get Client Products NCT Result Item
	 * 
	 * @param productGroupId
	 * 			Product group ID
	 * 
	 * @param isBestOfferProductGroup
	 * 			Is the product in best offer product group
	 * 
	 * @param productSubGroupId
	 * 			Product sub group ID
	 * 
	 * @param productSubgroupNameL1
	 * 			Product subgroup name in first language
	 * 
	 * @param productSubgroupNameL2
	 * 			Product subgroup name in second language
	 * 
	 * @param productId
	 * 			Product ID
	 * 
	 * @param productOwnedByClient
	 * 			Is product already owned by client
	 * 
	 * @param bestOfferDescription
	 * 			Description of best offer
	 */
	public GetClientProductsNCTResultItem(int productGroupId, int isBestOfferProductGroup, int productSubGroupId,
			String productSubgroupNameL1, String productSubgroupNameL2, int productId, int productOwnedByClient,
			String bestOfferDescription) {
		super();
		this.productGroupId = productGroupId;
		this.isBestOfferProductGroup = isBestOfferProductGroup == ProjectConstants.INTEGER_TRUE_VALUE;
		this.productSubGroupId = productSubGroupId;
		this.productSubgroupNameL1 = productSubgroupNameL1;
		this.productSubgroupNameL2 = productSubgroupNameL2;
		this.productId = productId;
		this.productOwnedByClient = productOwnedByClient == ProjectConstants.INTEGER_TRUE_VALUE;
		this.bestOfferDescription = bestOfferDescription;
	}

	public int getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(int productGroupId) {
		this.productGroupId = productGroupId;
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

	public Boolean getIsBestOfferProductGroup() {
		return isBestOfferProductGroup;
	}

	public void setIsBestOfferProductGroup(Boolean isBestOfferProductGroup) {
		this.isBestOfferProductGroup = isBestOfferProductGroup;
	}

	public String getBestOfferDescription() {
		return bestOfferDescription;
	}

	public void setBestOfferDescription(String bestOfferDescription) {
		this.bestOfferDescription = bestOfferDescription;
	}

	public int getProductSubGroupId() {
		return productSubGroupId;
	}

	public void setProductSubGroupId(int productSubGroupId) {
		this.productSubGroupId = productSubGroupId;
	}

	public String getProductSubgroupNameL1() {
		return productSubgroupNameL1;
	}

	public void setProductSubgroupNameL1(String productSubgroupNameL1) {
		this.productSubgroupNameL1 = productSubgroupNameL1;
	}

	public String getProductSubgroupNameL2() {
		return productSubgroupNameL2;
	}

	public void setProductSubgroupNameL2(String productSubgroupNameL2) {
		this.productSubgroupNameL2 = productSubgroupNameL2;
	}

	@Override
	public String toString() {
		return "GetClientProductsNCTResultItem [productGroupId=" + productGroupId + ", isBestOfferProductGroup="
				+ isBestOfferProductGroup + ", productSubGroupId=" + productSubGroupId + ", productSubgroupNameL1="
				+ productSubgroupNameL1 + ", productSubgroupNameL2=" + productSubgroupNameL2 + ", productId="
				+ productId + ", productOwnedByClient=" + productOwnedByClient + ", bestOfferDescription="
				+ bestOfferDescription + "]";
	}

}
