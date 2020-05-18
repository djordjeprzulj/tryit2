package fr.ca.sa.commons.exceptions.databaseExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class CampaignsCRUDException extends StatementExecutionException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Campaigns CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public CampaignsCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Campaigns CRUD Exception
	 */
	public CampaignsCRUDException() {
		super();
	}

	/**
	 * Campaigns CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public CampaignsCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Campaigns CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public CampaignsCRUDException(Throwable cause) {
		super(cause);
	}

	protected CampaignsCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
