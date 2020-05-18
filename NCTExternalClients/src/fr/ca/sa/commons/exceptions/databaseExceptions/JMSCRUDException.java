package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class JMSCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * JMS CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public JMSCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for JMS CRUD Exception
	 */
	public JMSCRUDException() {
		super();
	}

	/**
	 * JMS CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public JMSCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * JMS CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public JMSCRUDException(Throwable cause) {
		super(cause);
	}

	protected JMSCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
