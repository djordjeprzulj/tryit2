package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobDailySchedules;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Stefan Djokic
 *
 *         Wrapper class for single result in result set from
 *         batch.spGetJobDailySchedules store procedure
 */
public class GetJobDailySchedulesNCTResultItem implements StoreProcedureResult {

	private int jobScheduleId;
	private int flowProcessPeriodTypeId;
	private String name;
	private String description;
	private String occursOnceAt;
	private Integer occursEveryMinutes;
	private boolean occursOnMonday;
	private boolean occursOnTuesday;
	private boolean occursOnWednesday;
	private boolean occursOnThursday;
	private boolean occursOnFriday;
	private boolean occursOnSaturday;
	private boolean occursOnSunday;
	private String startDate;
	private String endDate;

	/**
	 * Get Job Daily Schedules NCT Result Item
	 * 
	 * @param jobScheduleId
	 * 				Job schedule ID
	 * 
	 * @param flowProcessPeriodTypeId
	 * 				Flow process period type ID
	 * 
	 * @param name
	 * 				Name
	 * 
	 * @param description
	 * 				Description
	 * 
	 * @param occursOnceAt
	 * 				Occurs one at x
	 * 
	 * @param occursEveryMinutes
	 * 				Occurs every x minutes
	 * 
	 * @param occursOnMonday
	 * 				Occurs on Monday
	 * 
	 * @param occursOnTuesday
	 * 				Occurs on Tuesday 
	 * 
	 * @param occursOnWednesday
	 * 				Occurs on Wednesday
	 * 
	 * @param occursOnThursday
	 * 				Occurs on Thursday
	 * 
	 * @param occursOnFriday
	 * 				Occurs on Friday
	 * 
	 * @param occursOnSaturday
	 * 				Occurs on Saturday
	 * 
	 * @param occursOnSunday
	 * 				Occurs on Sunday
	 * 
	 * @param startDate
	 * 				Start date
	 * 
	 * @param endDate
	 * 				End date
	 */
	public GetJobDailySchedulesNCTResultItem(int jobScheduleId, int flowProcessPeriodTypeId, String name,
			String description, String occursOnceAt, Integer occursEveryMinutes, int occursOnMonday,
			int occursOnTuesday, int occursOnWednesday, int occursOnThursday, int occursOnFriday, int occursOnSaturday,
			int occursOnSunday, Timestamp startDate, Timestamp endDate) {
		super();
		this.jobScheduleId = jobScheduleId;
		this.flowProcessPeriodTypeId = flowProcessPeriodTypeId;
		this.name = name;
		this.description = description;
		this.occursOnceAt = occursOnceAt;
		this.occursEveryMinutes = occursEveryMinutes;
		this.occursOnMonday = occursOnMonday == 1;
		this.occursOnTuesday = occursOnTuesday == 1;
		this.occursOnWednesday = occursOnWednesday == 1;
		this.occursOnThursday = occursOnThursday == 1;
		this.occursOnFriday = occursOnFriday == 1;
		this.occursOnSaturday = occursOnSaturday == 1;
		this.occursOnSunday = occursOnSunday == 1;

		if (startDate != null) {
			DateFormat df = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
			this.startDate = df.format(startDate);
		}

		if (endDate != null) {
			DateFormat df = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
			this.endDate = df.format(endDate);
		}
	}

	public int getJobScheduleId() {
		return jobScheduleId;
	}

	public void setJobScheduleId(int jobScheduleId) {
		this.jobScheduleId = jobScheduleId;
	}

	public int getFlowProcessPeriodTypeId() {
		return flowProcessPeriodTypeId;
	}

	public void setFlowProcessPeriodTypeId(int flowProcessPeriodTypeId) {
		this.flowProcessPeriodTypeId = flowProcessPeriodTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOccursOnceAt() {
		return occursOnceAt;
	}

	public void setOccursOnceAt(String occursOnceAt) {
		this.occursOnceAt = occursOnceAt;
	}

	public Integer getOccursEveryMinutes() {
		return occursEveryMinutes;
	}

	public void setOccursEveryMinutes(Integer occursEveryMinutes) {
		this.occursEveryMinutes = occursEveryMinutes;
	}

	public boolean isOccursOnMonday() {
		return occursOnMonday;
	}

	public void setOccursOnMonday(boolean occursOnMonday) {
		this.occursOnMonday = occursOnMonday;
	}

	public boolean isOccursOnTuesday() {
		return occursOnTuesday;
	}

	public void setOccursOnTuesday(boolean occursOnTuesday) {
		this.occursOnTuesday = occursOnTuesday;
	}

	public boolean isOccursOnWednesday() {
		return occursOnWednesday;
	}

	public void setOccursOnWednesday(boolean occursOnWednesday) {
		this.occursOnWednesday = occursOnWednesday;
	}

	public boolean isOccursOnThursday() {
		return occursOnThursday;
	}

	public void setOccursOnThursday(boolean occursOnThursday) {
		this.occursOnThursday = occursOnThursday;
	}

	public boolean isOccursOnFriday() {
		return occursOnFriday;
	}

	public void setOccursOnFriday(boolean occursOnFriday) {
		this.occursOnFriday = occursOnFriday;
	}

	public boolean isOccursOnSaturday() {
		return occursOnSaturday;
	}

	public void setOccursOnSaturday(boolean occursOnSaturday) {
		this.occursOnSaturday = occursOnSaturday;
	}

	public boolean isOccursOnSunday() {
		return occursOnSunday;
	}

	public void setOccursOnSunday(boolean occursOnSunday) {
		this.occursOnSunday = occursOnSunday;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "GetJobDailySchedulesNCTResultItem [jobScheduleId=" + jobScheduleId + ", flowProcessPeriodTypeId="
				+ flowProcessPeriodTypeId + ", name=" + name + ", description=" + description + ", occursOnceAt="
				+ occursOnceAt + ", occursEveryMinutes=" + occursEveryMinutes + ", occursOnMonday=" + occursOnMonday
				+ ", occursOnTuesday=" + occursOnTuesday + ", occursOnWednesday=" + occursOnWednesday
				+ ", occursOnThursday=" + occursOnThursday + ", occursOnFriday=" + occursOnFriday
				+ ", occursOnSaturday=" + occursOnSaturday + ", occursOnSunday=" + occursOnSunday + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

}
