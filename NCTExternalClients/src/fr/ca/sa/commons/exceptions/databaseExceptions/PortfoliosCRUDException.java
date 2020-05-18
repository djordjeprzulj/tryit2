package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class PortfoliosCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Portfolios CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public PortfoliosCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Portfolios CRUD Exception
	 */
	public PortfoliosCRUDException() {
		super();
	}

	/**
	 * Portfolios CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception 
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public PortfoliosCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Portfolios CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public PortfoliosCRUDException(Throwable cause) {
		super(cause);
	}

	protected PortfoliosCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
