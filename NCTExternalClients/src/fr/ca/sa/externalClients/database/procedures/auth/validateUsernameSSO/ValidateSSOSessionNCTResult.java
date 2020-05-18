package fr.ca.sa.externalClients.database.procedures.auth.validateUsernameSSO;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning userId from store procedure for SSO username validation
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ValidateSSOSessionNCTResult implements StoreProcedureResult {

	private Integer userId;
	private String userName;
	private Integer userIdCore;
	private Integer userRoleId;

	/**
	 * Validate Username SSO NCT Result
	 * 
	 * @param userId     User ID
	 * 
	 * @param userName   User name
	 * 
	 * @param userIdCore User ID core
	 * 
	 * @param userRoleId User role ID
	 */
	public ValidateSSOSessionNCTResult(Integer userId, String userName, Integer userIdCore, Integer userRoleId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userIdCore = userIdCore;
		this.userRoleId = userRoleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserIdCore() {
		return userIdCore;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserIdCore(Integer userIdCore) {
		this.userIdCore = userIdCore;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	public String toString() {
		return "ValidateUsernameSSONCTResult [userId=" + userId + ", userName=" + userName + ", userIdCore="
				+ userIdCore + ", userRoleId=" + userRoleId + "]";
	}

}
