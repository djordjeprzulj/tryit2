package fr.ca.sa.flowprocessing.commons.errorhandling;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Exception when flow processing failes for any reason (columns missing, unsupported
 * columns, missing file...)
 * 
 * @author Nemanja Ignjatob
 *
 */
public class JMSUnsupportedMessageTypeException extends Exception {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Flow Processing Failed Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public JMSUnsupportedMessageTypeException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Flow Processing Failed Exception
	 */
	public JMSUnsupportedMessageTypeException() {
		super();
	}

	/**
	 * Flow Processing Failed Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public JMSUnsupportedMessageTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Flow Processing Failed Exception
	 * 
	 * @param cause
	 * 				Caused of exception
	 */
	public JMSUnsupportedMessageTypeException(Throwable cause) {
		super(cause);
	}

	protected JMSUnsupportedMessageTypeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
