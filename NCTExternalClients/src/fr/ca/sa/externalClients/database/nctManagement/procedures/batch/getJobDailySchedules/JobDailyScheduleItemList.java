package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobDailySchedules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author rsasa
 *
 */
public class JobDailyScheduleItemList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<JobDailyScheduleItem> jobDailyScheduleList;
	
	public List<JobDailyScheduleItem> getJobDailyScheduleList() {
		return jobDailyScheduleList;
	}

	public void setJobDailyScheduleList(
			List<JobDailyScheduleItem> jobDailyScheduleList) {
		this.jobDailyScheduleList = jobDailyScheduleList;
	}


	/**
	 * default constructor for Job Daily Schedule Item List
	 */
	public JobDailyScheduleItemList() {
		super();
		this.jobDailyScheduleList = new ArrayList<>();
	}

	/**
	 * Job Daily Schedule Item List
	 * 
	 * @param jobDailyScheduleList
	 */
	public JobDailyScheduleItemList(
			List<JobDailyScheduleItem> jobDailyScheduleList) {
		super();
		this.jobDailyScheduleList = jobDailyScheduleList;
	}

	@Override
	public String toString() {
		return "JobDailyScheduleItemList [jobDailyScheduleList="
				+ jobDailyScheduleList + "]";
	}
}
