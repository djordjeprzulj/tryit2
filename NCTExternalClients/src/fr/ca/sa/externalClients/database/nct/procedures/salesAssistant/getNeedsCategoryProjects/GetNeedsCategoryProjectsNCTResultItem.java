package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getNeedsCategoryProjects;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Single need category project data holder retrieved from database
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetNeedsCategoryProjectsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int needCategoryId;
	private String needCategoryName;
	private int projectCategoryId;
	private String projectCategoryName;

	/**
	 * default constructor for Get Needs Category Projects NCT Result Item
	 */
	public GetNeedsCategoryProjectsNCTResultItem() {
		super();
	}

	/**
	 * Get Needs Category Projects NCT Result Item
	 * 
	 * @param needCategoryId
	 * 				Need category ID
	 * 
	 * @param needCategoryName
	 * 				Need category name
	 * 
	 * @param projectCategoryId
	 * 				Project category ID
	 * 
	 * @param projectCategoryName
	 * 				Project category name
	 */
	public GetNeedsCategoryProjectsNCTResultItem(int needCategoryId, String needCategoryName, int projectCategoryId,
			String projectCategoryName) {
		super();
		this.needCategoryId = needCategoryId;
		this.needCategoryName = needCategoryName;
		this.projectCategoryId = projectCategoryId;
		this.projectCategoryName = projectCategoryName;
	}

	public int getNeedCategoryId() {
		return needCategoryId;
	}

	public void setNeedCategoryId(int needCategoryId) {
		this.needCategoryId = needCategoryId;
	}

	public String getNeedCategoryName() {
		return needCategoryName;
	}

	public void setNeedCategoryName(String needCategoryName) {
		this.needCategoryName = needCategoryName;
	}

	public int getProjectCategoryId() {
		return projectCategoryId;
	}

	public void setProjectCategoryId(int projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}

	public String getProjectCategoryName() {
		return projectCategoryName;
	}

	public void setProjectCategoryName(String projectCategoryName) {
		this.projectCategoryName = projectCategoryName;
	}

	@Override
	public String toString() {
		return "GetNeedsCategoryProjectsNCTResultItem [needCategoryId=" + needCategoryId + ", needCategoryName="
				+ needCategoryName + ", projectCategoryId=" + projectCategoryId + ", projectCategoryName="
				+ projectCategoryName + "]";
	}

}
