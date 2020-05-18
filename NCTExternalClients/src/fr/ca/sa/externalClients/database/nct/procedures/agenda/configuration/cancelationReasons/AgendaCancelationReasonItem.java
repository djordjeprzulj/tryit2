package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.cancelationReasons;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda Cancellation single option
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaCancelationReasonItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer cancelReasonId;

	private String cancelReasonName;

	/**
	 * default constructor for Agenda Cancelation Reason Item
	 */
	public AgendaCancelationReasonItem() {
		super();
	}

	/**
	 * Agenda Cancelation Reason Item
	 * 
	 * @param cancelReasonId
	 * 				Cancel reason ID
	 * 
	 * @param cancelReasonName
	 * 				Cancel reason name
	 */
	public AgendaCancelationReasonItem(Integer cancelReasonId, String cancelReasonName) {
		super();
		this.cancelReasonId = cancelReasonId;
		this.cancelReasonName = cancelReasonName;
	}

	public Integer getCancelReasonId() {
		return cancelReasonId;
	}

	public void setCancelReasonId(Integer cancelReasonId) {
		this.cancelReasonId = cancelReasonId;
	}

	public String getCancelReasonName() {
		return cancelReasonName;
	}

	public void setCancelReasonName(String cancelReasonName) {
		this.cancelReasonName = cancelReasonName;
	}

	@Override
	public String toString() {
		return "AgendaCancelationReasonItem [cancelReasonId=" + cancelReasonId + ", cancelReasonName="
				+ cancelReasonName + "]";
	}

}
