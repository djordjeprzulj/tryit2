package fr.ca.sa.commons.exceptions.webSocketExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class WebSocketsSendingException extends Exception {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * WebSocketsSendingException
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public WebSocketsSendingException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for WebSocketsSendingException
	 */
	public WebSocketsSendingException() {
		super();
	}

	/**
	 * WebSocketsSendingException
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public WebSocketsSendingException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * WebSocketsSendingException
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public WebSocketsSendingException(Throwable cause) {
		super(cause);
	}

	protected WebSocketsSendingException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
