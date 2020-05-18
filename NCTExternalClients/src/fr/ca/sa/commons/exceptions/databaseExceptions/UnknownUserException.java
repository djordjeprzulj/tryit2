package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class UnknownUserException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Unknown User Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public UnknownUserException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Unknown User Exception
	 */
	public UnknownUserException() {
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
	public UnknownUserException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Unknown User Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public UnknownUserException(Throwable cause) {
		super(cause);
	}

	protected UnknownUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
