package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.origin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda origin option list
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaElementOriginItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<AgendaElementOriginItem> originList = new ArrayList<>();

	/**
	 * default constructor for Agenda Element Origin Item List
	 */
	public AgendaElementOriginItemList() {
		super();
	}

	/**
	 * Agenda Element Origin Item List
	 * 
	 * @param originList
	 * 				Origin list
	 */
	public AgendaElementOriginItemList(List<AgendaElementOriginItem> originList) {
		super();
		this.originList = originList;
	}

	public List<AgendaElementOriginItem> getOriginList() {
		return originList;
	}

	public void setOriginList(List<AgendaElementOriginItem> originList) {
		this.originList = originList;
	}

	@Override
	public String toString() {
		return "AgendaOriginItemList [originList=" + originList + "]";
	}

}
