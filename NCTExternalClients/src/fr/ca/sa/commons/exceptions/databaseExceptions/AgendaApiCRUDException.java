package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class AgendaApiCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Agenda Api CRUD Exception
	 * 
	 * @param msg
	 *            Message
	 */
	public AgendaApiCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Agenda Api CRUD Exception
	 */
	public AgendaApiCRUDException() {
		super();
	}

	/**
	 * Agenda Api CRUD Exception
	 * 
	 * @param message
	 *            Message of exception
	 * 
	 * @param cause
	 *            Cause of exception
	 */
	public AgendaApiCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Agenda Api CRUD Exception
	 * 
	 * @param cause
	 *            Cause
	 */
	public AgendaApiCRUDException(Throwable cause) {
		super(cause);
	}

	protected AgendaApiCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
