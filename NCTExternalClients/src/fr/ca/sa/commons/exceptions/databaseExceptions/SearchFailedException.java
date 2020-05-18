package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class SearchFailedException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Search Failed Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public SearchFailedException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Search Failed Exception
	 */
	public SearchFailedException() {
		super();
	}

	/**
	 * Search Failed Exception
	 * 
	 * @param message
	 * 				Message of exception 
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public SearchFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Search Failed Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public SearchFailedException(Throwable cause) {
		super(cause);
	}

	protected SearchFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
