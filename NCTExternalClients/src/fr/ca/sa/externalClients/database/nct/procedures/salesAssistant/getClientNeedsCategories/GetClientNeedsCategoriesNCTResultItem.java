package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientNeedsCategories;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Single client need data holder retrieved from database
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientNeedsCategoriesNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int needCategoryId;
	private int numberOfProjects;
	private int eligible;

	/**
	 * default constructor for Get Client Needs Categories NCT Result Item
	 */
	public GetClientNeedsCategoriesNCTResultItem() {
		super();
	}

	/**
	 * Get Client Needs Categories NCT Result Item
	 * 
	 * @param needCategoryId
	 * 				Need category ID
	 * 
	 * @param numberOfProjects
	 * 				Number of projects
	 * 
	 * @param eligible
	 * 				Eligible
	 */
	public GetClientNeedsCategoriesNCTResultItem(int needCategoryId, int numberOfProjects, int eligible) {
		super();
		this.needCategoryId = needCategoryId;
		this.numberOfProjects = numberOfProjects;
		this.eligible = eligible;
	}

	public int getNeedCategoryId() {
		return needCategoryId;
	}

	public void setNeedCategoryId(int needCategoryId) {
		this.needCategoryId = needCategoryId;
	}

	public int getNumberOfProjects() {
		return numberOfProjects;
	}

	public void setNumberOfProjects(int numberOfProjects) {
		this.numberOfProjects = numberOfProjects;
	}

	public int getEligible() {
		return eligible;
	}

	public void setEligible(int eligible) {
		this.eligible = eligible;
	}

	@Override
	public String toString() {
		return "GetClientNeedsCategoriesNCTResultItem [needCategoryId=" + needCategoryId + ", numberOfProjects="
				+ numberOfProjects + ", eligible=" + eligible + "]";
	}

}
