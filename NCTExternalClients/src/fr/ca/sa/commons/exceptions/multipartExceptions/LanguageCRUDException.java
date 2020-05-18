package fr.ca.sa.commons.exceptions.multipartExceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class LanguageCRUDException extends RuntimeException {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Language CRUD Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public LanguageCRUDException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Language CRUD Exception
	 */
	public LanguageCRUDException() {
		super();
	}

	/**
	 * Language CRUD Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public LanguageCRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Language CRUD Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public LanguageCRUDException(Throwable cause) {
		super(cause);
	}

	protected LanguageCRUDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
