package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Save opportunity list holder
 * 
 * @author Sasa Radovanovic
 *
 */
public class SaveSalesAssistantProjectDetails implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer projectCategoryId;

	private Double amount;

	private Integer currencyId;

	private String targetDate;

	private String comment;

	private Integer needCategoryId;

	/**
	 * default constructor for Save Sales Assistant Project Details
	 */
	public SaveSalesAssistantProjectDetails() {
		super();
	}

	/**
	 * Save Sales Assistant Project Details
	 * 
	 * @param projectCategoryId
	 * 				Project category ID
	 * 
	 * @param amount
	 * 				Amount
	 * 
	 * @param currencyId
	 * 				Currency ID
	 * 
	 * @param targetDate
	 * 				Target date
	 * 
	 * @param comment
	 * 				Comment
	 * 
	 * @param needCategoryId
	 * 				Need category ID
	 */
	public SaveSalesAssistantProjectDetails(Integer projectCategoryId, Double amount, Integer currencyId,
			String targetDate, String comment, Integer needCategoryId) {
		super();
		this.projectCategoryId = projectCategoryId;
		this.amount = amount;
		this.currencyId = currencyId;
		this.targetDate = targetDate;
		this.comment = comment;
		this.needCategoryId = needCategoryId;
	}

	public Integer getProjectCategoryId() {
		return projectCategoryId;
	}

	public void setProjectCategoryId(Integer projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
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

	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getNeedCategoryId() {
		return needCategoryId;
	}

	public void setNeedCategoryId(Integer needCategoryId) {
		this.needCategoryId = needCategoryId;
	}

}
