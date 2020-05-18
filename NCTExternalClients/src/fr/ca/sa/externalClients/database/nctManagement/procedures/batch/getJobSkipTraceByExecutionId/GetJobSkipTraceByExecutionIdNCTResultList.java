package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobSkipTraceByExecutionId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetJobSkipTraceByExecutionIdNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetJobSkipTraceByExecutionIdNCTResultItem> jobSkipTraces;

	/**
	 * default constructor for Get Job Skip Trace By Execution ID NCT Result List
	 */
	public GetJobSkipTraceByExecutionIdNCTResultList() {
		super();
		this.jobSkipTraces = new ArrayList<GetJobSkipTraceByExecutionIdNCTResultItem>();
	}

	/**
	 * Get Job Skip Trace By Execution ID NCT Result List
	 * 
	 * @param jobSkipTraces
	 * 				Job skip traces
	 */
	public GetJobSkipTraceByExecutionIdNCTResultList(
			List<GetJobSkipTraceByExecutionIdNCTResultItem> jobSkipTraces) {
		super();
		this.jobSkipTraces = jobSkipTraces;
	}

	public List<GetJobSkipTraceByExecutionIdNCTResultItem> getJobSkipTraces() {
		return jobSkipTraces;
	}

	public void setJobSkipTraces(List<GetJobSkipTraceByExecutionIdNCTResultItem> jobSkipTraces) {
		this.jobSkipTraces = jobSkipTraces;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetJobSkipTraceByExecutionIdNCTResultList [ ");

		if (this.jobSkipTraces != null) {
			for (GetJobSkipTraceByExecutionIdNCTResultItem jobSkipTraces : this.jobSkipTraces) {
				sbRetValue.append(jobSkipTraces.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetJobSkipTraceByExecutionIdNCTResultList is empty!!!";
	}
}
