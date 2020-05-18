package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ClientCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Client CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public ClientCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Client CRUD Exception
	 */
	public ClientCRUDException() {
		super();
	}

	/**
	 * Client CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public ClientCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Client CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public ClientCRUDException(Throwable cause) {
		super(cause);
	}

	protected ClientCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
