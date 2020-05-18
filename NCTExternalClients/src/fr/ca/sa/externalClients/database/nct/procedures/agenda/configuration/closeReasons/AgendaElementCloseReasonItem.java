package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.closeReasons;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda closure reason single option
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaElementCloseReasonItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int closeReasonId;

	private String closeReasonName;

	/**
	 * default constructor for Agenda Element Close Reason Item
	 */
	public AgendaElementCloseReasonItem() {
		super();
	}

	/**
	 * Agenda Element Close Reason Item
	 * 
	 * @param closeReasonId
	 * 				Close reason ID
	 * 
	 * @param closeReasonName
	 * 				Close reason name
	 */
	public AgendaElementCloseReasonItem(int closeReasonId, String closeReasonName) {
		super();
		this.closeReasonId = closeReasonId;
		this.closeReasonName = closeReasonName;
	}

	public int getCloseReasonId() {
		return closeReasonId;
	}

	public void setCloseReasonId(int closeReasonId) {
		this.closeReasonId = closeReasonId;
	}

	public String getCloseReasonName() {
		return closeReasonName;
	}

	public void setCloseReasonName(String closeReasonName) {
		this.closeReasonName = closeReasonName;
	}

	@Override
	public String toString() {
		return "AgendaElementCloseReasonItem [closeReasonId=" + closeReasonId + ", closeReasonName=" + closeReasonName
				+ "]";
	}

}
