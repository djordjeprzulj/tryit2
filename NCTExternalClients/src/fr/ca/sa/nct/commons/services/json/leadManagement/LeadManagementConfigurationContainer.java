package fr.ca.sa.nct.commons.services.json.leadManagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.nct.procedures.leadManagement.configurationItems.LeadManagementNCTExtendedResultItem;
import fr.ca.sa.externalClients.database.nct.procedures.leadManagement.getCountryCallNumbers.GetCountryCallNumbersNCTResultItem;
import fr.ca.sa.nct.commons.commonEntities.TranslatableElementConf;

/**
 * 
 * Response JSON wrapper for getting lead prospects configuration
 * 
 * 
 * @author Nemanja Ignjatov
 *
 */
public class LeadManagementConfigurationContainer implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetCountryCallNumbersNCTResultItem> callNumbers;

	private Map<String, ArrayList<TranslatableElementConf>> attributesConfiguration;

	private List<CountriesConfigurationJsonItem> countries;

	private transient Map<String, List<LeadManagementNCTExtendedResultItem>> clientTypes;

	/**
	 * default constructor for Lead Management Configuration Container
	 */
	public LeadManagementConfigurationContainer() {
		super();
		this.attributesConfiguration = new HashMap<>();
		this.countries = new ArrayList<CountriesConfigurationJsonItem>();
		this.clientTypes = new HashMap<>();
	}

	/**
	 * Lead Management Configuration Container
	 * 
	 * @param callNumbers
	 * 				Call numbers
	 * 
	 * @param attributesConfiguration	
	 * 				Attributes configuration
	 * 
	 * @param countries
	 * 				Countries
	 * 
	 * @param clientTypes
	 * 				Client types
	 */
	public LeadManagementConfigurationContainer(List<GetCountryCallNumbersNCTResultItem> callNumbers,
			Map<String, ArrayList<TranslatableElementConf>> attributesConfiguration,
			List<CountriesConfigurationJsonItem> countries,
			Map<String, List<LeadManagementNCTExtendedResultItem>> clientTypes) {
		super();
		this.callNumbers = callNumbers;
		this.attributesConfiguration = attributesConfiguration;
		this.countries = countries;
		this.clientTypes = clientTypes;
	}

	public List<GetCountryCallNumbersNCTResultItem> getCallNumbers() {
		return callNumbers;
	}

	public void setCallNumbers(List<GetCountryCallNumbersNCTResultItem> callNumbers) {
		this.callNumbers = callNumbers;
	}

	public Map<String, ArrayList<TranslatableElementConf>> getAttributesConfiguration() {
		return attributesConfiguration;
	}

	public void setAttributesConfiguration(
			Map<String, ArrayList<TranslatableElementConf>> attributesConfiguration) {
		this.attributesConfiguration = attributesConfiguration;
	}

	public List<CountriesConfigurationJsonItem> getCountries() {
		return countries;
	}

	public void setCountries(List<CountriesConfigurationJsonItem> countries) {
		this.countries = countries;
	}

	public Map<String, List<LeadManagementNCTExtendedResultItem>> getClientTypes() {
		return clientTypes;
	}

	public void setClientTypes(Map<String, List<LeadManagementNCTExtendedResultItem>> clientTypes) {
		this.clientTypes = clientTypes;
	}

	@Override
	public String toString() {
		return "LeadManagementConfigurationContainer [callNumbers=" + callNumbers + ", attributesConfiguration="
				+ attributesConfiguration + ", countries=" + countries + ", clientTypes=" + clientTypes + "]";
	}

}
