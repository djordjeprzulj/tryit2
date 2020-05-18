package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.closeReasons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda closure reason item list
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaElementCloseReasonItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<AgendaElementCloseReasonItem> closeReasonList;

	/**
	 * default constructor for Agenda Element Close Reason Item List
	 */
	public AgendaElementCloseReasonItemList() {
		super();
		this.closeReasonList = new ArrayList<>();
	}

	/**
	 * Agenda Element Close Reason Item List
	 * 
	 * @param closeReasonList
	 * 				Close reason list
	 */
	public AgendaElementCloseReasonItemList(List<AgendaElementCloseReasonItem> closeReasonList) {
		super();
		this.closeReasonList = closeReasonList;
	}

	public List<AgendaElementCloseReasonItem> getCloseReasonList() {
		return closeReasonList;
	}

	public void setCloseReasonList(List<AgendaElementCloseReasonItem> closeReasonList) {
		this.closeReasonList = closeReasonList;
	}

	@Override
	public String toString() {
		return "AgendaCloseReasonItemList [closeReasonList=" + closeReasonList + "]";
	}

}
