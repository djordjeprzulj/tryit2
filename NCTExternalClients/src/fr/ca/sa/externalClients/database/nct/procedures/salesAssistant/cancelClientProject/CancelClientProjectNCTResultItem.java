package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.cancelClientProject;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class CancelClientProjectNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int projectId;

	/**
	 * default constructor for Cancel Client Project NCT Result Item
	 */
	public CancelClientProjectNCTResultItem() {
		super();
	}

	/**
	 * Cancel Client Project NCT Result Item
	 * 
	 * @param projectId
	 * 				Project ID
	 */
	public CancelClientProjectNCTResultItem(int projectId) {
		super();
		this.projectId = projectId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "CancelClientProjectNCTResultItem [projectId=" + projectId + "]";
	}

}
