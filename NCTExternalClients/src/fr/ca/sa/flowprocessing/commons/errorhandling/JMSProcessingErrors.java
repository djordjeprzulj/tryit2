package fr.ca.sa.flowprocessing.commons.errorhandling;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public enum JMSProcessingErrors {

	FLOW_TRANSFER_STARTED("Flow transfer started", 6, false),
	FLOW_IS_NOT_ACTIVE("Flow is not active", 7, true),
	NO_FILE_FOR_FLOW("No file found for flow", 8, true),
	START_VALUES_READ_AND_VALIDATION("Started reading and validation of values", 9, false),
	FAIL_VALUES_READ_AND_VALIDATION("Failed reading or validation of values", 10, true),
	SKIP_LINE("Line skipped", 11, false),
	NUMBER_OF_SKIPS_TOO_BIG("Too many skips detected", 12, true),
	END_VALUES_READ_AND_VALIDATION("Ended reading and validation of values", 13, false),
	BULK_STARTED("Bulk started into DB", 14, false),
	BULK_FAILED("Bulk into DB failed", 15, true),
	BULK_ENDED("Bulk into DB ended", 16, false),
	FLOW_TRANSFER_COMPLETED("Flow transfer completed", 23, false),
	FLOW_FAILED("Critical failure in flow processing", 25, true ),
	STARTED_TRANSFER_DATA_FROM_DB_TO_FILE("Started transfer data from DB to file", 104, false),
	FAILED_TRANSFER_DATA_FROM_DB_TO_FILE("Failed transfer data from DB to file", 105, true),
	ENDED_TRANSFER_DATA_FROM_DB_TO_FILE("Ended transfer data from DB to file", 106, false),
	JMS_CURRENTLY_EXECUTED("JMS currently being executed", 201, true),
	JMS_NOT_ACTIVE("JMS flow processing not allowed through parametrisation", 202, true),
	NO_FLOWS_FOR_JMS("No flows defined for JMS", 203, true),
	NO_ACTIVE_FLOWS_FOR_JMS("No active flows detected for JMS", 204, true),
	JMS_TRANSFER_STARTED("JMS transfer started", 205, false),
	JMS_TRANSFER_COMPLETED("JMS transfer completed", 224, false);
	
	private final String msg;
	private final int executionStatusId;
	private boolean terminationError;
	
	JMSProcessingErrors(String msg, int executionStatusId, boolean terminationError) {
		this.msg = msg;
		this.executionStatusId = executionStatusId;
		this.terminationError = terminationError;
	}
	
	public String getMsg() {
		return this.msg;
	}

	public int getExecutionStatusId() {
		return executionStatusId;
	}

	public boolean isTerminationError() {
		return terminationError;
	}
	
	
}
