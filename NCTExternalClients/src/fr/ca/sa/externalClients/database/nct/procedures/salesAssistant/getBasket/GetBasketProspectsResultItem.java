package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketProspectsResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer clientId;

	private String firstName;

	private String lastName;

	/**
	 * Get Basket Prospects Result Item
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param firstName
	 * 				First name
	 * 
	 * @param lastName
	 * 				Last name
	 */
	public GetBasketProspectsResultItem(Integer clientId, String firstName, String lastName) {
		super();
		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * default constructor for Basket Prospects Result Item
	 */
	public GetBasketProspectsResultItem() {
		super();
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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

	@Override
	public String toString() {
		return "GetBasketProspectsResultItem [clientId=" + clientId + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

}
