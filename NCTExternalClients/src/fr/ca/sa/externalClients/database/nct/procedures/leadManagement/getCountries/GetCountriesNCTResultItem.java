package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.getCountries;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Wrapper for returning single item of country in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetCountriesNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int countryId;
	private String countryCode;
	private String countryISOCode2;
	private String countryISOCode3;
	private String countryPhoneCode;
	private String countryName;

	/**
	 * default constructor for Get Countries NCT Result Item
	 */
	public GetCountriesNCTResultItem() {
		super();
	}

	/**
	 * Get Countries NCT Result Item
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
	 * @param countryName
	 * 				Country name
	 */
	public GetCountriesNCTResultItem(int countryId, String countryCode, String countryISOCode2, String countryISOCode3,
			String countryPhoneCode, String countryName) {
		super();
		this.countryId = countryId;
		this.countryCode = countryCode;
		this.countryISOCode2 = countryISOCode2;
		this.countryISOCode3 = countryISOCode3;
		this.countryPhoneCode = countryPhoneCode;
		this.countryName = countryName;
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

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "GetCountriesNCTResultItem [countryId=" + countryId + ", countryCode=" + countryCode
				+ ", countryISOCode2=" + countryISOCode2 + ", countryISOCode3=" + countryISOCode3
				+ ", countryPhoneCode=" + countryPhoneCode + ", countryName=" + countryName + "]";
	}

}
