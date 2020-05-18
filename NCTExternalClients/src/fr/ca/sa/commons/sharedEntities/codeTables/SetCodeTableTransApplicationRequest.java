package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetCodeTableTransApplicationRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer applicationCode;
	private String applicationNameL1;
	private String applicationNameL2;
	private boolean active;

	/**
	 * default constructor for Set Code Table Trans Application Request
	 */
	public SetCodeTableTransApplicationRequest() {
		super();
	}

	/**
	 * Set Code Table Trans Application Request
	 * 
	 * @param applicationCode
	 * 				Application code
	 * 
	 * @param applicationNameL1
	 * 				Application name in first language
	 * 
	 * @param applicationNameL2
	 * 				Application name in second language 
	 * 
	 * @param active
	 * 				Activity
	 */
	public SetCodeTableTransApplicationRequest(Integer applicationCode, String applicationNameL1,
			String applicationNameL2, boolean active) {
		super();
		this.applicationCode = applicationCode;
		this.applicationNameL1 = applicationNameL1;
		this.applicationNameL2 = applicationNameL2;
		this.active = active;
	}

	/**
	 * Set Code Table Trans Application Request
	 * 
	 * @param update
	 * 				Update request
	 * 
	 */
	public SetCodeTableTransApplicationRequest(TransApplicationCodeTableUpdateRequest update) {
		super();
		this.applicationCode = update.getApplicationCode();
		this.applicationNameL1 = update.getApplicationNameL1();
		this.applicationNameL2 = update.getApplicationNameL2();
		this.active = update.isActive();
	}

	/**
	 * Set Code Table Trans Application Request
	 * 
	 * @param insert
	 * 				Insert request
	 */
	public SetCodeTableTransApplicationRequest(TransApplicationCodeTableInsertRequest insert) {
		super();
		this.applicationCode = null;
		this.applicationNameL1 = insert.getApplicationNameL1();
		this.applicationNameL2 = insert.getApplicationNameL2();
		this.active = insert.isActive();
	}

	public Integer getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(Integer applicationCode) {
		this.applicationCode = applicationCode;
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

	public void setActive(boolean isActive) {
		this.active = isActive;
	}

	@Override
	public String toString() {
		return "SetCodeTableTransApplicationRequest [applicationCode=" + applicationCode + ", applicationNameL1="
				+ applicationNameL1 + ", applicationNameL2=" + applicationNameL2 + ", active=" + active + "]";
	}

}
