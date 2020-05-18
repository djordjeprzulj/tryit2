package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobDailySchedules;

import java.io.Serializable;
import java.sql.Time;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author rsasa
 *
 */
public class JobDailyScheduleItem implements StoreProcedureResult, Serializable {
	

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer jobScheduleId;
	private String name;
	private String description;
	private Time occursOnceAt;
	private Integer occursEveryMinutes;
	
	/**
	 * default constructor for Job Daily Schedule Item
	 */
	public JobDailyScheduleItem() {
		super();
	}

	/**
	 * Job Daily Schedule Item
	 * 
	 * @param jobScheduleId
	 * 				Job schedule ID
	 * 
	 * @param name
	 * 				name
	 * 
	 * @param description
	 * 				Description
	 * 
	 * @param occursOnceAt
	 * 				Occurs once at 
	 * 
	 * @param occursEveryMinutes
	 * 				Occurs every x minutes
	 */
	public JobDailyScheduleItem(Integer jobScheduleId, String name,
			String description, Time occursOnceAt, Integer occursEveryMinutes) {
		super();
		this.jobScheduleId = jobScheduleId;
		this.name = name;
		this.description = description;
		this.occursOnceAt = occursOnceAt;
		this.occursEveryMinutes = occursEveryMinutes;
	}

	public Integer getJobScheduleId() {
		return jobScheduleId;
	}


	public void setJobScheduleId(Integer jobScheduleId) {
		this.jobScheduleId = jobScheduleId;
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


	public Time getOccursOnceAt() {
		return occursOnceAt;
	}


	public void setOccursOnceAt(Time occursOnceAt) {
		this.occursOnceAt = occursOnceAt;
	}


	public Integer getOccursEveryMinutes() {
		return occursEveryMinutes;
	}


	public void setOccursEveryMinutes(Integer occursEveryMinutes) {
		this.occursEveryMinutes = occursEveryMinutes;
	}


	@Override
	public String toString() {
		return "JobDailyScheduleItem [jobScheduleId=" + jobScheduleId
				+ ", name=" + name + ", description=" + description
				+ ", occursOnceAt=" + occursOnceAt + ", occursEveryMinutes="
				+ occursEveryMinutes + "]";
	}

	
	
}
