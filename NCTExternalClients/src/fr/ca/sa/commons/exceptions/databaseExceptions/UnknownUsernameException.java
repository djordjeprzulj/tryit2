package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Milos Topalovic
 *
 */
public class UnknownUsernameException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Unknown User Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public UnknownUsernameException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Unknown User Exception
	 */
	public UnknownUsernameException() {
		super();
	}

	/**
	 * Unknown User Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public UnknownUsernameException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Unknown User Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public UnknownUsernameException(Throwable cause) {
		super(cause);
	}

	protected UnknownUsernameException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

