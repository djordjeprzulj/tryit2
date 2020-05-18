package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketPostponedOffersItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer productId;

	private String productNameL1;

	private String productNameL2;

	private String targetDate;

	private String productGroupPicture;

	private Integer productGroupId;

	/**
	 * default constructor for Get Basket Postponed Offers Item
	 */
	public GetBasketPostponedOffersItem() {
		super();
	}

	/**
	 * Get Basket Postponed Offers Item
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
	 * @param targetDate
	 *            Target date
	 *            
	 * @param productGroupId
	 * 			  Product group ID
	 */
	public GetBasketPostponedOffersItem(Integer productId, String productNameL1, String productNameL2,
			Timestamp targetDate, Integer productGroupId) {
		super();
		this.productId = productId;
		this.productNameL1 = productNameL1;
		this.productNameL2 = productNameL2;
		SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.getBackboneOnlyDateDatetimeFormat());
		this.targetDate = formatter.format(targetDate);
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

	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	public String getProductGroupPicture() {
		return productGroupPicture;
	}

	public void setProductGroupPicture(String productGroupPicture) {
		this.productGroupPicture = productGroupPicture;
	}

	public Integer getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(Integer productGroupId) {
		this.productGroupId = productGroupId;
	}

	@Override
	public String toString() {
		return "GetBasketPostponedOffersItem [productId=" + productId + ", productNameL1=" + productNameL1
				+ ", productNameL2=" + productNameL2 + ", targetDate=" + targetDate + ", productGroupPicture="
				+ productGroupPicture + ", productGroupId=" + productGroupId + "]";
	}

}
