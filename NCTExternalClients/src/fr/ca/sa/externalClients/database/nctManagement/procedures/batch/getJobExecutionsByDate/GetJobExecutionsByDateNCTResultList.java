package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobExecutionsByDate;

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
public class GetJobExecutionsByDateNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetJobExecutionsByDateNCTResultItem> jobExecutionsByDate;

	/**
	 * default constructor for Get Job Executions By Date NCT Result List
	 */
	public GetJobExecutionsByDateNCTResultList() {
		super();
		this.jobExecutionsByDate = new ArrayList<GetJobExecutionsByDateNCTResultItem>();
	}

	public List<GetJobExecutionsByDateNCTResultItem> getJobExecutionsByDate() {
		return jobExecutionsByDate;
	}

	public void setJobExecutionsByDate(List<GetJobExecutionsByDateNCTResultItem> jobExecutionsByDate) {
		this.jobExecutionsByDate = jobExecutionsByDate;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetJobExecutionsByDateNCTResultList [ ");

		if (this.jobExecutionsByDate != null) {
			for (GetJobExecutionsByDateNCTResultItem jobExecutionByDate : this.jobExecutionsByDate) {
				sbRetValue.append(jobExecutionByDate.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetJobExecutionsByDateNCTResultList is empty!!!";
	}
}
