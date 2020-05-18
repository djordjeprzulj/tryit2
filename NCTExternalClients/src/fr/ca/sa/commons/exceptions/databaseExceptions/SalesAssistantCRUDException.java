package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SalesAssistantCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Sales Assistant CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public SalesAssistantCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Sales Assistant CRUD Exception
	 */
	public SalesAssistantCRUDException() {
		super();
	}

	/**
	 * Sales Assistant CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception 
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public SalesAssistantCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Sales Assistant CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public SalesAssistantCRUDException(Throwable cause) {
		super(cause);
	}

	protected SalesAssistantCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
