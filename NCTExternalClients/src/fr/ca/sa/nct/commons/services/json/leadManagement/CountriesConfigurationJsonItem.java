package fr.ca.sa.nct.commons.services.json.leadManagement;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response JSON wrapper for lead country configuration
 * 
 * @author Nemanja Ignjatov
 *
 */
public class CountriesConfigurationJsonItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int countryId;
	private String countryCode;
	private String countryISOCode2;
	private String countryISOCode3;
	private String countryPhoneCode;
	private HashMap<String, String> names;

	/**
	 * default constructor for Countries Configuration Json Item
	 */
	public CountriesConfigurationJsonItem() {
		super();
		this.names = new HashMap<String, String>();
	}

	/**
	 * Countries Configuration Json Item
	 * 
	 * @param countryId
	 * 				Country ID
	 * 
	 * @param countryCode
	 * 				Country code
	 * 
	 * @param countryISOCode2
	 * 				Country ISO code 2
	 * 
	 * @param countryISOCode3
	 * 				Country ISO code 3
	 * 
	 * @param countryPhoneCode
	 * 				Country phone code
	 * 
	 * @param language
	 * 				Language
	 * 
	 * @param name
	 * 				Name
	 */
	public CountriesConfigurationJsonItem(int countryId, String countryCode, String countryISOCode2,
			String countryISOCode3, String countryPhoneCode, String language, String name) {
		super();

		this.names = new HashMap<String, String>();

		this.countryId = countryId;
		this.countryCode = countryCode;
		this.countryISOCode2 = countryISOCode2;
		this.countryISOCode3 = countryISOCode3;
		this.countryPhoneCode = countryPhoneCode;
		this.names.put(language, name);
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryISOCode2() {
		return countryISOCode2;
	}

	public void setCountryISOCode2(String countryISOCode2) {
		this.countryISOCode2 = countryISOCode2;
	}

	public String getCountryISOCode3() {
		return countryISOCode3;
	}

	public void setCountryISOCode3(String countryISOCode3) {
		this.countryISOCode3 = countryISOCode3;
	}

	public String getCountryPhoneCode() {
		return countryPhoneCode;
	}

	public void setCountryPhoneCode(String countryPhoneCode) {
		this.countryPhoneCode = countryPhoneCode;
	}

	public Map<String, String> getNames() {
		return names;
	}

	@Override
	public String toString() {
		return "CountriesConfigurationJsonItem [countryId=" + countryId + ", countryCode=" + countryCode
				+ ", countryISOCode2=" + countryISOCode2 + ", countryISOCode3=" + countryISOCode3
				+ ", countryPhoneCode=" + countryPhoneCode + ", names=" + names + "]";
	}

}
