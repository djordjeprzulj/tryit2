package fr.ca.sa.commons.exceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 *         Subclass for exceptions that should be throw through lambda
 *         expression code blocks
 */
public class LambdaRuntimeCustomException extends RuntimeException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Lambda Runtime Custom Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public LambdaRuntimeCustomException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Lambda Runtime Custom Exception
	 */
	public LambdaRuntimeCustomException() {
		super();
	}

	/**
	 * Lambda Runtime Custom Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public LambdaRuntimeCustomException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Lambda Runtime Custom Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public LambdaRuntimeCustomException(Throwable cause) {
		super(cause);
	}

	protected LambdaRuntimeCustomException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
