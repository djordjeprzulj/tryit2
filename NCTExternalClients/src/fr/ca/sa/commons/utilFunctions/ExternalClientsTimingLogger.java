package fr.ca.sa.commons.utilFunctions;

import org.jboss.logging.Logger;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ExternalClientsTimingLogger {

	private static final Logger LOGGER = Logger.getLogger(ExternalClientsTimingLogger.class);

	private ExternalClientsTimingLogger() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Log External Client Execution Timing
	 * 
	 * @param clientName
	 * 			Client name
	 * 
	 * @param startTime
	 * 			Start time
	 * 
	 * @param endTime
	 * 			End time
	 * 
	 * @param warningPeriod
	 * 			Warning period
	 * 
	 * @param functionName
	 * 			Function name
	 * 
	 * @param details
	 * 			Details
	 */
	public static void logExternalClientExecutionTiming(String clientName, long startTime, long endTime,
			long warningPeriod, String functionName, String details) {
		
		if(details  == null) {
			details = "N/A";
		}
		
		if ((endTime - startTime) <= warningPeriod) {
			LOGGER.info("[" + clientName + "] executed " + functionName + " in " + (endTime - startTime)
					+ " ms. Details: " + details);
		} else {
			LOGGER.warn("[" + clientName + "] execution of " + functionName + " took to long! - "
					+ (endTime - startTime) + " ms. Details: " + details);
		}
	}

}
