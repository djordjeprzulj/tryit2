package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class QuickContactReportCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Quick Contact Report CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public QuickContactReportCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Quick Contact Report CRUD Exception
	 */
	public QuickContactReportCRUDException() {
		super();
	}

	/**
	 * Quick Contact Report CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public QuickContactReportCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Quick Contact Report CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public QuickContactReportCRUDException(Throwable cause) {
		super(cause);
	}

	protected QuickContactReportCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
