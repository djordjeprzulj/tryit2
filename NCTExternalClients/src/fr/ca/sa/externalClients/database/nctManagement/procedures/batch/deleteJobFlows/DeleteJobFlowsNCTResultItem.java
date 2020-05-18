package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.deleteJobFlows;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * Wrapper class for result in result set from spDeleteJobFlows store procedure
 * 
 * @author Stefan Djokic
 *
 */
public class DeleteJobFlowsNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int jobId;

	/**
	 * default constructor for Delete Job Flows NCT Result Item
	 */
	public DeleteJobFlowsNCTResultItem() {
		super();
	}

	/**
	 * Delete Job Flows NCT Result Item
	 * 
	 * @param jobId
	 * 				Job ID
	 */
	public DeleteJobFlowsNCTResultItem(int jobId) {
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
		return "DeleteJobFlowsNCTResultItem [jobId=" + jobId + "]";
	}

}
