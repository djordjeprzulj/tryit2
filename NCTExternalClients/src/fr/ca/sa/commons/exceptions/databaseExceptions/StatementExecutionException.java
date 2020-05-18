package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class StatementExecutionException extends RuntimeException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Statement Execution Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public StatementExecutionException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Statement Execution Exception
	 */
	public StatementExecutionException() {
		super();
	}

	/**
	 * Statement Execution Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public StatementExecutionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Statement Execution Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public StatementExecutionException(Throwable cause) {
		super(cause);
	}

	protected StatementExecutionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
