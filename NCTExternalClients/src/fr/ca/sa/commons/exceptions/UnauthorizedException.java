package fr.ca.sa.commons.exceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 *         Exception that occurs operation authz failed
 */
public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Unauthorized Exception
	 * 
	 * @param msg
	 */
	public UnauthorizedException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Unauthorized Exception
	 */
	public UnauthorizedException() {
		super();
	}

	/**
	 * Unauthorized Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public UnauthorizedException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Unauthorized Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public UnauthorizedException(Throwable cause) {
		super(cause);
	}

	protected UnauthorizedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
