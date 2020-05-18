package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class AgendaCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Agenda CRUD Exception
	 * 
	 * @param msg
	 * 				Message
	 */
	public AgendaCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Agenda CRUD Exception 
	 */
	public AgendaCRUDException() {
		super();
	}

	/**
	 * Agenda CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public AgendaCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Agenda CRUD Exception
	 * 
	 * @param cause
	 * 				Cause
	 */
	public AgendaCRUDException(Throwable cause) {
		super(cause);
	}

	protected AgendaCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
