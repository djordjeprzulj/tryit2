package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class TransApplicationCodeTableInsertRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String applicationNameL1;
	private String applicationNameL2;
	private boolean active;

	/**
	 * default constructor for Transaction Application CodeTable Insert Request
	 */
	public TransApplicationCodeTableInsertRequest() {
		super();
	}

	/**
	 * Transaction Application CodeTable Insert Request
	 * 
	 * @param applicationNameL1
	 * 				Application name in first language
	 * 
	 * @param applicationNameL2
	 * 				Application name in second language
	 * 
	 * @param active
	 * 				If it's active
	 */
	public TransApplicationCodeTableInsertRequest(String applicationNameL1, String applicationNameL2,
			boolean active) {
		super();
		this.applicationNameL1 = applicationNameL1;
		this.applicationNameL2 = applicationNameL2;
		this.active = active;
	}

	public String getApplicationNameL1() {
		return applicationNameL1;
	}

	public void setApplicationNameL1(String applicationNameL1) {
		this.applicationNameL1 = applicationNameL1;
	}

	public String getApplicationNameL2() {
		return applicationNameL2;
	}

	public void setApplicationNameL2(String applicationNameL2) {
		this.applicationNameL2 = applicationNameL2;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "TransApplicationCodeTableInsertRequest [applicationNameL1=" + applicationNameL1 + ", applicationNameL2="
				+ applicationNameL2 + ", active=" + active + "]";
	}

}
