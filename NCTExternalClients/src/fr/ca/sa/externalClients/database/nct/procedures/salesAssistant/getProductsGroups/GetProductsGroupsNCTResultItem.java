package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getProductsGroups;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Single product group data holder retrieved from database
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetProductsGroupsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int productGroupId;
	private String productGroupCode;
	private Boolean isBestOffer;

	/**
	 * default constructor for Get Products Groups NCT Result Item
	 */
	public GetProductsGroupsNCTResultItem() {
		super();
	}

	/**
	 * Get Products Groups NCT Result Item
	 * 
	 * @param productGroupId
	 *            Product group ID
	 * 
	 * @param productGroupCode
	 *            Product group code
	 * 
	 * @param productGroupName
	 *            Product group name
	 * 
	 * @param productGroupDescription
	 *            Product group description
	 * 
	 * @param isBestOffer
	 *            Best offer flag
	 */

	public int getProductGroupId() {
		return productGroupId;
	}

	/**
	 * Get Products Groups NCT Result Item
	 * 
	 * @param productGroupId
	 * 			Product group ID
	 * 
	 * @param productGroupCode
	 * 			Product group code
	 * 
	 * @param isBestOffer
	 * 			Is the product best offer
	 */
	public GetProductsGroupsNCTResultItem(int productGroupId, String productGroupCode, int isBestOffer) {
		super();
		this.productGroupId = productGroupId;
		this.productGroupCode = productGroupCode;
		this.isBestOffer = isBestOffer == ProjectConstants.INTEGER_TRUE_VALUE;
	}

	public void setProductGroupId(int productGroupId) {
		this.productGroupId = productGroupId;
	}

	public String getProductGroupCode() {
		return productGroupCode;
	}

	public void setProductGroupCode(String productGroupCode) {
		this.productGroupCode = productGroupCode;
	}

	public Boolean getIsBestOffer() {
		return isBestOffer;
	}

	public void setIsBestOffer(Boolean isBestOffer) {
		this.isBestOffer = isBestOffer;
	}

	@Override
	public String toString() {
		return "GetProductsGroupsNCTResultItem [productGroupId=" + productGroupId + ", productGroupCode="
				+ productGroupCode + ", isBestOffer=" + isBestOffer + "]";
	}

}
