package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class CancelClientProjectRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int projectId;
	private String comment;

	/**
	 * default constructor for Cancel Client Project Request
	 */
	public CancelClientProjectRequest() {
		super();
	}

	/**
	 * Cancel Client Project Request
	 * 
	 * @param projectId
	 * 				Project ID
	 * 
	 * @param comment
	 * 				Comment
	 */
	public CancelClientProjectRequest(int projectId, String comment) {
		super();
		this.projectId = projectId;
		this.comment = comment;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
