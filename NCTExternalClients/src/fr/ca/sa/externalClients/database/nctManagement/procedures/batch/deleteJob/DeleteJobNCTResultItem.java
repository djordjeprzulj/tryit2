package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.deleteJob;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * Wrapper class for result in result set from spDeleteJob store procedure
 * 
 * @author Stefan Djokic
 *
 */
public class DeleteJobNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int jobId;

	/**
	 * default constructor for Delete Job NCT Result Item
	 */
	public DeleteJobNCTResultItem() {
		super();
	}

	/**
	 * Delete Job NCT Result Item
	 * 
	 * @param jobId
	 * 				Job ID
	 */
	public DeleteJobNCTResultItem(int jobId) {
		super();
		this.jobId = jobId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	@Override
	public String toString() {
		return "DeleteJobNCTResultItem [jobId=" + jobId + "]";
	}

}
