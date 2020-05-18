package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class RoleCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Role CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public RoleCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Role CRUD Exception
	 */
	public RoleCRUDException() {
		super();
	}

	/**
	 * Role CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public RoleCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Role CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public RoleCRUDException(Throwable cause) {
		super(cause);
	}

	protected RoleCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
