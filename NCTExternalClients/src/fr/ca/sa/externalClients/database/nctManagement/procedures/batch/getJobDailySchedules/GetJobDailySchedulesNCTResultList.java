package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobDailySchedules;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Stefan Djokic
 *
 *         Wrapper class for all results from batch.spGetJobDailySchedules store
 *         procedure
 * 
 */
public class GetJobDailySchedulesNCTResultList implements StoreProcedureResult {

	private List<GetJobDailySchedulesNCTResultItem> jobDailySchedules;

	/**
	 * default constructor for Get Job Daily Schedules NCT Result List
	 */
	public GetJobDailySchedulesNCTResultList() {
		super();
		this.jobDailySchedules = new ArrayList<GetJobDailySchedulesNCTResultItem>();
	}

	public List<GetJobDailySchedulesNCTResultItem> getJobDailySchedules() {
		return jobDailySchedules;
	}

	public void setJobDailySchedules(List<GetJobDailySchedulesNCTResultItem> jobDailySchedules) {
		this.jobDailySchedules = jobDailySchedules;
	}

	@Override
	public String toString() {
		return "GetJobDailySchedulesNCTResultList [jobDailySchedules=" + jobDailySchedules + "]";
	}

}
