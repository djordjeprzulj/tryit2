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
public class CountryConfigurationRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String language;
	private boolean loadAdvisors;
	private boolean loadEntities;
	/**
	 * default constructor for Opportunities Configuration Request
	 */
	public CountryConfigurationRequest() {
		super();
	}

	/**
	 * Opportunities Configuration Request
	 * 
	 * @param language
	 * 				Language
	 */
	public CountryConfigurationRequest(String language) {
		super();
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isLoadAdvisors() {
		return loadAdvisors;
	}

	public void setLoadAdvisors(boolean loadAdvisors) {
		this.loadAdvisors = loadAdvisors;
	}

	public boolean isLoadEntities() {
		return loadEntities;
	}

	public void setLoadEntities(boolean loadEntities) {
		this.loadEntities = loadEntities;
	}

}
