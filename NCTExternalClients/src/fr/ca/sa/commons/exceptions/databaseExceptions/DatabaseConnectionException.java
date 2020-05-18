package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class DatabaseConnectionException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Database Connection Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public DatabaseConnectionException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Database Connection Exception
	 */
	public DatabaseConnectionException() {
		super();
	}

	/**
	 * Database Connection Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public DatabaseConnectionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Database Connection Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public DatabaseConnectionException(Throwable cause) {
		super(cause);
	}

	protected DatabaseConnectionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
