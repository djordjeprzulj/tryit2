package fr.ca.sa.commons.exceptions.webSocketExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NoMessagesFoundForSyncTokenException extends Exception {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * NoMessagesFoundForSyncTokenException
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public NoMessagesFoundForSyncTokenException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for NoMessagesFoundForSyncTokenException
	 */
	public NoMessagesFoundForSyncTokenException() {
		super();
	}

	/**
	 * NoMessagesFoundForSyncTokenException
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public NoMessagesFoundForSyncTokenException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * NoMessagesFoundForSyncTokenException
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public NoMessagesFoundForSyncTokenException(Throwable cause) {
		super(cause);
	}

	protected NoMessagesFoundForSyncTokenException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
