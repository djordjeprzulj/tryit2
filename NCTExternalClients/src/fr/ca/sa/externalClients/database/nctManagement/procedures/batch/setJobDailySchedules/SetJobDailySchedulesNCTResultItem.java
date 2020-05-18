package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.setJobDailySchedules;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Stefan Djokic
 *
 *         Wrapper class for single result in result set from
 *         batch.spSetJobDailySchedules store procedure
 */
public class SetJobDailySchedulesNCTResultItem implements StoreProcedureResult {

	private int jobDailySchedulsId;

	/**
	 * default constructor for Set Job Daily Schedules NCT Result Item
	 */
	public SetJobDailySchedulesNCTResultItem() {
		super();
	}

	/**
	 * Set Job Daily Schedules NCT Result Item
	 * 
	 * @param jobDailySchedulsId
	 * 					Job daily schedules ID
	 */
	public SetJobDailySchedulesNCTResultItem(int jobDailySchedulsId) {
		super();
		this.jobDailySchedulsId = jobDailySchedulsId;
	}

	public int getJobDailySchedulsId() {
		return jobDailySchedulsId;
	}

	public void setJobDailySchedulsId(int jobDailySchedulsId) {
		this.jobDailySchedulsId = jobDailySchedulsId;
	}

	@Override
	public String toString() {
		return "SetJobDailySchedulesNCTResultItem [jobDailySchedulsId=" + jobDailySchedulsId + "]";
	}

}
