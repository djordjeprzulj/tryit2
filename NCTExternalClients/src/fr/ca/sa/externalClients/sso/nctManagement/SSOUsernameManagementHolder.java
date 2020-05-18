package fr.ca.sa.externalClients.sso.nctManagement;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.ldap.nctManagement.UsernameManagementHolder;
import fr.ca.sa.nctManagement.commons.authorizationUtils.GlobalPermissions;

/**
 * 
 * SSO Authz data for SSO based authentication and authorization
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SSOUsernameManagementHolder implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private UsernameManagementHolder userMngmtDataHolder;

	private String samlToken;

	private String keyCloakJWS;

	/**
	 * default constructor for SSO Username Management Holder
	 */
	public SSOUsernameManagementHolder() {
		super();
		this.userMngmtDataHolder = new UsernameManagementHolder();
	}

	/**
	 * SSO Username Management Holder
	 * 
	 * @param username
	 * 				Username
	 * 
	 * @param roleId
	 * 				Role ID
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param permissions
	 * 				Permissions
	 * 
	 * @param samlToken
	 * 				SAML token
	 * 
	 * @param keyCloakJWS
	 * 				Keycloak JSW
	 */
	public SSOUsernameManagementHolder(String username, Integer roleId, Integer userId, GlobalPermissions permissions, String samlToken, String keyCloakJWS) {
		super();
		this.userMngmtDataHolder = new UsernameManagementHolder(username, roleId, userId, permissions);
		this.samlToken = samlToken;
		this.keyCloakJWS = keyCloakJWS;
	}

	public UsernameManagementHolder getUserDataHolder() {
		return userMngmtDataHolder;
	}

	public void setUserDataHolder(UsernameManagementHolder userDataHolder) {
		this.userMngmtDataHolder = userDataHolder;
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

	@Override
	public String toString() {
		return "SSOUsernameManagementHolder [userMngmtDataHolder=" + userMngmtDataHolder + ", samlToken=" + samlToken + ", keyCloakJWS="
				+ keyCloakJWS + "]";
	}

}
