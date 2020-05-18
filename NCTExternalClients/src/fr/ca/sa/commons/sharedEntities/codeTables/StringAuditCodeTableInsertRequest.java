package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class StringAuditCodeTableInsertRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String paramValueL1;
	private String paramValueL2;
	private boolean active;

	/**
	 * default constructor for String AuditC odeTable Insert Request
	 */
	public StringAuditCodeTableInsertRequest() {
		super();
	}

	/**
	 * String AuditC odeTable Insert Request
	 * 
	 * @param paramValueL1
	 * 				Parameter value in first language
	 * 
	 * @param paramValueL2
	 * 				Parameter value in second language
	 * 
	 * @param active
	 * 				If it's active
	 */
	public StringAuditCodeTableInsertRequest(String paramValueL1, String paramValueL2, boolean active) {
		super();
		this.paramValueL1 = paramValueL1;
		this.paramValueL2 = paramValueL2;
		this.active = active;
	}

	public String getParamValueL1() {
		return paramValueL1;
	}

	public void setParamValueL1(String paramValueL1) {
		this.paramValueL1 = paramValueL1;
	}

	public String getParamValueL2() {
		return paramValueL2;
	}

	public void setParamValueL2(String paramValueL2) {
		this.paramValueL2 = paramValueL2;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "StringAuditCodeTableInsertRequest [paramValueL1=" + paramValueL1 + ", paramValueL2=" + paramValueL2
				+ ", active=" + active + "]";
	}

}
