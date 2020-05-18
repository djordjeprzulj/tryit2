package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetCodeTableStringAuditRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer stringId;
	private String paramValueL1;
	private String paramValueL2;
	private boolean active;

	/**
	 * default constructor for Set Code Table String Audit Request
	 */
	public SetCodeTableStringAuditRequest() {
		super();
	}

	/**
	 * Set Code Table String Audit Request
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
	 * 				Activity
	 */
	public SetCodeTableStringAuditRequest(Integer stringId, String paramValueL1, String paramValueL2,
			boolean active) {
		super();
		this.stringId = stringId;
		this.paramValueL1 = paramValueL1;
		this.paramValueL2 = paramValueL2;
		this.active = active;
	}

	/**
	 * Set Code Table String Audit Request
	 * 
	 * @param update
	 * 				Update request
	 */
	public SetCodeTableStringAuditRequest(StringAuditCodeTableUpdateRequest update) {
		super();
		this.stringId = update.getStringId();
		this.paramValueL1 = update.getParamValueL1();
		this.paramValueL2 = update.getParamValueL2();
		this.active = update.isActive();
	}

	/**
	 * Set Code Table String Audit Request
	 * 
	 * @param insert
	 * 				Insert request
	 */
	public SetCodeTableStringAuditRequest(StringAuditCodeTableInsertRequest insert) {
		super();
		this.stringId = null;
		this.paramValueL1 = insert.getParamValueL1();
		this.paramValueL2 = insert.getParamValueL2();
		this.active = insert.isActive();
	}

	public Integer getStringId() {
		return stringId;
	}

	public void setStringId(Integer stringId) {
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
		return "SetCodeTableStringAuditRequest [stringId=" + stringId + ", paramValueL1=" + paramValueL1
				+ ", paramValueL2=" + paramValueL2 + ", active=" + active + "]";
	}

}
