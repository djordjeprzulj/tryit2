package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.checkProspectDuplicate;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Check prospect duplicates result
 * 
 * @author Sasa Radovanovic
 *
 */
public class CheckProspectDuplicatesResult implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer numberOfDuplicates;
	private Integer emailsDuplicates;
	private Integer clientCodeDuplicates;
	private Integer professionalPhoneDuplicates;
	private Integer personalPhoneDuplicates;
	private Integer mobilePhoneDuplicates;

	/**
	 * default constructor for Check Prospect Duplicates Result
	 */
	public CheckProspectDuplicatesResult() {
		super();
	}

	/**
	 * Check Prospect Duplicates Result
	 * 
	 * @param numberOfDuplicates
	 * 				Number of duplicates 
	 * 
	 * @param emailsDuplicates
	 * 				Email duplicates
	 * 
	 * @param clientCodeDuplicates
	 * 				Client code duplicates
	 * 
	 * @param professionalPhoneDuplicates
	 * 				Professional phone duplicates
	 * 
	 * @param personalPhoneDuplicates
	 * 				Personal phone duplicates
	 * 
	 * @param mobilePhoneDuplicates
	 * 				Mobile phone duplicates
	 */
	public CheckProspectDuplicatesResult(Integer numberOfDuplicates, Integer emailsDuplicates,
			Integer clientCodeDuplicates, Integer professionalPhoneDuplicates, Integer personalPhoneDuplicates,
			Integer mobilePhoneDuplicates) {
		super();
		this.numberOfDuplicates = numberOfDuplicates;
		this.emailsDuplicates = emailsDuplicates;
		this.clientCodeDuplicates = clientCodeDuplicates;
		this.professionalPhoneDuplicates = professionalPhoneDuplicates;
		this.personalPhoneDuplicates = personalPhoneDuplicates;
		this.mobilePhoneDuplicates = mobilePhoneDuplicates;
	}

	public Integer getNumberOfDuplicates() {
		return numberOfDuplicates;
	}

	public void setNumberOfDuplicates(Integer numberOfDuplicates) {
		this.numberOfDuplicates = numberOfDuplicates;
	}

	public Integer getEmailsDuplicates() {
		return emailsDuplicates;
	}

	public void setEmailsDuplicates(Integer emailsDuplicates) {
		this.emailsDuplicates = emailsDuplicates;
	}

	public Integer getClientCodeDuplicates() {
		return clientCodeDuplicates;
	}

	public void setClientCodeDuplicates(Integer clientCodeDuplicates) {
		this.clientCodeDuplicates = clientCodeDuplicates;
	}

	public Integer getProfessionalPhoneDuplicates() {
		return professionalPhoneDuplicates;
	}

	public void setProfessionalPhoneDuplicates(Integer professionalPhoneDuplicates) {
		this.professionalPhoneDuplicates = professionalPhoneDuplicates;
	}

	public Integer getPersonalPhoneDuplicates() {
		return personalPhoneDuplicates;
	}

	public void setPersonalPhoneDuplicates(Integer personalPhoneDuplicates) {
		this.personalPhoneDuplicates = personalPhoneDuplicates;
	}

	public Integer getMobilePhoneDuplicates() {
		return mobilePhoneDuplicates;
	}

	public void setMobilePhoneDuplicates(Integer mobilePhoneDuplicates) {
		this.mobilePhoneDuplicates = mobilePhoneDuplicates;
	}

	@Override
	public String toString() {
		return "CheckProspectDuplicatesResult [numberOfDuplicates=" + numberOfDuplicates + ", emailsDuplicates="
				+ emailsDuplicates + ", clientCodeDuplicates=" + clientCodeDuplicates + ", professionalPhoneDuplicates="
				+ professionalPhoneDuplicates + ", personalPhoneDuplicates=" + personalPhoneDuplicates
				+ ", mobilePhoneDuplicates=" + mobilePhoneDuplicates + "]";
	}

}
