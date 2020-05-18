package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.advisors;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 *
 * Wrapper class for single result in result set from spGetBankAdvisors store
 * procedure
 * 
 * @author Nemanja Ignjatov
 */
public class GetAdvisorsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int userId;
	private String lastName;
	private String firstName;
	private String fullName;
	private String entityCode;
	private Integer entityId;
	private Boolean hasAgenda;
	private String function;
	/**
	 * default constructor for Get Advisors NCT Result Item
	 */
	public GetAdvisorsNCTResultItem() {
		super();
	}

	/**
	 * Get Advisors NCT Result Item
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param lastName
	 * 				Last name
	 * 
	 * @param firstName
	 * 				First name
	 * 
	 * @param entityCode
	 * 				Entity code
	 * 
	 * @param entityId
	 * 				Entity ID
	 */
	public GetAdvisorsNCTResultItem(int userId, String lastName, String firstName, String entityCode,
			Integer entityId,String function) {
		super();
		this.userId = userId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.fullName = firstName + " " + lastName;
		this.entityCode = entityCode;
		this.entityId = entityId;
		this.hasAgenda = false;
		this.function=function;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	public Boolean getHasAgenda() {
		return hasAgenda;
	}

	public void setHasAgenda(Boolean hasAgenda) {
		this.hasAgenda = hasAgenda;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "GetAdvisorsNCTResultItem [userId=" + userId + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", fullName=" + fullName + ", entityCode=" + entityCode + ", entityId=" + entityId + ", hasAgenda="
				+ hasAgenda + ", function=" + function + "]";
	}

}
