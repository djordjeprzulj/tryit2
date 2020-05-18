package fr.ca.sa.externalClients.sso.nct;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.procedures.users.getUserEntities.UserEntitiesList;
import fr.ca.sa.externalClients.database.common.procedures.users.getUserPortfolio.UserPortfolioList;
import fr.ca.sa.externalClients.database.common.procedures.users.getUserRoles.GetUserRoleNCTResult;
import fr.ca.sa.nct.commons.commonEntities.UsernameRoleHolder;

/**
 * 
 * SSO Authz data for SSO based authentication and authorization
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SSOUserDataHolder implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private UsernameRoleHolder userDataHolder;

	private String samlToken;

	private String keyCloakJWS;

	private String channel;

	private Long exp;

	private String sessionId;

	/**
	 * default constructor for SSO User Data Holder
	 */
	public SSOUserDataHolder() {
		super();
		this.userDataHolder = new UsernameRoleHolder();
	}

	/**
	 * SSO User Data Holder
	 * 
	 * @param username          Username
	 * 
	 * @param userId            User ID
	 * 
	 * @param userCoreId        User core ID
	 * 
	 * @param role              Role for user
	 * 
	 * @param entitiesList      Entities list
	 * 
	 * @param userPortfolioList User's portfolio list
	 * 
	 * @param samlToken         SAML token
	 * 
	 * @param keyCloakJWS       Keycloack JWS token
	 * 
	 * @param channel           Channel
	 */
	public SSOUserDataHolder(String username, int userId, Integer userCoreId, GetUserRoleNCTResult role,
			UserEntitiesList entitiesList, UserPortfolioList userPortfolioList, String samlToken, String keyCloakJWS,
			String channel, Long exp, String sessionId) {
		super();
		this.userDataHolder = new UsernameRoleHolder(username, userId, userCoreId, role, entitiesList,
				userPortfolioList);
		this.samlToken = samlToken;
		this.keyCloakJWS = keyCloakJWS;
		this.channel = channel;
		this.exp = exp;
		this.sessionId = sessionId;
	}

	public UsernameRoleHolder getUserDataHolder() {
		return userDataHolder;
	}

	public void setUserDataHolder(UsernameRoleHolder userDataHolder) {
		this.userDataHolder = userDataHolder;
	}

	public String getSamlToken() {
		return samlToken;
	}

	public void setSamlToken(String samlToken) {
		this.samlToken = samlToken;
	}

	public String getKeyCloakJWS() {
		return keyCloakJWS;
	}

	public void setKeyCloakJWS(String keyCloakJWS) {
		this.keyCloakJWS = keyCloakJWS;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Long getExp() {
		return exp;
	}

	public void setExp(Long exp) {
		this.exp = exp;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "SSOUserDataHolder [userDataHolder=" + userDataHolder + ", samlToken=" + samlToken + ", keyCloakJWS="
				+ keyCloakJWS + ", channel=" + channel + "]";
	}

}
