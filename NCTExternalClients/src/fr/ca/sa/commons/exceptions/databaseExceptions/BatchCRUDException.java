package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class BatchCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Batch CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public BatchCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Batch CRUD Exception
	 */
	public BatchCRUDException() {
		super();
	}

	/**
	 * Batch CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public BatchCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Batch CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public BatchCRUDException(Throwable cause) {
		super(cause);
	}

	protected BatchCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
