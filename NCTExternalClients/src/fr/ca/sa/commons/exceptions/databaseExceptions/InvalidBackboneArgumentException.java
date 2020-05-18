package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class InvalidBackboneArgumentException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Invalid Backbone Argument Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public InvalidBackboneArgumentException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Invalid Backbone Argument Exception
	 */
	public InvalidBackboneArgumentException() {
		super();
	}

	/**
	 * Invalid Backbone Argument Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public InvalidBackboneArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Invalid Backbone Argument Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public InvalidBackboneArgumentException(Throwable cause) {
		super(cause);
	}

	protected InvalidBackboneArgumentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
