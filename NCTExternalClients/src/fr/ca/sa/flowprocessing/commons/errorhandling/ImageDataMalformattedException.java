package fr.ca.sa.flowprocessing.commons.errorhandling;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Exception when image in external file is not formatted properly
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ImageDataMalformattedException extends Exception {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Image Data Malformatted Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public ImageDataMalformattedException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Image Data Malformatted Exception
	 */
	public ImageDataMalformattedException() {
		super();
	}

	/**
	 * Image Data Malformatted Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public ImageDataMalformattedException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Image Data Malformatted Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public ImageDataMalformattedException(Throwable cause) {
		super(cause);
	}

	protected ImageDataMalformattedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
