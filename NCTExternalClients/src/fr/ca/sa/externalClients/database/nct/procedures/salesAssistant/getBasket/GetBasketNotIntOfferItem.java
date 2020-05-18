package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for offer item
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketNotIntOfferItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer productId;

	private String productGroupPicture;

	private String productNameL1;

	private String productNameL2;

	private Integer notIntReasonId;

	private Integer productGroupId;

	/**
	 * default constructor for Get Basket Not Interested Offer Item
	 */
	public GetBasketNotIntOfferItem() {
		super();
	}

	/**
	 * Get Basket Not Interested Offer Item
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
	 * @param notIntReasonId
	 *            Not interested reason ID
	 *            
	 * @param productGroupId
	 * 			  Product group ID
	 */
	public GetBasketNotIntOfferItem(Integer productId, String productNameL1, String productNameL2,
			Integer notIntReasonId, Integer productGroupId) {
		super();
		this.productId = productId;
		this.productNameL1 = productNameL1;
		this.productNameL2 = productNameL2;
		this.notIntReasonId = notIntReasonId;
		this.productGroupId = productGroupId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductGroupPicture() {
		return productGroupPicture;
	}

	public void setProductGroupPicture(String productGroupPicture) {
		this.productGroupPicture = productGroupPicture;
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

	public Integer getNotIntReasonId() {
		return notIntReasonId;
	}

	public void setNotIntReasonId(Integer notIntReasonId) {
		this.notIntReasonId = notIntReasonId;
	}

	public Integer getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(Integer productGroupId) {
		this.productGroupId = productGroupId;
	}

	
	@Override
	public String toString() {
		return "GetBasketNotIntOfferItem [productId=" + productId + ", productGroupPicture=" + productGroupPicture
				+ ", productNameL1=" + productNameL1 + ", productNameL2=" + productNameL2 + ", notIntReasonId="
				+ notIntReasonId + ", productGroupId=" + productGroupId + "]";
	}

}
