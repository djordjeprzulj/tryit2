package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobsByScheduleId;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class JobItem implements StoreProcedureResult, Serializable {


	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer jobId;
	private String name;
	private String description;
	private Integer scheduleId;
	
	/**
	 * default constructor for Job Item
	 */
	public JobItem() {
		super();
	}

	/**
	 * Job Item
	 * 
	 * @param jobId
	 * 				Job ID
	 * 
	 * @param name
	 * 				Name
	 * 
	 * @param description
	 * 				Description
	 * 
	 * @param scheduleId
	 * 				Schedule ID
	 */
	public JobItem(Integer jobId, String name, String description,
			Integer scheduleId) {
		super();
		this.jobId = jobId;
		this.name = name;
		this.description = description;
		this.scheduleId = scheduleId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
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

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	@Override
	public String toString() {
		return "JobItem [jobId=" + jobId + ", name=" + name + ", description="
				+ description + ", scheduleId=" + scheduleId + "]";
	}
	
	
	
}
