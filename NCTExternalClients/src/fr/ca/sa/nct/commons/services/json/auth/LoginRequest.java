package fr.ca.sa.nct.commons.services.json.auth;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Login Request from web client
 * 
 * @author Sasa Radovanovic
 *
 */
public class LoginRequest implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String username;

	private String password;

	/**
	 * Login Request
	 * 
	 * @param username
	 * 				Username
	 * 
	 * @param password
	 * 				Password
	 */
	public LoginRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * default constructor for Login Request
	 */
	public LoginRequest() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
