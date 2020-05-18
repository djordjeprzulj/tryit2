package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request JSON wrapper for get opportunities configuration
 * 
 * @author Nemanja Ignjatov
 *
 */
public class OpportunitiesConfigurationRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String language;

	/**
	 * default constructor for Opportunities Configuration Request
	 */
	public OpportunitiesConfigurationRequest() {
		super();
	}

	/**
	 * Opportunities Configuration Request
	 * 
	 * @param language
	 * 				Language
	 */
	public OpportunitiesConfigurationRequest(String language) {
		super();
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
