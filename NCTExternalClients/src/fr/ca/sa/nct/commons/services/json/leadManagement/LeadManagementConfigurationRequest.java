package fr.ca.sa.nct.commons.services.json.leadManagement;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request JSON wrapper for getting lead prospects configuration
 * 
 * 
 * @author Nemanja Ignjatov
 *
 */
public class LeadManagementConfigurationRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private boolean callNumbersRequired;
	private boolean attributesConfigurationRequired;
	private boolean countriesRequired;
	private boolean clientTypesRequired;

	public LeadManagementConfigurationRequest() {
	}

	/**
	 * Lead Management Configuration Request
	 * 
	 * @param callNumbersRequired
	 * 				Call numbers
	 * 
	 * @param attributesConfigurationRequired
	 * 				Attributes configuration
	 * 
	 * @param countriesRequired
	 * 				Countries
	 * 
	 * @param clientTypesRequired
	 * 				Client type
	 */
	public LeadManagementConfigurationRequest(boolean callNumbersRequired, boolean attributesConfigurationRequired,
			boolean countriesRequired, boolean clientTypesRequired) {
		super();
		this.callNumbersRequired = callNumbersRequired;
		this.attributesConfigurationRequired = attributesConfigurationRequired;
		this.countriesRequired = countriesRequired;
		this.clientTypesRequired = clientTypesRequired;
	}

	public boolean isCallNumbersRequired() {
		return callNumbersRequired;
	}

	public void setCallNumbersRequired(boolean callNumbersRequired) {
		this.callNumbersRequired = callNumbersRequired;
	}

	public boolean isAttributesConfigurationRequired() {
		return attributesConfigurationRequired;
	}

	public void setAttributesConfigurationRequired(boolean attributesConfigurationRequired) {
		this.attributesConfigurationRequired = attributesConfigurationRequired;
	}

	public boolean isCountriesRequired() {
		return countriesRequired;
	}

	public void setCountriesRequired(boolean countriesRequired) {
		this.countriesRequired = countriesRequired;
	}

	public boolean isClientTypesRequired() {
		return clientTypesRequired;
	}

	public void setClientTypesRequired(boolean clientTypesRequired) {
		this.clientTypesRequired = clientTypesRequired;
	}

	@Override
	public String toString() {
		return "LeadManagementConfigurationRequest [callNumbersRequired=" + callNumbersRequired
				+ ", attributesConfigurationRequired=" + attributesConfigurationRequired + ", countriesRequired="
				+ countriesRequired + ", clientTypesRequired=" + clientTypesRequired + "]";
	}

}
