package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class CodeTablesCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Code Tables CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public CodeTablesCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Code Tables CRUD Exception
	 */
	public CodeTablesCRUDException() {
		super();
	}

	/**
	 * Code Tables CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public CodeTablesCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Code Tables CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public CodeTablesCRUDException(Throwable cause) {
		super(cause);
	}

	protected CodeTablesCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
