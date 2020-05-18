package fr.ca.sa.externalClients.database.nct.procedures.reports.getExcelTestData;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetExcelTestDataItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int transactId;
	private int traTransactCode;
	private int collaboratorIdSession;
	private int cliProsId;
	private String startSessionDate;
	private String endSessionDate;
	private int clientId;
	private int clientIdCore;
	private String civility;
	private String cl;
	private String typeOfClient;
	private int isIndividual;
	private String clientCode;
	private String name;
	private String surname;
	private String companyOfficerName;
	private String companyOfficerSurname;
	private String birthDate;
	private String email;
	private String address;
	private String postCode;
	private String cityName;
	private String mobilePhone;
	private String dateOfLastContact;
	private String lastContactAdvisorName;
	private String segment;
	private int portfolioId;
	private int advisorId;
	private int entityId;
	private String entityName;
	private int notInterested;
	private int changeProspects;

	/**
	 * default constructor for Get Excel Test Data Item
	 */
	public GetExcelTestDataItem() {
		super();
	}

	/**
	 * Get Excel Test Data Item
	 * 
	 * @param transactId
	 * 				Transaction ID
	 * 
	 * @param traTransactCode
	 * 				Transaction code
	 * 
	 * @param collaboratorIdSession
	 * 				Collaborator ID session
	 * 
	 * @param cliProsId
	 * 				Client/prospect ID
	 * 
	 * @param startSessionDate
	 * 				Start session date
	 * 
	 * @param endSessionDate
	 * 				End session date
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param clientIdCore
	 * 				Client ID core
	 * 
	 * @param civility
	 * 				Civility
	 * 
	 * @param cl
	 * 				Client
	 * 
	 * @param typeOfClient
	 * 				Type of client
	 * 
	 * @param isIndividual
	 * 				Individuality
	 * 
	 * @param clientCode
	 * 				Client code
	 * 
	 * @param name
	 * 				Name
	 * 
	 * @param surname
	 * 				Surname
	 * 
	 * @param companyOfficerName
	 * 				Company officer name
	 * 
	 * @param companyOfficerSurname
	 * 				Company officer surname
	 * 
	 * @param birthDate
	 * 				Birth date
	 * 
	 * @param email
	 * 				Email
	 * 
	 * @param address
	 * 				Address
	 * 
	 * @param postCode
	 * 				Post code
	 * 
	 * @param cityName
	 * 				City name
	 * 
	 * @param mobilePhone
	 * 				Mobile phone
	 * 
	 * @param dateOfLastContact
	 * 				Date of last contact
	 * 
	 * @param lastContactAdvisorName
	 * 				Last contact advisor name
	 * 
	 * @param segment
	 * 				Segment
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 * 
	 * @param entityId
	 * 				Entity ID
	 * 
	 * @param entityName
	 * 				Entity name
	 * 
	 * @param notInterested
	 * 				Not interested
	 * 
	 * @param changeProspects
	 * 				Change prospects
	 */
	public GetExcelTestDataItem(int transactId, int traTransactCode, int collaboratorIdSession, int cliProsId,
			String startSessionDate, String endSessionDate, int clientId, int clientIdCore, String civility, String cl,
			String typeOfClient, int isIndividual, String clientCode, String name, String surname,
			String companyOfficerName, String companyOfficerSurname, String birthDate, String email, String address,
			String postCode, String cityName, String mobilePhone, String dateOfLastContact,
			String lastContactAdvisorName, String segment, int portfolioId, int advisorId, int entityId,
			String entityName, int notInterested, int changeProspects) {
		super();
		this.transactId = transactId;
		this.traTransactCode = traTransactCode;
		this.collaboratorIdSession = collaboratorIdSession;
		this.cliProsId = cliProsId;
		this.startSessionDate = startSessionDate;
		this.endSessionDate = endSessionDate;
		this.clientId = clientId;
		this.clientIdCore = clientIdCore;
		this.civility = civility;
		this.cl = cl;
		this.typeOfClient = typeOfClient;
		this.isIndividual = isIndividual;
		this.clientCode = clientCode;
		this.name = name;
		this.surname = surname;
		this.companyOfficerName = companyOfficerName;
		this.companyOfficerSurname = companyOfficerSurname;
		this.birthDate = birthDate;
		this.email = email;
		this.address = address;
		this.postCode = postCode;
		this.cityName = cityName;
		this.mobilePhone = mobilePhone;
		this.dateOfLastContact = dateOfLastContact;
		this.lastContactAdvisorName = lastContactAdvisorName;
		this.segment = segment;
		this.portfolioId = portfolioId;
		this.advisorId = advisorId;
		this.entityId = entityId;
		this.entityName = entityName;
		this.notInterested = notInterested;
		this.changeProspects = changeProspects;
	}

	public int getTransactId() {
		return transactId;
	}

	public void setTransactId(int transactId) {
		this.transactId = transactId;
	}

	public int getTraTransactCode() {
		return traTransactCode;
	}

	public void setTraTransactCode(int traTransactCode) {
		this.traTransactCode = traTransactCode;
	}

	public int getCollaboratorIdSession() {
		return collaboratorIdSession;
	}

	public void setCollaboratorIdSession(int collaboratorIdSession) {
		this.collaboratorIdSession = collaboratorIdSession;
	}

	public int getCliProsId() {
		return cliProsId;
	}

	public void setCliProsId(int cliProsId) {
		this.cliProsId = cliProsId;
	}

	public String getStartSessionDate() {
		return startSessionDate;
	}

	public void setStartSessionDate(String startSessionDate) {
		this.startSessionDate = startSessionDate;
	}

	public String getEndSessionDate() {
		return endSessionDate;
	}

	public void setEndSessionDate(String endSessionDate) {
		this.endSessionDate = endSessionDate;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getClientIdCore() {
		return clientIdCore;
	}

	public void setClientIdCore(int clientIdCore) {
		this.clientIdCore = clientIdCore;
	}

	public String getCivility() {
		return civility;
	}

	public void setCivility(String civility) {
		this.civility = civility;
	}

	public String getCl() {
		return cl;
	}

	public void setCl(String cl) {
		this.cl = cl;
	}

	public String getTypeOfClient() {
		return typeOfClient;
	}

	public void setTypeOfClient(String typeOfClient) {
		this.typeOfClient = typeOfClient;
	}

	public int getIsIndividual() {
		return isIndividual;
	}

	public void setIsIndividual(int isIndividual) {
		this.isIndividual = isIndividual;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCompanyOfficerName() {
		return companyOfficerName;
	}

	public void setCompanyOfficerName(String companyOfficerName) {
		this.companyOfficerName = companyOfficerName;
	}

	public String getCompanyOfficerSurname() {
		return companyOfficerSurname;
	}

	public void setCompanyOfficerSurname(String companyOfficerSurname) {
		this.companyOfficerSurname = companyOfficerSurname;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getDateOfLastContact() {
		return dateOfLastContact;
	}

	public void setDateOfLastContact(String dateOfLastContact) {
		this.dateOfLastContact = dateOfLastContact;
	}

	public String getLastContactAdvisorName() {
		return lastContactAdvisorName;
	}

	public void setLastContactAdvisorName(String lastContactAdvisorName) {
		this.lastContactAdvisorName = lastContactAdvisorName;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}

	public int getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(int advisorId) {
		this.advisorId = advisorId;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public int getNotInterested() {
		return notInterested;
	}

	public void setNotInterested(int notInterested) {
		this.notInterested = notInterested;
	}

	public int getChangeProspects() {
		return changeProspects;
	}

	public void setChangeProspects(int changeProspects) {
		this.changeProspects = changeProspects;
	}

	@Override
	public String toString() {
		return "GetExcelTestDataItem [transactId=" + transactId + ", traTransactCode=" + traTransactCode
				+ ", collaboratorIdSession=" + collaboratorIdSession + ", cliProsId=" + cliProsId
				+ ", startSessionDate=" + startSessionDate + ", endSessionDate=" + endSessionDate + ", clientId="
				+ clientId + ", clientIdCore=" + clientIdCore + "]";
	}

}
