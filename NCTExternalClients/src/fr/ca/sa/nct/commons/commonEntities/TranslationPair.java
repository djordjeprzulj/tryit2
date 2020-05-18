package fr.ca.sa.nct.commons.commonEntities;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * 
 * Entity holder for single translation key pair
 * 
 * @author Nemanja Ignjatov
 *
 */
public class TranslationPair implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String key;
	private String value;

	/**
	 * default constructor for Translation Pair
	 */
	public TranslationPair() {
		super();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Translation Pair
	 * 
	 * @param key
	 * 			Key
	 * 
	 * @param value
	 * 			Value
	 */
	public TranslationPair(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "TranslationPair [key=" + key + ", value=" + value + "]";
	}

}
