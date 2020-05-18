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
public class GetBasketProjectResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer projectCategoryId;

	private String projectCategoryL1;

	private String projectCategoryL2;

	private String targetDate;

	private Double amount;

	private Integer currencyId;

	private String comment;

	/**
	 * default constructor for Get Basket Project Result Item
	 */
	public GetBasketProjectResultItem() {
		super();
	}

	/**
	 * Get Basket Project Result Item
	 * 
	 * @param projectCategoryId
	 * 				Project category ID
	 * 
	 * @param projectCategoryL1
	 * 				Project category in first language
	 * 
	 * @param projectCategoryL2
	 * 				Project category in second language 
	 * 
	 * @param targetDate
	 * 				Target date
	 * 
	 * @param amount
	 * 				Amount
	 * 
	 * @param currencyId
	 * 				Currency ID
	 * 
	 * @param comment
	 * 				Comment
	 */
	public GetBasketProjectResultItem(Integer projectCategoryId, String projectCategoryL1, String projectCategoryL2,
			Timestamp targetDate, Double amount, Integer currencyId, String comment) {
		super();
		this.projectCategoryId = projectCategoryId;
		this.projectCategoryL1 = projectCategoryL1;
		this.projectCategoryL2 = projectCategoryL2;
		SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.getBackboneOnlyDateDatetimeFormat());
		this.targetDate = formatter.format(targetDate);
		this.amount = amount;
		this.currencyId = currencyId;
		this.comment = comment;
	}

	public Integer getProjectCategoryId() {
		return projectCategoryId;
	}

	public void setProjectCategoryId(Integer projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}

	public String getProjectCategoryL1() {
		return projectCategoryL1;
	}

	public void setProjectCategoryL1(String projectCategoryL1) {
		this.projectCategoryL1 = projectCategoryL1;
	}

	public String getProjectCategoryL2() {
		return projectCategoryL2;
	}

	public void setProjectCategoryL2(String projectCategoryL2) {
		this.projectCategoryL2 = projectCategoryL2;
	}

	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "GetBasketProjectResultItem [projectCategoryId=" + projectCategoryId + ", projectCategoryL1="
				+ projectCategoryL1 + ", projectCategoryL2=" + projectCategoryL2 + ", targetDate=" + targetDate
				+ ", amount=" + amount + ", currencyId=" + currencyId + ", comment=" + comment + "]";
	}

}
