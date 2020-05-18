package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ParametersCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Parameters CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public ParametersCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Parameters CRUD Exception
	 */
	public ParametersCRUDException() {
		super();
	}

	/**
	 * Parameters CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception 
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public ParametersCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Parameters CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public ParametersCRUDException(Throwable cause) {
		super(cause);
	}

	protected ParametersCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
