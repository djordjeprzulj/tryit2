package fr.ca.sa.commons.exceptions.webSocketExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SyncTokenNotFoundException extends Exception {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * SyncTokenNotFoundException
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public SyncTokenNotFoundException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for SyncTokenNotFoundException
	 */
	public SyncTokenNotFoundException() {
		super();
	}

	/**
	 * SyncTokenNotFoundException
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public SyncTokenNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * SyncTokenNotFoundException
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public SyncTokenNotFoundException(Throwable cause) {
		super(cause);
	}

	protected SyncTokenNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
