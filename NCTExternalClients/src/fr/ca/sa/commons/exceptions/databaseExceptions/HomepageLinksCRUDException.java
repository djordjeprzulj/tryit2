package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class HomepageLinksCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Homepage Links CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public HomepageLinksCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Homepage Links CRUD Exception
	 */
	public HomepageLinksCRUDException() {
		super();
	}

	/**
	 * Homepage Links CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public HomepageLinksCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Homepage Links CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public HomepageLinksCRUDException(Throwable cause) {
		super(cause);
	}

	protected HomepageLinksCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
