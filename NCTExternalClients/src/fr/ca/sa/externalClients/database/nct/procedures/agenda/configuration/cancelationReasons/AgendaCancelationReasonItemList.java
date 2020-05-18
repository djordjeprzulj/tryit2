package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.cancelationReasons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda cancellation option list
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaCancelationReasonItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<AgendaCancelationReasonItem> cancelReasonList;

	/**
	 * default constructor for Agenda Cancelation Reason Item List
	 */
	public AgendaCancelationReasonItemList() {
		super();
		this.cancelReasonList = new ArrayList<>();
	}

	/**
	 * Agenda Cancelation Reason Item List
	 * 
	 * @param cancelReasonList
	 * 				Cancel reason list
	 */
	public AgendaCancelationReasonItemList(List<AgendaCancelationReasonItem> cancelReasonList) {
		super();
		this.cancelReasonList = cancelReasonList;
	}

	public List<AgendaCancelationReasonItem> getCancelReasonList() {
		return cancelReasonList;
	}

	public void setCancelReasonList(List<AgendaCancelationReasonItem> cancelReasonList) {
		this.cancelReasonList = cancelReasonList;
	}

	@Override
	public String toString() {
		return "AgendaCancelationReasonItemList [cancelReasonList=" + cancelReasonList + "]";
	}

}
