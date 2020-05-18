package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NonWorkingDaysCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * NonWorking Days CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public NonWorkingDaysCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for NonWorking Days CRUD Exception
	 */
	public NonWorkingDaysCRUDException() {
		super();
	}

	/**
	 * NonWorking Days CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public NonWorkingDaysCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * NonWorking Days CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public NonWorkingDaysCRUDException(Throwable cause) {
		super(cause);
	}

	protected NonWorkingDaysCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
