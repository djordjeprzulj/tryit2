package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class LoadingConfigurationException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Loading Configuration Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public LoadingConfigurationException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Loading Configuration Exception
	 */
	public LoadingConfigurationException() {
		super();
	}

	/**
	 * Loading Configuration Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public LoadingConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Loading Configuration Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public LoadingConfigurationException(Throwable cause) {
		super(cause);
	}

	protected LoadingConfigurationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
