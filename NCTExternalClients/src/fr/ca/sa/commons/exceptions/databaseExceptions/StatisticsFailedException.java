package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class StatisticsFailedException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Statistics Failed Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public StatisticsFailedException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Statistics Failed Exception
	 */
	public StatisticsFailedException() {
		super();
	}

	/**
	 * Statistics Failed Exception
	 * 
	 * @param message
	 * 				Message of exception 
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public StatisticsFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Statistics Failed Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public StatisticsFailedException(Throwable cause) {
		super(cause);
	}

	protected StatisticsFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
