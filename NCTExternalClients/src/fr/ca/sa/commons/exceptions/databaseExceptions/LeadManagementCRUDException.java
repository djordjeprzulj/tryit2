package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class LeadManagementCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Lead Management CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public LeadManagementCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Lead Management CRUD Exception
	 */
	public LeadManagementCRUDException() {
		super();
	}

	/**
	 * Lead Management CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public LeadManagementCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Lead Management CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public LeadManagementCRUDException(Throwable cause) {
		super(cause);
	}

	protected LeadManagementCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
