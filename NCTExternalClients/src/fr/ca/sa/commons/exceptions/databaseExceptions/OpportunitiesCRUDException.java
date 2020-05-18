package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class OpportunitiesCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Opportunities CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public OpportunitiesCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Opportunities CRUD Exception
	 */
	public OpportunitiesCRUDException() {
		super();
	}

	/**
	 * Opportunities CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception 
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public OpportunitiesCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Opportunities CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public OpportunitiesCRUDException(Throwable cause) {
		super(cause);
	}

	protected OpportunitiesCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
