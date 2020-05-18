package fr.ca.sa.flowprocessing.commons.errorhandling;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public enum BatchErrors {
	JOB_CURRENTLY_EXECUTED("Job is currently being executed", 1),
	JOB_NOT_ACTIVE("Job is not active", 2),
	NO_FLOWS_FOR_JOB("No flows defined for job", 3),
	NO_ACTIVE_FLOWS_FOR_JOB("No active flows detected for job", 4),
	JOB_TRANSFER_STARTED("Job transfer started", 5),
	FLOW_TRANSFER_STARTED("Flow transfer started", 6),
	FLOW_IS_NOT_ACTIVE("Flow is not active", 7),
	NO_FILE_FOR_FLOW("No file found for flow", 8),
	START_VALUES_READ_AND_VALIDATION("Started reading and validation of values", 9),
	FAIL_VALUES_READ_AND_VALIDATION("Failed reading or validation of values", 10),
	SKIP_LINE("Line skipped", 11),
	NUMBER_OF_SKIPS_TOO_BIG("Too many skips detected", 12),
	END_VALUES_READ_AND_VALIDATION("Ended reading and validation of values", 13),
	BULK_STARTED("Bulk started into DB", 14),
	BULK_FAILED("Bulk into DB failed", 15),
	BULK_ENDED("Bulk into DB ended", 16),
	FLOW_TRANSFER_COMPLETED("Flow transfer completed", 23),
	JOB_TRANSFER_COMPLETED("Job transfer completed", 24),
	FLOW_FAILED("Critical failure in flow processing", 25),
	TIMESTAMP_MALFORMATTED("Timestamp malformatted", 26),
	STARTED_TRANSFER_DATA_FROM_DB_TO_FILE("Started transfer data from DB to file", 104),
	FAILED_TRANSFER_DATA_FROM_DB_TO_FILE("Failed transfer data from DB to file", 105),
	ENDED_TRANSFER_DATA_FROM_DB_TO_FILE("Ended transfer data from DB to file", 106);
	
	private final String msg;
	private final int executionStatusId;
	
	BatchErrors(String msg, int executionStatusId) {
		this.msg = msg;
		this.executionStatusId = executionStatusId;
	}
	
	public String getMsg() {
		return this.msg;
	}

	public int getExecutionStatusId() {
		return executionStatusId;
	}
}
