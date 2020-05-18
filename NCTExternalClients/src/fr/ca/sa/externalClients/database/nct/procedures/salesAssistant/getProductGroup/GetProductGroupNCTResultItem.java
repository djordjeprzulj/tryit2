package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getProductGroup;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Single product group data holder retrieved from database
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetProductGroupNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int productGroupId;
	private String productGroupNameL1;
	private String productGroupNameL2;
	private String productGroupDescriptionL1;
	private String productGroupDescriptionL2;
	private String productGroupPicture;

	/**
	 * default constructor for Get Products Groups NCT Result Item
	 */
	public GetProductGroupNCTResultItem() {
		super();
	}

	/**
	 * @param productGroupId
	 * @param productGroupNameL1
	 * @param productGroupNameL2
	 * @param productGroupDescriptionL1
	 * @param productGroupDescriptionL2
	 */
	public GetProductGroupNCTResultItem(int productGroupId, String productGroupNameL1, String productGroupNameL2,
			String productGroupDescriptionL1, String productGroupDescriptionL2) {
		super();
		this.productGroupId = productGroupId;
		this.productGroupNameL1 = productGroupNameL1;
		this.productGroupNameL2 = productGroupNameL2;
		this.productGroupDescriptionL1 = productGroupDescriptionL1;
		this.productGroupDescriptionL2 = productGroupDescriptionL2;
	}

	public int getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(int productGroupId) {
		this.productGroupId = productGroupId;
	}

	public String getProductGroupPicture() {
		return productGroupPicture;
	}

	public void setProductGroupPicture(String productGroupPicture) {
		this.productGroupPicture = productGroupPicture;
	}

	public String getProductGroupNameL1() {
		return productGroupNameL1;
	}

	public void setProductGroupNameL1(String productGroupNameL1) {
		this.productGroupNameL1 = productGroupNameL1;
	}

	public String getProductGroupNameL2() {
		return productGroupNameL2;
	}

	public void setProductGroupNameL2(String productGroupNameL2) {
		this.productGroupNameL2 = productGroupNameL2;
	}

	public String getProductGroupDescriptionL1() {
		return productGroupDescriptionL1;
	}

	public void setProductGroupDescriptionL1(String productGroupDescriptionL1) {
		this.productGroupDescriptionL1 = productGroupDescriptionL1;
	}

	public String getProductGroupDescriptionL2() {
		return productGroupDescriptionL2;
	}

	public void setProductGroupDescriptionL2(String productGroupDescriptionL2) {
		this.productGroupDescriptionL2 = productGroupDescriptionL2;
	}

	@Override
	public String toString() {
		return "GetProductGroupNCTResultItem [productGroupId=" + productGroupId + ", productGroupNameL1="
				+ productGroupNameL1 + ", productGroupNameL2=" + productGroupNameL2 + ", productGroupDescriptionL1="
				+ productGroupDescriptionL1 + ", productGroupDescriptionL2=" + productGroupDescriptionL2
				+ ", productGroupPicture=" + productGroupPicture + "]";
	}

}
