package fr.ca.sa.externalClients.sso;

import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.security.auth.login.CredentialException;

import org.jboss.logging.Logger;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.jose4j.json.internal.json_simple.parser.JSONParser;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Keycloak token handling bean
 * 
 * @author Milivoj Bozic
 *
 */
public class KeyCloakHandler {

	private static final Logger LOGGER = Logger.getLogger(KeyCloakHandler.class);

	// JWT Consumer used for encoding received token
	private static JwtConsumer jwtConsumer;

	private KeyCloakHandler() {
		throw new IllegalStateException("Utility class");
	}
	/**
	 * 
	 * Retrieve JWT Consumer for encoding and reading token
	 * 
	 * @return jwtConsumer - jwtConsumer object
	 * @throws InvalidKeySpecException
	 */
	private static JwtConsumer getJwtConsumer(String keyCloakResource, PublicKey resourcePublicKey)
			throws InvalidKeySpecException {
		if (jwtConsumer == null) {
			jwtConsumer = new JwtConsumerBuilder()
					// the JWT must have an expiration time
					.setRequireExpirationTime()
					// verify client id
					.setExpectedAudience(keyCloakResource)
					// verify the signature with the sender's public key
					.setVerificationKey(resourcePublicKey)
					// create the JwtConsumer instance
					.build();
		}
		return jwtConsumer;
	}

	/**
	 * Strips prefix 'Bearer'
	 * 
	 * @param jwt
	 * @return
	 * @throws CredentialException
	 */
	private static String stripToken(String jwt) throws CredentialException {
		String jwtStripped = jwt;
		if (jwt.startsWith(ProjectConstants.BEARER_PREFIX)) {
			jwtStripped = jwt.substring(ProjectConstants.BEARER_PREFIX.length()).trim();
		} else {
			LOGGER.error(" JWT Invalid Bearer token.");
			LOGGER.error("INVALID Token: "+jwt);
			throw new CredentialException();
		}
		return jwtStripped;
	}

	/**
	 * Parses JWT payload
	 * 
	 * @param jwt
	 * @return
	 * @throws JoseException
	 * @throws CredentialException
	 */
	private static String getJwtPayload(String jwt, PublicKey keycloakPublicKey)
			throws JoseException, CredentialException {
		String jwtStripped = stripToken(jwt);

		JsonWebSignature jws = new JsonWebSignature();
		jws.setCompactSerialization(jwtStripped);
		jws.setKey(keycloakPublicKey);
		return jws.getPayload();
	}

	/**
	 * Verify if token is valid
	 * 
	 * @param keyCloakResource
	 * @param resourcePublicKey
	 * @param jwt
	 * @return
	 * @throws CredentialException
	 */
	public static int verifyToken(String jwt, String keyCloakResource, PublicKey resourcePublicKey)
			throws CredentialException {
		String jwtStripped = stripToken(jwt);

		try {
			JwtConsumer jwtConsumer = getJwtConsumer(keyCloakResource, resourcePublicKey);
			jwtConsumer.processToClaims(jwtStripped);
		} catch (Exception ex) {
				
			LOGGER.error(" JWT Invalid Bearer token.");
			LOGGER.error(ex);
			throw new CredentialException();
		}
		return 0;
	}

	/**
	 * Get JWT username
	 * 
	 * @param keycloakPublicKey
	 * @param jwt
	 * @return
	 */
	public static String getJwtUsername(String jwt, PublicKey keycloakPublicKey) {
		try {
			String jwtPayload = getJwtPayload(jwt, keycloakPublicKey);
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(jwtPayload);
			JSONObject jsonObject = null;
			if (obj instanceof JSONObject) {
				jsonObject = (JSONObject) obj;	
			}
			String strUsername = null;
			Object objUsername = jsonObject.get(ProjectConstants.PREFERED_USERNAME); 
			if (objUsername instanceof String) {
				strUsername = (String) objUsername;
			}
			return strUsername;
		} catch (Exception ex) {
			LOGGER.error(" JWT Bearer token parse error get Jwt Username.");
			LOGGER.error(ex);
			return null;
		}
	}

	/**
	 * Get Jwt Channel
	 * 
	 * @param jwt
	 * 			JWT token
	 * 
	 * @param keycloakPublicKey
	 * 			Keycloak public key
	 * 
	 * @return returns JWT channel
	 */
	public static String getJwtChannel(String jwt, PublicKey keycloakPublicKey) {
		try {
			String jwtPayload = getJwtPayload(jwt, keycloakPublicKey);
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(jwtPayload);
			JSONObject jsonObject = null;
			if (obj instanceof JSONObject) {
				jsonObject = (JSONObject) obj;	
			}
			String strChannel = null;
			Object objChannel = jsonObject.get(ProjectConstants.CHANNEL);
			if (objChannel instanceof String) {
				strChannel = (String) objChannel;
			}
			return strChannel;
		} catch (Exception ex) {
			LOGGER.error(" JWT Bearer token parse error getJwtChannel.");
			LOGGER.error(ex);
			return null;
		}
	}
	/**
	 * Get JWS validity period
	 * 
	 * @param keycloakPublicKey
	 * @param jws
	 * @return
	 */
	public static long getJwsValidityPeriod(String jws, PublicKey keycloakPublicKey) {
		try {
			String jwsPayload = getJwtPayload(jws, keycloakPublicKey);
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(jwsPayload);
			JSONObject jsonObject = null;
			if (obj instanceof JSONObject) {
				jsonObject = (JSONObject) obj;	
			}
			Object authTimeObj = jsonObject.get(ProjectConstants.AUTH_TIME);
			Object expObj = jsonObject.get(ProjectConstants.EXPIRATION);
			if (authTimeObj != null && expObj != null) {
				Long authTime = (Long) authTimeObj;
				Long exp = (Long) expObj;
				return exp - authTime;
			} else {
				return ProjectConstants.INDEFINITE_CACHE_EXPIRATION;
			}
		} catch (Exception ex) {
			LOGGER.error(" JWT Bearer token parse error for get Jws Validity Period.");
			LOGGER.error(ex);
			// Return indefinite validity
			return ProjectConstants.INDEFINITE_CACHE_EXPIRATION;
		}
	}

	/**
	 * Get JWT groups
	 * 
	 * @param keycloakPublicKey
	 * @param jwt
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getJwtGroups(String jwt, PublicKey keycloakPublicKey) {
		try {
			String jwtPayload = getJwtPayload(jwt, keycloakPublicKey);
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(jwtPayload);
			JSONObject jsonObject = null;
			if (obj instanceof JSONObject) {
				jsonObject = (JSONObject) obj;	
			}
			Object objList = jsonObject.get(ProjectConstants.GROUPS);
			List<String> retList = null; 
			if (objList instanceof List<?>) {
				retList = (List<String>) objList ; 
			}
			return retList;
		} catch (Exception ex) {
			LOGGER.error(" JWT Bearer token parse error get Jwt Groups.");
			LOGGER.error(ex);
			// return Collections.emptyList();
			return null;
		}
	}

	/**
	 * Get JWT username
	 * 
	 * @param keycloakPublicKey
	 * @param jwt
	 * @return
	 */
	public static Integer getJwtPlaceId(String jwt, PublicKey keycloakPublicKey) {
		try {
			String jwtPayload = getJwtPayload(jwt, keycloakPublicKey);
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(jwtPayload);
			JSONObject jsonObject = null;
			if (obj instanceof JSONObject) {
				jsonObject = (JSONObject) obj;	
			}
			// return (Integer) jsonObject.get(ProjectConstants.PLACE_ID);
			return new Integer(jsonObject.get(ProjectConstants.PLACE_ID).toString());
		} catch (Exception ex) {
			LOGGER.error(" JWT Bearer token parse error for get Jwt PlaceId.");
			LOGGER.error(ex);
			return null;
		}
	}
	
	/**
	 * Get JWT operatorId
	 * 
	 * @param keycloakPublicKey
	 * @param jwt
	 * @return
	 */
	public static String getJwtOperatorId(String jwt, PublicKey keycloakPublicKey) {
		try {
			String jwtPayload = getJwtPayload(jwt, keycloakPublicKey);
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(jwtPayload);
			JSONObject jsonObject = null;
			if (obj instanceof JSONObject) {
				jsonObject = (JSONObject) obj;	
			}
			Object objId = jsonObject.get(ProjectConstants.OPERATOR_ID);
			Long id = null;
			if (objId instanceof Long) {
				id = (Long) objId;
			}
			return id.toString();
		} catch (Exception ex) {
			LOGGER.error(" JWT Bearer token parse error for get Jwt OperatorId.");
			LOGGER.error(ex);
			return null;
		}
	}

	/**
	 * Get Jwt SslbId
	 * 
	 * @param jwt
	 * 			JWT token
	 * 
	 * @param keycloakPublicKey
	 * 			Keycloak public key
	 * 
	 * @return returns JWT channel
	 */
	public static String getJwtSslbId(String jwt, PublicKey keycloakPublicKey) {
		try {
			String jwtPayload = getJwtPayload(jwt, keycloakPublicKey);
			JSONParser parser = new JSONParser();			
			Object obj = parser.parse(jwtPayload);
			JSONObject jsonObject = null;
			if (obj instanceof JSONObject) {
				jsonObject = (JSONObject) obj;	
			}
			String strSslbId = null;
			Object objSslbId = jsonObject.get("sslbId"); 
			if (objSslbId instanceof String) {
				strSslbId = (String) objSslbId;
			}
			return strSslbId;
		} catch (Exception ex) {
			LOGGER.error(" JWT Bearer token parse error getJwtSslbId.");
			LOGGER.error(ex);
			return null;
		}
	}

}

