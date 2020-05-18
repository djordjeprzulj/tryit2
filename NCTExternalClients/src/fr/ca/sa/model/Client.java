package fr.ca.sa.model;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.PermissionInterface;

public class Client implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer id;
	private String code;
	private String name;
	private String firstName;
	private String lastName;
	
	private IdName type;
	
	private String segment;
	private Integer portfolioId;
	
	private Entity entity;
	
	private String clientOrLead;
	private String email;
	private String mobilePhone;
	
	private Integer advisorId;
	private String cityName;
	private Long idExt;

	private String birthDate;
	private int numberOfYears;
	
	private String accountNumber;
	
	private Boolean active;
	private Boolean receiveSalaryInBank;
	private Boolean marked;
	
	private String dateOfLastContact;
	private Integer contactPriority;
	private Collaborator lastContactCollaborator;
	
	private PermissionInterface permissions;
	
	public Client() {
		super();
	}
	
	public Client(Integer id, Entity entity, String clientOrLead) {
		super();
		this.id = id;
		this.entity = entity;		
		this.clientOrLead = clientOrLead;
	}
	
	public Client(Integer id, String name, Entity entity, Integer portfolioId, String clientorLead) {
		this(id, entity, clientorLead);
		this.name = name;
		this.portfolioId = portfolioId;
	}

	public Client(Integer id, String firstName, String lastName, Entity entity, Integer portfolioId,
			String clientOrLead, String email, String mobilePhone) {
		this(id, entity, clientOrLead);
		this.portfolioId = portfolioId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobilePhone = mobilePhone;
	}

	public Client(Integer id, String code, IdName type, String clientOrLead, String firstName, String lastName, 
			Integer advisorId, Entity entity) {
		this(id, entity, clientOrLead);
		this.code = code;
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.advisorId = advisorId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Entity getEntity() {
		return entity;
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	public Integer getPortfolioId() {
		return portfolioId;
	}
	
	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}
	
	public String getClientOrLead() {
		return clientOrLead;
	}

	public void setClientOrLead(String clientOrLead) {
		this.clientOrLead = clientOrLead;
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

	public Integer getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Integer advisorId) {
		this.advisorId = advisorId;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getCityName() {
		return this.cityName;
	}
	
	public Long getIdExt() {
		return idExt;
	}

	public void setIdExt(Long idExt) {
		this.idExt = idExt;
	}
	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getReceiveSalaryInBank() {
		return receiveSalaryInBank;
	}

	public void setReceiveSalaryInBank(Boolean receiveSalaryInBank) {
		this.receiveSalaryInBank = receiveSalaryInBank;
	}

	public Boolean getMarked() {
		return marked;
	}

	public void setMarked(Boolean marked) {
		this.marked = marked;
	}

	public String getDateOfLastContact() {
		return dateOfLastContact;
	}

	public void setDateOfLastContact(String dateOfLastContact) {
		this.dateOfLastContact = dateOfLastContact;
	}

	public Integer getContactPriority() {
		return contactPriority;
	}

	public void setContactPriority(Integer contactPriority) {
		this.contactPriority = contactPriority;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}
	
	public Collaborator getLastContactCollaborator() {
		return lastContactCollaborator;
	}

	public void setLastContactCollaborator(Collaborator lastContactCollaborator) {
		this.lastContactCollaborator = lastContactCollaborator;
	}
	
	public PermissionInterface getPermissions() {
		return permissions;
	}

	public void setPermissions(PermissionInterface permissions) {
		this.permissions = permissions;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getNumberOfYears() {
		return numberOfYears;
	}

	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Override
	public String toString() {
		return "Client [Id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", name=" + name 
				+ ", entity=" + entity + ", portfolioId=" + portfolioId + ", code=" + code + ", type=" + type + ", advisorId=" + advisorId
				+ ", clientOrLead=" + clientOrLead + ", email=" + email + ", mobilePhone=" + mobilePhone 
				+ "]";
	}
}
