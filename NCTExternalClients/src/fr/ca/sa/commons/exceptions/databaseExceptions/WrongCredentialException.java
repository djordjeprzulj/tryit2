package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * @author nignjatov
 *
 *	Exception for notifying user that entered credentials are wrong on invoking login REST method
 *	DO NOT USE FOR SESSION HANDLING AND FORBIDDING UNAUTHORIZED ACCESS
 */
public class WrongCredentialException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Wrong Credential Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public WrongCredentialException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Wrong Credential Exception
	 */
	public WrongCredentialException() {
		super();
	}

	/**
	 * Wrong Credential Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public WrongCredentialException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Wrong Credential Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public WrongCredentialException(Throwable cause) {
		super(cause);
	}

	protected WrongCredentialException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
