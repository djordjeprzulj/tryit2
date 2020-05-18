package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlows;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 *
 * Wrapper class for single result in result set from
 * batch.spGetFlowDirectionTypes store procedure
 * 
 * @author Nemanja Ignjatov
 */
public class GetFlowsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int flowsId;
	private String fileName;
	private int flowDirectionType;
	private int flowProcessPeriodType;
	private int jobId;
	private int level;
	private int parentFlowId;
	private String name;
	private String description;
	private int skipLimit;
	private int retryLimit;
	private int active;

	/**
	 * default constructor for Get Flows NCT Result Item
	 */
	public GetFlowsNCTResultItem() {
		super();
	}

	/**
	 * Get Flows NCT Result Item
	 * 
	 * @param flowsId
	 * 				Flows ID
	 * 
	 * @param fileName
	 * 				File name
	 * 
	 * @param flowDirectionType
	 * 				Flow direction type
	 * 
	 * @param flowProcessPeriodType
	 * 				Flow process period type
	 * 
	 * @param jobId
	 * 				Job ID
	 * 
	 * @param level
	 * 				Level
	 * 
	 * @param parentFlowId
	 * 				Parent flow ID
	 * 
	 * @param name
	 * 				Name
	 * 
	 * @param description
	 * 				Description
	 * 
	 * @param skipLimit
	 * 				Skip limit
	 * 
	 * @param retryLimit
	 * 				Retry limit
	 * 
	 * @param active
	 * 				Activity
	 */
	public GetFlowsNCTResultItem(int flowsId, String fileName, int flowDirectionType, int flowProcessPeriodType,
			int jobId, int level, int parentFlowId, String name, String description, int skipLimit, int retryLimit,
			int active) {
		super();
		this.flowsId = flowsId;
		this.fileName = fileName;
		this.flowDirectionType = flowDirectionType;
		this.flowProcessPeriodType = flowProcessPeriodType;
		this.jobId = jobId;
		this.level = level;
		this.parentFlowId = parentFlowId;
		this.name = name;
		this.description = description;
		this.skipLimit = skipLimit;
		this.retryLimit = retryLimit;
		this.active = active;
	}

	public int getFlowsId() {
		return flowsId;
	}

	public void setFlowsId(int flowsId) {
		this.flowsId = flowsId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFlowDirectionType() {
		return flowDirectionType;
	}

	public void setFlowDirectionType(int flowDirectionType) {
		this.flowDirectionType = flowDirectionType;
	}

	public int getFlowProcessPeriodType() {
		return flowProcessPeriodType;
	}

	public void setFlowProcessPeriodType(int flowProcessPeriodType) {
		this.flowProcessPeriodType = flowProcessPeriodType;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getParentFlowId() {
		return parentFlowId;
	}

	public void setParentFlowId(int parentFlowId) {
		this.parentFlowId = parentFlowId;
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

	public int getSkipLimit() {
		return skipLimit;
	}

	public void setSkipLimit(int skipLimit) {
		this.skipLimit = skipLimit;
	}

	public int getRetryLimit() {
		return retryLimit;
	}

	public void setRetryLimit(int retryLimit) {
		this.retryLimit = retryLimit;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "GetFlowsNCTResultItem [flowsId=" + flowsId + ", fileName=" + fileName + ", flowDirectionType="
				+ flowDirectionType + ", flowProcessPeriodType=" + flowProcessPeriodType + ", jobId=" + jobId
				+ ", level=" + level + ", parentFlowId=" + parentFlowId + ", name=" + name + ", description="
				+ description + ", skipLimit=" + skipLimit + ", retryLimit=" + retryLimit + ", active=" + active + "]";
	}

}
