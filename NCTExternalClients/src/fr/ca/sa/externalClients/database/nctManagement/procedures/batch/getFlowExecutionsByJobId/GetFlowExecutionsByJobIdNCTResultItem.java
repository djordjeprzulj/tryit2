package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowExecutionsByJobId;

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
public class GetFlowExecutionsByJobIdNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int flowId;
	private String flowName;
	private String fileName;
	private int skipLimit;
	private int retryLimit;
	private int jobExecutionId;
	private String jobFlowExecutionId;
	private int recordCount;
	private int readCount;
	private int readSkipCount;
	private int writeCount;
	private int writeSkipCount;
	private String flowExecutionCurrentStatus;
	private String startTime;
	private String endTime;
	private String exitMessage;
	private boolean errorOccurred;
	private boolean transferInProgress;
	private boolean onlySkippedRows;
	private String lastUpdate;

	/**
	 * default constructor for Get Flow Executions By Job Id NCT Result Item
	 */
	public GetFlowExecutionsByJobIdNCTResultItem() {
		super();
	}

	/**
	 * Get Flow Executions By Job Id NCT Result Item
	 * 
	 * @param flowId
	 * 				Flow ID
	 * 
	 * @param flowName
	 * 				Flow name
	 * 
	 * @param fileName
	 * 				File name
	 * 
	 * @param skipLimit
	 * 				Skip limit
	 * 
	 * @param retryLimit
	 * 				Retry limit
	 * 
	 * @param jobExecutionId
	 * 				Job execution ID
	 * 
	 * @param jobFlowExecutionId
	 * 				Job flow execution ID
	 * 
	 * @param recordCount
	 * 				Record count
	 * 
	 * @param readCount
	 * 				Read count
	 * 
	 * @param readSkipCount
	 * 				Read skip count
	 * 
	 * @param writeCount
	 * 				Write count
	 * 
	 * @param writeSkipCount
	 * 				Write skip count
	 * 
	 * @param flowExecutionCurrentStatus
	 * 				Flow execution current status
	 * 
	 * @param startTime
	 * 				Start time
	 * 
	 * @param endTime
	 * 				End time
	 * 
	 * @param exitMessage
	 * 				Exit message
	 * 
	 * @param errorOccurred
	 * 				Error occurred
	 * 
	 * @param transferInProgress
	 * 				Transfer in progress
	 * 
	 * @param onlySkippedRows
	 * 				Only skipper rows
	 * 
	 * @param lastUpdate
	 * 				Last update
	 */
	public GetFlowExecutionsByJobIdNCTResultItem(int flowId, String flowName, String fileName, int skipLimit,
			int retryLimit, int jobExecutionId, String jobFlowExecutionId, int recordCount, int readCount,
			int readSkipCount, int writeCount, int writeSkipCount, String flowExecutionCurrentStatus,
			Timestamp startTime, Timestamp endTime, String exitMessage, int errorOccurred, int transferInProgress,
			int onlySkippedRows, Timestamp lastUpdate) {
		super();
		this.flowId = flowId;
		this.flowName = flowName;
		this.fileName = fileName;
		this.skipLimit = skipLimit;
		this.retryLimit = retryLimit;
		this.jobExecutionId = jobExecutionId;
		this.jobFlowExecutionId = jobFlowExecutionId;
		this.recordCount = recordCount;
		this.readCount = readCount;
		this.readSkipCount = readSkipCount;
		this.writeCount = writeCount;
		this.writeSkipCount = writeSkipCount;
		this.flowExecutionCurrentStatus = flowExecutionCurrentStatus;

		
		SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
		
		if (startTime != null) {
			this.startTime = formatter.format(startTime);
		}

		if (endTime != null) {
			this.endTime = formatter.format(endTime);
		}

		this.exitMessage = exitMessage;
		this.errorOccurred = errorOccurred == 1;
		this.transferInProgress = transferInProgress == 1;
		this.onlySkippedRows = onlySkippedRows == 1;

		if (lastUpdate != null) {
			this.lastUpdate = formatter.format(lastUpdate);
		}
	}

	public int getFlowId() {
		return flowId;
	}

	public String getFlowName() {
		return flowName;
	}

	public String getFileName() {
		return fileName;
	}

	public int getSkipLimit() {
		return skipLimit;
	}

	public int getRetryLimit() {
		return retryLimit;
	}

	public int getJobExecutionId() {
		return jobExecutionId;
	}

	public String getJobFlowExecutionId() {
		return jobFlowExecutionId;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public int getReadCount() {
		return readCount;
	}

	public int getReadSkipCount() {
		return readSkipCount;
	}

	public int getWriteCount() {
		return writeCount;
	}

	public int getWriteSkipCount() {
		return writeSkipCount;
	}

	public String getFlowExecutionCurrentStatus() {
		return flowExecutionCurrentStatus;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getExitMessage() {
		return exitMessage;
	}

	public boolean isErrorOccurred() {
		return errorOccurred;
	}

	public boolean isTransferInProgress() {
		return transferInProgress;
	}

	public boolean isOnlySkippedRows() {
		return onlySkippedRows;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	@Override
	public String toString() {
		return "GetFlowExecutionsByJobIdNCTResultItem [flowId=" + flowId + ", flowName=" + flowName + ", fileName="
				+ fileName + ", skipLimit=" + skipLimit + ", retryLimit=" + retryLimit + ", jobExecutionId="
				+ jobExecutionId + ", jobFlowExecutionId=" + jobFlowExecutionId + ", recordCount=" + recordCount
				+ ", readCount=" + readCount + ", readSkipCount=" + readSkipCount + ", writeCount=" + writeCount
				+ ", writeSkipCount=" + writeSkipCount + ", flowExecutionCurrentStatus=" + flowExecutionCurrentStatus
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", exitMessage=" + exitMessage
				+ ", errorOccurred=" + errorOccurred + ", transferInProgress=" + transferInProgress
				+ ", onlySkippedRows=" + onlySkippedRows + ", lastUpdate=" + lastUpdate + "]";
	}

}
