package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobExecutionsByDate;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetJobExecutionsByDateNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int jobId;
	private String jobName;
	private int jobExecutionId;
	private String jobStartOrigin;
	private String transferDate;
	private String jobExecutionCurrentStatus;
	private String hostName;
	private String startDate;
	private String endDate;
	private String exitMessage;
	private boolean errorOccurred;
	private boolean transferInProgress;
	private String lastUpdate;

	/**
	 * default constructor for Get Job Executions By Date NCT Result Item
	 */
	public GetJobExecutionsByDateNCTResultItem() {
		super();
	}

	/**
	 * Get Job Executions By Date NCT Result Item
	 * 
	 * @param jobId
	 * 				Job ID
	 * 
	 * @param jobName
	 * 				Job name
	 * 
	 * @param jobExecutionId
	 * 				Job execution ID
	 * 
	 * @param jobStartOrigin
	 * 				Job start origin
	 * 
	 * @param transferDate
	 * 				Transfer date
	 * 
	 * @param jobExecutionCurrentStatus
	 * 				Job execution current status
	 * 
	 * @param hostName
	 * 				Host name
	 * 
	 * @param startDate
	 * 				Start date
	 * 
	 * @param endDate
	 * 				End date
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
	 * @param lastUpdate
	 * 				Last update
	 */
	public GetJobExecutionsByDateNCTResultItem(int jobId, String jobName, int jobExecutionId, String jobStartOrigin,
			Date transferDate, String jobExecutionCurrentStatus, String hostName, Timestamp startDate,
			Timestamp endDate, String exitMessage, int errorOccurred, int transferInProgress, Timestamp lastUpdate) {

		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobExecutionId = jobExecutionId;
		this.jobStartOrigin = jobStartOrigin;

		SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
		
		if (transferDate != null) {
			this.transferDate = formatter.format(transferDate);
		}

		this.jobExecutionCurrentStatus = jobExecutionCurrentStatus;
		this.hostName = hostName;

		if (startDate != null) {
			this.startDate = formatter.format(startDate);
		}

		if (endDate != null) {
			this.endDate = formatter.format(endDate);
		}

		this.exitMessage = exitMessage;
		this.errorOccurred = errorOccurred == 1;
		this.transferInProgress = transferInProgress == 1;

		if (lastUpdate != null) {
			this.lastUpdate = formatter.format(lastUpdate);
		}
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

	public int getJobExecutionId() {
		return jobExecutionId;
	}

	public void setJobExecutionId(int jobExecutionId) {
		this.jobExecutionId = jobExecutionId;
	}

	public String getJobStartOrigin() {
		return jobStartOrigin;
	}

	public void setJobStartOrigin(String jobStartOrigin) {
		this.jobStartOrigin = jobStartOrigin;
	}

	public String getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	public String getJobExecutionCurrentStatus() {
		return jobExecutionCurrentStatus;
	}

	public void setJobExecutionCurrentStatus(String jobExecutionCurrentStatus) {
		this.jobExecutionCurrentStatus = jobExecutionCurrentStatus;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
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

	public String getExitMessage() {
		return exitMessage;
	}

	public void setExitMessage(String exitMessage) {
		this.exitMessage = exitMessage;
	}

	public boolean isErrorOccurred() {
		return errorOccurred;
	}

	public void setErrorOccurred(boolean errorOccurred) {
		this.errorOccurred = errorOccurred;
	}

	public boolean isTransferInProgress() {
		return transferInProgress;
	}

	public void setTransferInProgress(boolean transferInProgress) {
		this.transferInProgress = transferInProgress;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "GetJobExecutionsByDateNCTResultItem [jobId=" + jobId + ", jobName=" + jobName + ", jobExecutionId="
				+ jobExecutionId + ", jobStartOrigin=" + jobStartOrigin + ", transferDate=" + transferDate
				+ ", jobExecutionCurrentStatus=" + jobExecutionCurrentStatus + ", hostName=" + hostName + ", startDate="
				+ startDate + ", endDate=" + endDate + ", exitMessage=" + exitMessage + ", errorOccurred="
				+ errorOccurred + ", transferInProgress=" + transferInProgress + ", lastUpdate=" + lastUpdate + "]";
	}

}
