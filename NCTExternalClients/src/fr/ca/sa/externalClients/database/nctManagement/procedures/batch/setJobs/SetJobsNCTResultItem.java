package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.setJobs;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class SetJobsNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int jobId;

	/**
	 * default constructor for Set Jobs NCT Result Item
	 */
	public SetJobsNCTResultItem() {
		super();
	}

	/**
	 * Jobs NCT Result Item
	 * 
	 * @param jobId
	 * 				Job ID
	 */
	public SetJobsNCTResultItem(int jobId) {
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
		return "SetJobsNCTResultItem [jobId=" + jobId + "]";
	}

}
