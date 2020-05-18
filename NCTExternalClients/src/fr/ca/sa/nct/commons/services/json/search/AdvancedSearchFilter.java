package fr.ca.sa.nct.commons.services.json.search;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Wrapper for receiving filters for advanced search
 * 
 * @author Nemanja Ignjatov
 *
 */

public class AdvancedSearchFilter implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private boolean withoutLeads;
	private Integer clientType;
	private Integer bank;
	private Integer region;
	private Integer mainBranch;
	private Integer branch;
	private Integer advisor;
	private String firstName;
	private String lastName;
	private String customerId;
	private String birthDate;
	private String accountNb;
	private String zipCode;
	private String city;
	private String country;
	private String mobilePhone;
	private Integer segment;
	private String lastContactDate;
	private String email;
	private Integer clientOrigin;
	private String address;
	private String clientCodeTypeId;
	private Long externalId;
	private String rcNumber;
	private String passport;

	/**
	 * default constructor for Advanced Search Filter
	 */
	public AdvancedSearchFilter() {
		super();
	}

	/**
	 * 
	 * @param withoutLeads
	 * @param clientType
	 * @param bank
	 * @param region
	 * @param mainBranch
	 * @param branch
	 * @param advisor
	 * @param firstName
	 * @param lastName
	 * @param customerId
	 * @param birthDate
	 * @param accountNb
	 * @param zipCode
	 * @param city
	 * @param country
	 * @param mobilePhone
	 * @param segment
	 * @param lastContactDate
	 * @param email
	 * @param clientOrigin
	 * @param address
	 * @param clientCodeTypeId
	 * @param externalId
	 * @param rcNumber
	 * @param passport
	 */
	public AdvancedSearchFilter(boolean withoutLeads, Integer clientType, Integer bank, Integer region,
			Integer mainBranch, Integer branch, Integer advisor, String firstName, String lastName, String customerId,
			String birthDate, String accountNb, String zipCode, String city, String country, String mobilePhone,
			Integer segment, String lastContactDate, String email, Integer clientOrigin, String address,
			String clientCodeTypeId, Long externalId, String rcNumber, String passport) {
		super();
		this.withoutLeads = withoutLeads;
		this.clientType = clientType;
		this.bank = bank;
		this.region = region;
		this.mainBranch = mainBranch;
		this.branch = branch;
		this.advisor = advisor;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerId = customerId;
		this.birthDate = birthDate;
		this.accountNb = accountNb;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.mobilePhone = mobilePhone;
		this.segment = segment;
		this.lastContactDate = lastContactDate;
		this.email = email;
		this.clientOrigin = clientOrigin;
		this.address = address;
		this.clientCodeTypeId = clientCodeTypeId;
		this.externalId = externalId;
		this.rcNumber = rcNumber;
		this.passport = passport;
	}

	public boolean isWithoutLeads() {
		return withoutLeads;
	}

	public Integer getClientType() {
		return clientType;
	}

	public Integer getBank() {
		return bank;
	}

	public Integer getRegion() {
		return region;
	}

	public Integer getMainBranch() {
		return mainBranch;
	}

	public Integer getBranch() {
		return branch;
	}

	public Integer getAdvisor() {
		return advisor;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public String getAccountNb() {
		return accountNb;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Integer getSegment() {
		return segment;
	}

	public String getLastContactDate() {
		return lastContactDate;
	}

	public String getEmail() {
		return email;
	}

	public Integer getClientOrigin() {
		return clientOrigin;
	}

	public String getAddress() {
		return address;
	}

	public String getClientCodeTypeId() {
		return clientCodeTypeId;
	}

	public Long getExternalId() {
		return externalId;
	}

	public String getRcNumber() {
		return rcNumber;
	}
	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

}
