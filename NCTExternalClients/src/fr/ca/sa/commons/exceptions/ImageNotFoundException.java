package fr.ca.sa.commons.exceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ImageNotFoundException extends Exception {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Image Not Found Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public ImageNotFoundException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Image Not Found Exception
	 */
	public ImageNotFoundException() {
		super();
	}

	/**
	 * Image Not Found Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public ImageNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Image Not Found Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public ImageNotFoundException(Throwable cause) {
		super(cause);
	}

	protected ImageNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
