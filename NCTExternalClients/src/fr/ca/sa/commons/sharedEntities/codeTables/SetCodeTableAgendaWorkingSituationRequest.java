package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Milos Topalovic
 *
 */
public class SetCodeTableAgendaWorkingSituationRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer elementObjectTypeCode;
	private String nameL1;
	private String nameL2;
	private boolean active;

	public SetCodeTableAgendaWorkingSituationRequest() {
		super();
	}

	public SetCodeTableAgendaWorkingSituationRequest(Integer elementObjectTypeCode, String nameL1, String nameL2,
			boolean active) {
		super();
		this.elementObjectTypeCode = elementObjectTypeCode;
		this.nameL1 = nameL1;
		this.nameL2 = nameL2;
		this.active = active;
	}

	public Integer getElementObjectTypeCode() {
		return elementObjectTypeCode;
	}

	public void setElementObjectTypeCode(Integer elementObjectTypeCode) {
		this.elementObjectTypeCode = elementObjectTypeCode;
	}

	public String getNameL1() {
		return nameL1;
	}

	public void setNameL1(String nameL1) {
		this.nameL1 = nameL1;
	}

	public String getNameL2() {
		return nameL2;
	}

	public void setNameL2(String nameL2) {
		this.nameL2 = nameL2;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "SetCodeTableAgendaWorkingSituation [elementObjectTypeCode=" + elementObjectTypeCode + ", nameL1="
				+ nameL1 + ", nameL2=" + nameL2 + ", isActive=" + active + "]";
	}

}
