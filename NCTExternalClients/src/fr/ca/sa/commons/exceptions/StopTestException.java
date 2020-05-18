package fr.ca.sa.commons.exceptions;

/**
 * 
 * Custom runtime exception used for stopping application after running tests
 * 
 * @author Stevan Mihajlov
 *
 */
public class StopTestException extends RuntimeException {

	private static final long serialVersionUID = 6086211841716555230L;

	/**
	 * default constructor for Stop Test Exception
	 */
	public StopTestException() {
		super();
	}

	/**
	 * Stop Test Exception
	 * 
	 * @param message
	 * 				Message of exception
	 */
	public StopTestException(String message) {
		super(message);
	}

}
