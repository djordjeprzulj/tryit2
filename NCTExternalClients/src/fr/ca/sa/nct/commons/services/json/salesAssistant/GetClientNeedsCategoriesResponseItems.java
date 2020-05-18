package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request for getting client needs categories from catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientNeedsCategoriesResponseItems implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private TranslatableNeedCategory needCategory;
	private boolean eligible;
	private boolean runningProjects;

	/**
	 * default constructor for Get Client Needs Categories Response Items
	 */
	public GetClientNeedsCategoriesResponseItems() {
		super();
	}

	/**
	 * Get Client Needs Categories Response Items
	 * 
	 * @param needCategory
	 * 				Need category
	 * 
	 * @param eligible
	 * 				Eligibility
	 * 
	 * @param runningProjects
	 * 				Running projects
	 */
	public GetClientNeedsCategoriesResponseItems(TranslatableNeedCategory needCategory, boolean eligible,
			boolean runningProjects) {
		super();
		this.needCategory = needCategory;
		this.eligible = eligible;
		this.runningProjects = runningProjects;
	}

	public TranslatableNeedCategory getNeedCategory() {
		return needCategory;
	}

	public void setNeedCategory(TranslatableNeedCategory needCategory) {
		this.needCategory = needCategory;
	}

	public boolean isEligible() {
		return eligible;
	}

	public void setEligible(boolean eligible) {
		this.eligible = eligible;
	}

	public boolean isRunningProjects() {
		return runningProjects;
	}

	public void setRunningProjects(boolean runningProjects) {
		this.runningProjects = runningProjects;
	}

	@Override
	public String toString() {
		return "GetClientNeedsCategoriesResponseItems [needCategory=" + needCategory + ", eligible=" + eligible
				+ ", runningProjects=" + runningProjects + "]";
	}

}
