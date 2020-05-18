package fr.ca.sa.externalClients.wsdl.leadservice.exceptions;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Milos Topalovic
 *
 */
public class WSDLLeadOutHandlingException extends Exception {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	/**
	 * WSDL LeadOut Handling Exception
	 * 
	 * @param msg
	 * 				Message of exception
	 */
	public WSDLLeadOutHandlingException(String msg) {
		super(msg);
	}

	/**
	 * default constructor for WSDL LeadOut Handling Exception
	 */
	public WSDLLeadOutHandlingException() {
		super();
	}

	/**
	 * WSDL LeadOut Handling Exception
	 * 
	 * @param message
	 * 				Message of exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public WSDLLeadOutHandlingException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * WSDL LeadOut Handling Exception
	 * 
	 * @param cause
	 * 				Cause of exception
	 */
	public WSDLLeadOutHandlingException(Throwable cause) {
		super(cause);
	}

	protected WSDLLeadOutHandlingException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
