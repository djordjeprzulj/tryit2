package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.startJobFlowExecution;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for single result in result set from
 * batchTrace.spStartJobFlowExecution store procedure
 * 
 * @author Nemanja Ignjatov
 */
public class StartJobFlowExecutionNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int jobFlowExecutionId;

	/**
	 * default constructor for Start Job Flow Execution NCT Result Item
	 */
	public StartJobFlowExecutionNCTResultItem() {
		super();
	}

	/**
	 * Start Job Flow Execution NCT Result Item
	 * 
	 * @param jobFlowExecutionId
	 * 				Job flow execution ID
	 */
	public StartJobFlowExecutionNCTResultItem(int jobFlowExecutionId) {
		super();
		this.jobFlowExecutionId = jobFlowExecutionId;
	}

	public int getJobFlowExecutionId() {
		return jobFlowExecutionId;
	}

	public void setJobFlowExecutionId(int jobFlowExecutionId) {
		this.jobFlowExecutionId = jobFlowExecutionId;
	}

	@Override
	public String toString() {
		return "StartJobFlowExecutionNCTResultItem [jobFlowExecutionId=" + jobFlowExecutionId + "]";
	}

}
