package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.startJobExecution;

import java.io.Serializable;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for single result in result set from
 * batchTrace.spStartJobExecution store procedure
 * 
 * @author Nemanja Ignjatov
 */
public class StartJobExecutionNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int jobExecutionId;
	private boolean previousJobExecutionInProgress;

	/**
	 * default constructor for Start Job Execution NCT Result Item
	 */
	public StartJobExecutionNCTResultItem() {
		super();
	}

	/**
	 * Start Job Execution NCT Result Item
	 * 
	 * @param jobExecutionId
	 * 				Job execution ID
	 * 
	 * @param previousJobExecutionInProgress
	 * 				Previous job execution in progress
	 */
	public StartJobExecutionNCTResultItem(int jobExecutionId, int previousJobExecutionInProgress) {
		super();
		this.jobExecutionId = jobExecutionId;
		this.previousJobExecutionInProgress = previousJobExecutionInProgress == NCTDatabaseConstants.ACTIVE_INTEGER_VALUE;
	}

	public int getJobExecutionId() {
		return jobExecutionId;
	}

	public void setJobExecutionId(int jobExecutionId) {
		this.jobExecutionId = jobExecutionId;
	}

	public boolean isPreviousJobExecutionInProgress() {
		return previousJobExecutionInProgress;
	}

	public void setPreviousJobExecutionInProgress(boolean previousJobExecutionInProgress) {
		this.previousJobExecutionInProgress = previousJobExecutionInProgress;
	}

	@Override
	public String toString() {
		return "StartJobExecutionNCTResultItem [jobExecutionId=" + jobExecutionId + ", previousJobExecutionInProgress="
				+ previousJobExecutionInProgress + "]";
	}

}
