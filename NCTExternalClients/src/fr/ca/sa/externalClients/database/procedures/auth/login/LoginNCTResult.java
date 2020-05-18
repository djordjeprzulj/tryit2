package fr.ca.sa.externalClients.database.procedures.auth.login;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning userId from store login procedure
 * 
 * @author Nemanja Ignjatov
 *
 */
public class LoginNCTResult implements StoreProcedureResult {

	private Integer userId;
	private Integer userIdCore;

	/**
	 * Login NCT Result
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param userIdCore
	 * 				User ID core
	 */
	public LoginNCTResult(Integer userId, Integer userIdCore) {
		this.userId = userId;
		this.userIdCore = userIdCore;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getUserIdCore() {
		return userIdCore;
	}

	@Override
	public String toString() {
		return "LoginNCTResult [userId=" + userId + ", userIdCore=" + userIdCore + "]";
	}

}
