package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ToDoListCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * To Do List CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public ToDoListCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for ToDo List CRUD Exception
	 */
	public ToDoListCRUDException() {
		super();
	}

	/**
	 * To Do List CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public ToDoListCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * To Do List CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public ToDoListCRUDException(Throwable cause) {
		super(cause);
	}

	protected ToDoListCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
