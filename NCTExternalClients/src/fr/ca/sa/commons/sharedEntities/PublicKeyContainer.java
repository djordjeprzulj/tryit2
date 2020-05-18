package fr.ca.sa.commons.sharedEntities;

import java.io.Serializable;
import java.security.interfaces.RSAPrivateKey;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class PublicKeyContainer implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private RSAPrivateKey rsaPrivateKey = null;

	private String rsaPublicKey = null;

	/**
	 * default constructor for Serial Bean
	 */
	public PublicKeyContainer() {
	}

	public RSAPrivateKey getRsaPrivateKey() {
		return rsaPrivateKey;
	}

	public String getRsaPublicKey() {
		return rsaPublicKey;
	}

	/**
	 * Sets RSA KeyPair
	 * 
	 * @param rsaPrivateKey
	 *            RSA private key
	 * 
	 * @param rsaPublicKey
	 *            RSA public key
	 */
	public synchronized void setRSAKeyPair(RSAPrivateKey rsaPrivateKey, String rsaPublicKey) {
		this.rsaPrivateKey = rsaPrivateKey;
		this.rsaPublicKey = rsaPublicKey;
	}

}
