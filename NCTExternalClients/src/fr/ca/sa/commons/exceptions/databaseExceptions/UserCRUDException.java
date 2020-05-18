package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class UserCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * User CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public UserCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor User CRUD Exception
	 */
	public UserCRUDException() {
		super();
	}

	/**
	 * User CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public UserCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * User CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public UserCRUDException(Throwable cause) {
		super(cause);
	}

	protected UserCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
