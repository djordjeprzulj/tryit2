package fr.ca.sa.nct.commons.services.json.leadManagement;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class CheckProspectDuplicatesRequest implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer isIndividual;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String companyName;
	private String emailAddress;
	private String clientCode;
	private String profesionalPhone;
	private String personalPhone;
	private String mobilePhone;

	/**
	 * default constructor for Check Prospect Duplicates Request
	 */
	public CheckProspectDuplicatesRequest() {
		super();
	}

	/**
	 * Check Prospect Duplicates Request
	 * 
	 * @param isIndividual
	 * 				Is individual
	 * 
	 * @param firstName
	 * 				First name
	 * 
	 * @param lastName
	 * 				Last name
	 * 
	 * @param birthDate
	 * 				Birth date
	 * 
	 * @param companyName
	 * 				Company name
	 * 
	 * @param emailAddress
	 * 				Email address
	 * 
	 * @param clientCode
	 * 				Client code
	 * 
	 * @param profesionalPhone
	 * 				Professional phone
	 * 
	 * @param personalPhone
	 * 				Personal phone
	 * 
	 * @param mobilePhone
	 * 				Mobile phone
	 */
	public CheckProspectDuplicatesRequest(Integer isIndividual, String firstName, String lastName, String birthDate,
			String companyName, String emailAddress, String clientCode, String profesionalPhone, String personalPhone,
			String mobilePhone) {
		super();
		this.isIndividual = isIndividual;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.companyName = companyName;
		this.emailAddress = emailAddress;
		this.clientCode = clientCode;
		this.profesionalPhone = profesionalPhone;
		this.personalPhone = personalPhone;
		this.mobilePhone = mobilePhone;
	}

	public Integer getIsIndividual() {
		return isIndividual;
	}

	public void setIsIndividual(Integer isIndividual) {
		this.isIndividual = isIndividual;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getProfesionalPhone() {
		return profesionalPhone;
	}

	public void setProfesionalPhone(String profesionalPhone) {
		this.profesionalPhone = profesionalPhone;
	}

	public String getPersonalPhone() {
		return personalPhone;
	}

	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

}
