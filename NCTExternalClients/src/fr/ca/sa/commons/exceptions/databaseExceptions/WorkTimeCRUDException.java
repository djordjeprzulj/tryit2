package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class WorkTimeCRUDException extends StatementExecutionException{

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * WorkTime CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public WorkTimeCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for WorkTime CRUD Exception
	 */
	public WorkTimeCRUDException() {
		super();
	}

	/**
	 * WorkTime CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public WorkTimeCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * WorkTime CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public WorkTimeCRUDException(Throwable cause) {
		super(cause);
	}

	protected WorkTimeCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}


}
