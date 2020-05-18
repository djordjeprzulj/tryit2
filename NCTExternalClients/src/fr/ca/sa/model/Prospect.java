package fr.ca.sa.model;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

public class Prospect implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer id;	
	private String code;
	private String companyName;
	private String firstName;
	private String lastName;

	private IdName type = new IdName();	
	
	private IdName segment = new IdName();
	private IdName portfolio = new IdName();
	
	private Entity entity = new Entity();

	private Integer civilityId;
	private Integer maritalStatusId;
	private Integer childrenNumber;
	private Integer cspId;
	private Integer activitySectorId;
	private Integer favoriteChannelId;
	private String birthDate;
	private String birthPlace;
	private String nationality;
	private String address;
	private String additionalAddress;
	private String postCode;
	
	private String city;
	private Integer countryId;
	private Integer originId;
	
	private String emailAddress;
	private String comment;

	private Integer statusId;
	private Integer clientCodeTypeId;
	
	private PhoneInfo professional = new PhoneInfo();
	private PhoneInfo personal = new PhoneInfo();
	private PhoneInfo mobile = new PhoneInfo();
	
	private int entryOrigin;
	
	public Prospect() {
		
	}
			
	public Prospect(Integer id, String code, IdName type, IdName segment, IdName portfolio,
			Entity entity, String companyName, String firstName, String lastName, Integer civilityId,
			Integer maritalStatusId, Integer childrenNumber, Integer cspId, Integer activitySectorId,
			Integer favoriteChannelId, String birthDate, String birthPlace, String nationality, String address,
			String additionalAddress, String postCode, String city, Integer countryId, Integer originId,
			String emailAddress, String comment, Integer statusId, Integer clientCodeTypeId, PhoneInfo professional,
			PhoneInfo personal, PhoneInfo mobile) {
		super();
		this.id = id;
		this.code = code;
		this.type = type;
		this.segment = segment;
		this.portfolio = portfolio;
		this.entity = entity;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.civilityId = civilityId;
		this.maritalStatusId = maritalStatusId;
		this.childrenNumber = childrenNumber;
		this.cspId = cspId;
		this.activitySectorId = activitySectorId;
		this.favoriteChannelId = favoriteChannelId;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.nationality = nationality;
		this.address = address;
		this.additionalAddress = additionalAddress;
		this.postCode = postCode;
		this.city = city;
		this.countryId = countryId;
		this.originId = originId;
		this.emailAddress = emailAddress;
		this.comment = comment;
		this.statusId = statusId;
		this.clientCodeTypeId = clientCodeTypeId;
		this.professional = professional;
		this.personal = personal;
		this.mobile = mobile;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public IdName getType() {
		return type;
	}

	public void setType(IdName type) {
		this.type = type;
	}

	public PhoneInfo getProfessional() {
		return professional;
	}

	public void setProfessional(PhoneInfo professional) {
		this.professional = professional;
	}

	public PhoneInfo getMobile() {
		return mobile;
	}

	public void setMobile(PhoneInfo mobile) {
		this.mobile = mobile;
	}

	public PhoneInfo getPersonal() {
		return personal;
	}

	public void setPersonal(PhoneInfo personal) {
		this.personal = personal;
	}

	public IdName getSegment() {
		return segment;
	}

	public void setSegment(IdName segment) {
		this.segment = segment;
	}

	public IdName getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(IdName portfolio) {
		this.portfolio = portfolio;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public Integer getCivilityId() {
		return civilityId;
	}

	public void setCivilityId(Integer civilityId) {
		this.civilityId = civilityId;
	}

	public Integer getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Integer maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public Integer getChildrenNumber() {
		return childrenNumber;
	}

	public void setChildrenNumber(Integer childrenNumber) {
		this.childrenNumber = childrenNumber;
	}

	public Integer getCspId() {
		return cspId;
	}

	public void setCspId(Integer cspId) {
		this.cspId = cspId;
	}

	public Integer getActivitySectorId() {
		return activitySectorId;
	}

	public void setActivitySectorId(Integer activitySectorId) {
		this.activitySectorId = activitySectorId;
	}

	public Integer getFavoriteChannelId() {
		return favoriteChannelId;
	}

	public void setFavoriteChannelId(Integer favoriteChannelId) {
		this.favoriteChannelId = favoriteChannelId;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdditionalAddress() {
		return additionalAddress;
	}

	public void setAdditionalAddress(String additionalAddress) {
		this.additionalAddress = additionalAddress;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getOriginId() {
		return originId;
	}

	public void setOriginId(Integer originId) {
		this.originId = originId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getClientCodeTypeId() {
		return clientCodeTypeId;
	}

	public void setClientCodeTypeId(Integer clientCodeTypeId) {
		this.clientCodeTypeId = clientCodeTypeId;
	}

	public int getEntryOrigin() {
		return entryOrigin;
	}

	public void setEntryOrigin(int entryOrigin) {
		this.entryOrigin = entryOrigin;
	}

	@Override
	public String toString() {
		return "Prospect [id=" + id + ", code=" + code + ", type=" + type + ", segment=" + segment + ", portfolio="
				+ portfolio + ", entity=" + entity + ", companyName=" + companyName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", civilityId=" + civilityId + ", maritalStatusId=" + maritalStatusId
				+ ", childrenNumber=" + childrenNumber + ", cspId=" + cspId + ", activitySectorId=" + activitySectorId
				+ ", favoriteChannelId=" + favoriteChannelId + ", birthDate=" + birthDate + ", birthPlace=" + birthPlace
				+ ", nationality=" + nationality + ", address=" + address + ", additionalAddress=" + additionalAddress
				+ ", postCode=" + postCode + ", city=" + city + ", countryId=" + countryId + ", originId=" + originId
				+ ", emailAddress=" + emailAddress + ", comment=" + comment + ", statusId=" + statusId
				+ ", clientCodeTypeId=" + clientCodeTypeId + ", professional=" + professional + ", personal=" + personal
				+ ", mobile=" + mobile + "]";
	}

	
}
