package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Partial holder for Save Basket functionality
 * 
 * @author Sasa Radovanovic
 *
 */
public class SaveBasketReminderProduct implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer productId;

	private String targetDate;

	private String comment;
	
	private Integer opportunityId;

	/**
	 * default constructor for Save Basket Reminder Product
	 */
	public SaveBasketReminderProduct() {
		super();
	}

	/**
	 * Save Basket Reminder Product
	 * 
	 * @param productId
	 * 				Product ID
	 * 
	 * @param targetDate
	 * 				Target date
	 * 
	 * @param comment
	 * 				Comment
	 */
	public SaveBasketReminderProduct(Integer productId, String targetDate, String comment, Integer opportunityId) {
		super();
		this.productId = productId;
		this.targetDate = targetDate;
		this.comment = comment;
		this.opportunityId = opportunityId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

	public Integer getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(Integer opportunityId) {
		this.opportunityId = opportunityId;
	}

}
