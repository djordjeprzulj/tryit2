package fr.ca.sa.nct.commons.services.json.auth;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Public key response wrapper
 * 
 * @author Nemanja Ignjatov
 *
 */
public class KeyResponse implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String key;

	/**
	 * default constructor for Key Response
	 */
	public KeyResponse() {
		super();
	}

	/**
	 * Key Response
	 * 
	 * @param key
	 * 				Key
	 */
	public KeyResponse(String key) {
		super();
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
