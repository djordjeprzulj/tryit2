package fr.ca.sa.externalClients.sso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.jboss.logging.Logger;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.jose4j.json.internal.json_simple.parser.JSONParser;
import org.jose4j.json.internal.json_simple.parser.ParseException;

import fr.ca.sa.commons.configs.ConfigurationJSONConstants;

/**
 * 
 * @author Milivoj Bozic
 *
 */
public class KeyCloakConfiguration {

	private static final Logger LOGGER = Logger.getLogger(KeyCloakConfiguration.class);
	
	private String keyCloakConfigurationFileName;
	private SSOFrontendConfiguration ssoConfig;

	public KeyCloakConfiguration() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * KeyCloak Configuration
	 * 
	 * @param keyCloakConfigurationFileName
	 *            Keycloak congfiguration file name
	 *            
	 * @param nctRuntimeDirectory
	 * 			 NCT runtime directory
	 * 
	 * @throws FileNotFoundException
	 *             Throws file not found exception
	 * 
	 * @throws IOException
	 *             Throws IO exception
	 * 
	 * @throws ParseException
	 *             Throws parse exception
	 * 
	 * @throws InvalidKeySpecException
	 *             Throws invalid key exception
	 * 
	 * @throws NoSuchAlgorithmException
	 *             Throws no such algorithm exception
	 */
	public KeyCloakConfiguration(String keyCloakConfigurationFileName, String nctRuntimeDirectory)
			throws FileNotFoundException, IOException, ParseException, InvalidKeySpecException,
			NoSuchAlgorithmException {
		super();
		this.keyCloakConfigurationFileName = keyCloakConfigurationFileName;
		this.ssoConfig = readConfiguration(nctRuntimeDirectory);
	}

	private SSOFrontendConfiguration readConfiguration(String nctRuntimeDirectory) throws InvalidKeySpecException,
			NoSuchAlgorithmException, FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();
		String keycloakConfig = nctRuntimeDirectory + File.separator + keyCloakConfigurationFileName;

		// Parse External keycloak.json config file		
		FileReader fileReader = null;
		Object keycloakConfigObj = null;
		try {
			fileReader = new FileReader(keycloakConfig);
			keycloakConfigObj = parser.parse(fileReader);
		} catch (Exception ex) {
			LOGGER.error(ex);
		} finally {
			fileReader.close();
		}
				
		JSONObject keycloakConfigJSON = null;
		if (keycloakConfigObj instanceof JSONObject) {
			keycloakConfigJSON = (JSONObject) keycloakConfigObj;	
		}

		// decode pub key
		Object objKeycloakPublicKey = keycloakConfigJSON.get(ConfigurationJSONConstants.NCT_APPLICATION_KEYCLOAK_REALM_PUBLIC_KEY);
		String keycloakPublicKey = null;
		if (objKeycloakPublicKey instanceof String) {
			keycloakPublicKey = (String) objKeycloakPublicKey;
		}
		
		X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.getDecoder().decode(keycloakPublicKey));
		PublicKey key = KeyFactory.getInstance("RSA").generatePublic(spec);

		// set resource id
		Object objKeycloakResource = keycloakConfigJSON.get(ConfigurationJSONConstants.NCT_APPLICATION_KEYCLOAK_RESOURCE);
		String keycloakResource = null;
		if (objKeycloakResource instanceof String) {
			keycloakResource = (String) objKeycloakResource;
		}

		// set realm
		Object objKeycloakRealm = keycloakConfigJSON.get(ConfigurationJSONConstants.NCT_APPLICATION_KEYCLOAK_REALM);
		String keycloakRealm = null;
		if (objKeycloakRealm instanceof String) {
			keycloakRealm = (String) objKeycloakRealm;
		}

		// set auth url
		Object objKeycloakUrl = keycloakConfigJSON.get(ConfigurationJSONConstants.NCT_APPLICATION_KEYCLOAK_AUTH_SERVER_URL);
		String keycloakUrl = null;
		if (objKeycloakUrl instanceof String) {
			keycloakUrl = (String) objKeycloakUrl;
		}
		
		return new SSOFrontendConfiguration(true, keycloakRealm, keycloakResource, keycloakUrl, key);
	}

	public String getKeyCloakConfigurationFileName() {
		return keyCloakConfigurationFileName;
	}

	public void setKeyCloakConfigurationFileName(String keyCloakConfigurationFileName) {
		this.keyCloakConfigurationFileName = keyCloakConfigurationFileName;
	}

	public SSOFrontendConfiguration getSsoConfig() {
		return ssoConfig;
	}

	@Override
	public String toString() {
		return "KeyCloakConfiguration [keyCloakConfigurationFileName=" + keyCloakConfigurationFileName + "]";
	}

}
