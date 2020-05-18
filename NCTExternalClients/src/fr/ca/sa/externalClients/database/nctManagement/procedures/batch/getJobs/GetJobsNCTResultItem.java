package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobs;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 *
 * Wrapper class for single result in result set from
 * batch.spGetFlowDirectionTypes store procedure
 * 
 * @author Nemanja Ignjatov
 */
public class GetJobsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int jobId;
	private String name;
	private String description;
	private int flowDirectionTypeId;
	private int flowProcessPeriodTypeId;
	private int jobScheduleId;
	private int active;

	/**
	 * default constructor for Get Jobs NCT Result Item
	 */
	public GetJobsNCTResultItem() {
		super();
	}

	/**
	 * Get Jobs NCT Result Item
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
	 * @param flowDirectionTypeId
	 * 				Flow direction type ID
	 * 
	 * @param flowProcessPeriodTypeId
	 * 				Flow process period type ID
	 * 
	 * @param jobScheduleId
	 * 				Job schedule ID
	 * 
	 * @param active
	 * 				Activity
	 */
	public GetJobsNCTResultItem(int jobId, String name, String description, int flowDirectionTypeId,
			int flowProcessPeriodTypeId, int jobScheduleId, int active) {
		super();
		this.jobId = jobId;
		this.name = name;
		this.description = description;
		this.flowDirectionTypeId = flowDirectionTypeId;
		this.flowProcessPeriodTypeId = flowProcessPeriodTypeId;
		this.jobScheduleId = jobScheduleId;
		this.active = active;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
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

	public int getFlowDirectionTypeId() {
		return flowDirectionTypeId;
	}

	public void setFlowDirectionTypeId(int flowDirectionTypeId) {
		this.flowDirectionTypeId = flowDirectionTypeId;
	}

	public int getFlowProcessPeriodTypeId() {
		return flowProcessPeriodTypeId;
	}

	public void setFlowProcessPeriodTypeId(int flowProcessPeriodTypeId) {
		this.flowProcessPeriodTypeId = flowProcessPeriodTypeId;
	}

	public int getJobScheduleId() {
		return jobScheduleId;
	}

	public void setJobScheduleId(int jobScheduleId) {
		this.jobScheduleId = jobScheduleId;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "GetJobsNCTResultItem [jobId=" + jobId + ", name=" + name + ", description=" + description
				+ ", flowDirectionTypeId=" + flowDirectionTypeId + ", flowProcessPeriodTypeId="
				+ flowProcessPeriodTypeId + ", jobScheduleId=" + jobScheduleId + ", active=" + active + "]";
	}

}
