package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientProjects;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Single project data holder retrieved from database
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientProjectsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int projectId;
	private int projectCategoryId;
	private String projectCategoryNameL1;
	private String projectCategoryNameL2;
	private int needCategoryId;
	private String targetDate;
	private double amount;
	private int currencyId;
	private String comment;

	/**
	 * default constructor for Get Client Projects NCT Result Item
	 */
	public GetClientProjectsNCTResultItem() {
		super();
	}

	/**
	 * Get Client Projects NCT Result Item
	 * 
	 * @param projectId
	 * 				Project ID
	 * 
	 * @param projectCategoryId
	 * 				Project category ID
	 * 
	 * @param projectCategoryNameL1
	 * 				Project category name in first language 
	 * 
	 * @param projectCategoryNameL2
	 * 				Project category name in second language
	 * 
	 * @param needCategoryId
	 * 				Need category ID
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
	public GetClientProjectsNCTResultItem(int projectId, int projectCategoryId, String projectCategoryNameL1,
			String projectCategoryNameL2, int needCategoryId, Date targetDate, double amount, int currencyId,
			String comment) {
		super();
		this.projectId = projectId;
		this.projectCategoryId = projectCategoryId;
		this.projectCategoryNameL1 = projectCategoryNameL1;
		this.projectCategoryNameL2 = projectCategoryNameL2;
		this.needCategoryId = needCategoryId;
		this.amount = amount;
		this.currencyId = currencyId;
		this.comment = comment;

		if (targetDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
			this.targetDate = formatter.format(targetDate);
		}
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getProjectCategoryId() {
		return projectCategoryId;
	}

	public void setProjectCategoryId(int projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}

	public String getProjectCategoryNameL1() {
		return projectCategoryNameL1;
	}

	public void setProjectCategoryNameL1(String projectCategoryNameL1) {
		this.projectCategoryNameL1 = projectCategoryNameL1;
	}

	public String getProjectCategoryNameL2() {
		return projectCategoryNameL2;
	}

	public void setProjectCategoryNameL2(String projectCategoryNameL2) {
		this.projectCategoryNameL2 = projectCategoryNameL2;
	}

	public int getNeedCategoryId() {
		return needCategoryId;
	}

	public void setNeedCategoryId(int needCategoryId) {
		this.needCategoryId = needCategoryId;
	}

	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
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
		return "GetClientProjectsNCTResultItem [projectId=" + projectId + ", projectCategoryId=" + projectCategoryId
				+ ", projectCategoryNameL1=" + projectCategoryNameL1 + ", projectCategoryNameL2="
				+ projectCategoryNameL2 + ", needCategoryId=" + needCategoryId + ", targetDate=" + targetDate
				+ ", amount=" + amount + ", currencyId=" + currencyId + ", comment=" + comment + "]";
	}

}
