package fr.ca.sa.flowprocessing.commons.errorhandling;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Exception when batch input files is malformated (columns missing, unsupported
 * columns...)
 * 
 * @author Nemanja Ignjatov
 *
 */
public class FlowImportReadPhaseFailedException extends Exception {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * Flow Import Read Phase Failed Exception
	 * 
	 * @param msg
	 * 				MEssage of exception
	 */
	public FlowImportReadPhaseFailedException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for Flow Import Read Phase Failed Exception
	 */
	public FlowImportReadPhaseFailedException() {
		super();
	}

	/**
	 * Flow Import Read Phase Failed Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public FlowImportReadPhaseFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Flow Import Read Phase Failed Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public FlowImportReadPhaseFailedException(Throwable cause) {
		super(cause);
	}

	protected FlowImportReadPhaseFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
