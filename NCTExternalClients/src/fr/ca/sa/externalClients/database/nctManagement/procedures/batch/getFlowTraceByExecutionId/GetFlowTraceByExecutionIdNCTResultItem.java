package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowTraceByExecutionId;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetFlowTraceByExecutionIdNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int jobId;
	private String jobName;
	private String flowName;
	private String traceTimeStamp;
	private String jobExecutionCurrentStatus;
	private String flowExecutionCurrentStatus;
	private String traceDescription;

	/**
	 * default constructor for Get Flow Trace By Execution ID NCT Result Item
	 */
	public GetFlowTraceByExecutionIdNCTResultItem() {
		super();
	}

	/**
	 * Get Flow Trace By Execution ID NCT Result Item
	 * 
	 * @param jobId
	 * 				Job ID
	 * 
	 * @param jobName
	 * 				Job name
	 * 
	 * @param flowName
	 * 				Flow name
	 * 
	 * @param traceTimeStamp
	 * 				Trace time stamp
	 * 
	 * @param jobExecutionCurrentStatus
	 * 				Job execution current status
	 * 
	 * @param flowExecutionCurrentStatus
	 * 				Flow execution current status
	 * 
	 * @param traceDescription
	 * 				Trace description
	 */
	public GetFlowTraceByExecutionIdNCTResultItem(int jobId, String jobName, String flowName, Timestamp traceTimeStamp,
			String jobExecutionCurrentStatus, String flowExecutionCurrentStatus, String traceDescription) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.flowName = flowName;

		if (traceTimeStamp != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
			this.traceTimeStamp = formatter.format(traceTimeStamp);
		}

		this.jobExecutionCurrentStatus = jobExecutionCurrentStatus;
		this.flowExecutionCurrentStatus = flowExecutionCurrentStatus;
		this.traceDescription = traceDescription;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public String getTraceTimeStamp() {
		return traceTimeStamp;
	}

	public void setTraceTimeStamp(String traceTimeStamp) {
		this.traceTimeStamp = traceTimeStamp;
	}

	public String getJobExecutionCurrentStatus() {
		return jobExecutionCurrentStatus;
	}

	public void setJobExecutionCurrentStatus(String jobExecutionCurrentStatus) {
		this.jobExecutionCurrentStatus = jobExecutionCurrentStatus;
	}

	public String getFlowExecutionCurrentStatus() {
		return flowExecutionCurrentStatus;
	}

	public void setFlowExecutionCurrentStatus(String flowExecutionCurrentStatus) {
		this.flowExecutionCurrentStatus = flowExecutionCurrentStatus;
	}

	public String getTraceDescription() {
		return traceDescription;
	}

	public void setTraceDescription(String traceDescription) {
		this.traceDescription = traceDescription;
	}

	@Override
	public String toString() {
		return "GetFlowTraceByExecutionIdNCTResultItem [jobId=" + jobId + ", jobName=" + jobName + ", flowName="
				+ flowName + ", traceTimeStamp=" + traceTimeStamp + ", jobExecutionCurrentStatus="
				+ jobExecutionCurrentStatus + ", flowExecutionCurrentStatus=" + flowExecutionCurrentStatus
				+ ", traceDescription=" + traceDescription + "]";
	}

}
