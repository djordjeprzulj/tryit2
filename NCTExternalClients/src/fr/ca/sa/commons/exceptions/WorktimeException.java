package fr.ca.sa.commons.exceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class WorktimeException extends RuntimeException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Worktime Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public WorktimeException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Worktime Exception
	 */
	public WorktimeException() {
		super();
	}

	/**
	 * Worktime Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public WorktimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Worktime Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public WorktimeException(Throwable cause) {
		super(cause);
	}

	protected WorktimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
