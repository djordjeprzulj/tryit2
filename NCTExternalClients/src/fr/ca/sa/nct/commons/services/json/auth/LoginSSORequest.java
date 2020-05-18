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
public class LoginSSORequest implements Serializable {
	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	private Long e;
	private String sessionId;
	/**
	 * Login Request
	 * 
	 * @param username
	 * 				Username
	 * 
	 * @param password
	 * 				Password
	 */
	public LoginSSORequest(Long e,String sessionId) {
		super();
		this.e = e;
		this.sessionId=sessionId;
		
	}
	/**
	 * default constructor for Login Request
	 */
	public LoginSSORequest() {
		super();
	}
	public Long getE() {
		return e;
	}
	public void setE(Long e) {
		this.e = e;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}

