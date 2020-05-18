package fr.ca.sa.commons.exceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 *         Exception that occurs when system can't handle current error
 */
public class CriticalSystemErrorException extends RuntimeException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Critical System Error Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public CriticalSystemErrorException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Critical System Error Exception
	 */
	public CriticalSystemErrorException() {
		super();
	}

	/**
	 * Critical System Error Exception 
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public CriticalSystemErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Critical System Error Exception 
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public CriticalSystemErrorException(Throwable cause) {
		super(cause);
	}

	protected CriticalSystemErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
