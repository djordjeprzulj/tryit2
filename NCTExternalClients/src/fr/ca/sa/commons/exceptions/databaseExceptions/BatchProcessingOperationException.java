package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class BatchProcessingOperationException extends StatementExecutionException{

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Batch Processing Operation Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public BatchProcessingOperationException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Batch Processing Operation Exception
	 */
	public BatchProcessingOperationException() {
		super();
	}

	/**
	 * Batch Processing Operation Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public BatchProcessingOperationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Batch Processing Operation Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public BatchProcessingOperationException(Throwable cause) {
		super(cause);
	}

	protected BatchProcessingOperationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}


}
