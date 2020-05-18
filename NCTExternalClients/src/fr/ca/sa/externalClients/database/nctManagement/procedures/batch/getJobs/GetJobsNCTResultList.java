package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for all results from batch.spGetJobs store procedure
 * 
 * * @author Nemanja Ignjatov
 */

public class GetJobsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetJobsNCTResultItem> jobs;

	/**
	 * default constructor for Get Jobs NCT Result List
	 */
	public GetJobsNCTResultList() {
		super();
		jobs = new ArrayList<GetJobsNCTResultItem>();
	}

	/**
	 * Get Jobs NCT Result List
	 * 
	 * @param jobs
	 * 				Jobs
	 */
	public GetJobsNCTResultList(List<GetJobsNCTResultItem> jobs) {
		super();
		this.jobs = jobs;
	}

	public List<GetJobsNCTResultItem> getJobs() {
		return jobs;
	}

	public void setJobs(List<GetJobsNCTResultItem> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetJobsNCTResultList [ ");
		if (this.jobs != null) {
			for (GetJobsNCTResultItem job : this.jobs) {
				sbRetValue.append(job.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetJobsNCTResultList is empty!!!";
	}

}
