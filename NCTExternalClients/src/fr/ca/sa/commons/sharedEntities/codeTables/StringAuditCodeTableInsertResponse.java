package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class StringAuditCodeTableInsertResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int stringId;
	private String paramValueL1;
	private String paramValueL2;
	private boolean active;

	/**
	 * default constructor for String Audit CodeTable Insert Response
	 */
	public StringAuditCodeTableInsertResponse() {
		super();
	}

	/**
	 * String Audit CodeTable Insert Response
	 * 
	 * @param stringId
	 * 				String ID
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
	public StringAuditCodeTableInsertResponse(int stringId, String paramValueL1, String paramValueL2,
			boolean active) {
		super();
		this.stringId = stringId;
		this.paramValueL1 = paramValueL1;
		this.paramValueL2 = paramValueL2;
		this.active = active;
	}

	public int getStringId() {
		return stringId;
	}

	public void setStringId(int stringId) {
		this.stringId = stringId;
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
		return "StringAuditCodeTableInsertResponse [stringId=" + stringId + ", paramValueL1=" + paramValueL1
				+ ", paramValueL2=" + paramValueL2 + ", active=" + active + "]";
	}

}
