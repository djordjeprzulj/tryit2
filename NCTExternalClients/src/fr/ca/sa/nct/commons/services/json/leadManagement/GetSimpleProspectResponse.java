package fr.ca.sa.nct.commons.services.json.leadManagement;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetSimpleProspectResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int prospectId;
	private String firstName;
	private String lastName;
	private String companyName;

	/**
	 * default constructor for Get Simple Prospect Response
	 */
	public GetSimpleProspectResponse() {
		super();
	}

	/**
	 * Get Simple Prospect Response
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 * 
	 * @param firstName
	 * 				First name
	 * 
	 * @param lastName
	 * 				Last name
	 * 
	 * @param companyName
	 * 				Company name
	 */
	public GetSimpleProspectResponse(int prospectId, String firstName, String lastName, String companyName) {
		super();
		this.prospectId = prospectId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
	}

	public int getProspectId() {
		return prospectId;
	}

	public void setProspectId(int prospectId) {
		this.prospectId = prospectId;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
