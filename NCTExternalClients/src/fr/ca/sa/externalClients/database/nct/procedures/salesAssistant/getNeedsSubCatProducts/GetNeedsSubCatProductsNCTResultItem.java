package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getNeedsSubCatProducts;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Single need subcat product data holder retrieved from database
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetNeedsSubCatProductsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int needCategoryId;
	private int needSubCategoryId;
	private String needSubCategoryNameL1;
	private String needSubCategoryNameL2;
	private int productId;
	private Boolean productOwnedByClient;
	private int productGroupId;

	/**
	 * default constructor for Get Needs Subcategory Products NCT Result Item
	 */
	public GetNeedsSubCatProductsNCTResultItem() {
		super();
	}

	/**
	 * Get Needs Sub Cat Products NCT Result Item
	 * 
	 * @param needCategoryId
	 * 			Need category ID
	 * 
	 * @param needSubCategoryId
	 * 			Need subcategory ID
	 * 
	 * @param needSubCategoryNameL1
	 * 			Need subcategory name in first language
	 * 
	 * @param needSubCategoryNameL2
	 * 			Need subcategory name in second language
	 * 
	 * @param productId
	 * 			Product ID
	 * 
	 * @param productOwnedByClient
	 * 			Is product owned by client
	 * 
	 * @param productGroupId
	 * 			Product group ID
	 */
	public GetNeedsSubCatProductsNCTResultItem(int needCategoryId, int needSubCategoryId, String needSubCategoryNameL1,
			String needSubCategoryNameL2, int productId, int productOwnedByClient, int productGroupId) {
		super();
		this.needCategoryId = needCategoryId;
		this.needSubCategoryId = needSubCategoryId;
		this.needSubCategoryNameL1 = needSubCategoryNameL1;
		this.needSubCategoryNameL2 = needSubCategoryNameL2;
		this.productId = productId;
		this.productOwnedByClient = productOwnedByClient == 1;
		this.productGroupId = productGroupId;

	}

	public int getNeedCategoryId() {
		return needCategoryId;
	}

	public void setNeedCategoryId(int needCategoryId) {
		this.needCategoryId = needCategoryId;
	}

	public int getNeedSubCategoryId() {
		return needSubCategoryId;
	}

	public void setNeedSubCategoryId(int needSubCategoryId) {
		this.needSubCategoryId = needSubCategoryId;
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

	public String getNeedSubCategoryNameL1() {
		return needSubCategoryNameL1;
	}

	public void setNeedSubCategoryNameL1(String needSubCategoryNameL1) {
		this.needSubCategoryNameL1 = needSubCategoryNameL1;
	}

	public String getNeedSubCategoryNameL2() {
		return needSubCategoryNameL2;
	}

	public void setNeedSubCategoryNameL2(String needSubCategoryNameL2) {
		this.needSubCategoryNameL2 = needSubCategoryNameL2;
	}
	
	@Override
	public String toString() {
		return "GetNeedsSubCatProductsNCTResultItem [needCategoryId=" + needCategoryId + ", needSubCategoryId="
				+ needSubCategoryId + ", needSubCategoryNameL1=" + needSubCategoryNameL1 + ", needSubCategoryNameL2="
				+ needSubCategoryNameL2 + ", productId=" + productId + ", productOwnedByClient=" + productOwnedByClient
				+ ", productGroupId=" + productGroupId + "]";
	}

}
