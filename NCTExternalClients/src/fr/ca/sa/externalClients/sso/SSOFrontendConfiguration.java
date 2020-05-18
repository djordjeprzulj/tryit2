package fr.ca.sa.externalClients.sso;

import java.io.Serializable;
import java.security.PublicKey;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response JSON wrapper for SSO configuration
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SSOFrontendConfiguration implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private boolean ssoEnabled;
	private String url;
	private String clientId;
	private String realm;
	private PublicKey pubKey;

	/**
	 * default constructor for SSO Frontend Configuration
	 */
	public SSOFrontendConfiguration() {
		super();
	}

	/**
	 * SSO Frontend Configuration
	 * 
	 * @param ssoEnabled
	 *            Is SSO enabled
	 */
	public SSOFrontendConfiguration(boolean ssoEnabled) {
		super();
		this.ssoEnabled = ssoEnabled;
	}

	/**
	 * SSO Frontend Configuration
	 * 
	 * @param keyCloakRealm
	 * 			Keycloack realm
	 * 
	 * @param keyCloakResource
	 * 			Keycloak resource
	 * 
	 * @param ssoEnabled
	 *            Is SSO enabled
	 *            
	 * @param keyCloakURL
	 * 			  Keycloak URL
	 */
	public SSOFrontendConfiguration(boolean ssoEnabled, String keyCloakRealm, String keyCloakResource,
			String keyCloakURL) {
		super();
		this.ssoEnabled = ssoEnabled;
		this.realm = keyCloakRealm;
		this.clientId = keyCloakResource;
		this.url = keyCloakURL;
	}

	/**
	 * SSO Frontend Configuration
	 * 
	 * @param keyCloakRealm
	 * 			Keycloack realm
	 * 
	 * @param keyCloakResource
	 * 			Keycloak resource
	 * 
	 * @param keyCloakURL
	 * 			Keycloak URL
	 * 
	 * @param publicKey
	 * 			Public key
	 * 
	 * @param ssoEnabled
	 *            Is SSO enabled
	 */
	public SSOFrontendConfiguration(boolean ssoEnabled, String keyCloakRealm, String keyCloakResource,
			String keyCloakURL, PublicKey publicKey) {
		super();
		this.ssoEnabled = ssoEnabled;
		this.realm = keyCloakRealm;
		this.clientId = keyCloakResource;
		this.url = keyCloakURL;
		this.pubKey = publicKey;
	}

	public boolean isSsoEnabled() {
		return ssoEnabled;
	}

	public void setSsoEnabled(boolean ssoEnabled) {
		this.ssoEnabled = ssoEnabled;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRealm() {
		return realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public PublicKey getPubKey() {
		return pubKey;
	}

	public void setPubKey(PublicKey pubKey) {
		this.pubKey = pubKey;
	}

	@Override
	public String toString() {
		return "AuthenticationConfiguration [ssoEnabled=" + ssoEnabled + ", url=" + url + ", realm= " + realm
				+ ", clientId=" + clientId + "]";
	}

}
