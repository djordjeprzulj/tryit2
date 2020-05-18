package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobSkipTraceByExecutionId;

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
public class GetJobSkipTraceByExecutionIdNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int jobId;
	private String jobName;
	private String flowName;
	private String skipTimeStamp;
	private int skipLine;
	private String skipDescription;

	/**
	 * default constructor for Get Job Skip Trace By Execution ID NCT Result Item
	 */
	public GetJobSkipTraceByExecutionIdNCTResultItem() {
		super();
	}

	/**
	 * Get Job Skip Trace By Execution ID NCT Result Item
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
	 * @param skipTimeStamp
	 * 				Skip time stamp
	 * 
	 * @param skipLine
	 * 				Skip line
	 * 
	 * @param skipDescription
	 * 				Skip description
	 */
	public GetJobSkipTraceByExecutionIdNCTResultItem(int jobId, String jobName, String flowName,
			Timestamp skipTimeStamp, int skipLine, String skipDescription) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.flowName = flowName;

		if (skipTimeStamp != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
			this.skipTimeStamp = formatter.format(skipTimeStamp);
		}

		this.skipLine = skipLine;
		this.skipDescription = skipDescription;
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

	public String getSkipTimeStamp() {
		return skipTimeStamp;
	}

	public void setSkipTimeStamp(String skipTimeStamp) {
		this.skipTimeStamp = skipTimeStamp;
	}

	public int getSkipLine() {
		return skipLine;
	}

	public void setSkipLine(int skipLine) {
		this.skipLine = skipLine;
	}

	public String getSkipDescription() {
		return skipDescription;
	}

	public void setSkipDescription(String skipDescription) {
		this.skipDescription = skipDescription;
	}

	@Override
	public String toString() {
		return "GetJobSkipTraceByExecutionIdNCTResultItem [jobId=" + jobId + ", jobName=" + jobName + ", flowName="
				+ flowName + ", skipTimeStamp=" + skipTimeStamp + ", skipLine=" + skipLine + ", skipDescription="
				+ skipDescription + "]";
	}

}
