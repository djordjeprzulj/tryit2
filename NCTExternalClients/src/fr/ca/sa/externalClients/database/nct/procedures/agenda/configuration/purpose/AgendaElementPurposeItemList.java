package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.purpose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda purpose option list
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaElementPurposeItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<AgendaElementPurposeItem> purposes;

	/**
	 * default constructor for Agenda Element Purpose Item List
	 */
	public AgendaElementPurposeItemList() {
		super();
		this.purposes = new ArrayList<>();
	}

	/**
	 * Agenda Element Purpose Item List
	 * 
	 * @param purposes
	 * 				Purposes
	 */
	public AgendaElementPurposeItemList(List<AgendaElementPurposeItem> purposes) {
		super();
		this.purposes = purposes;
	}

	public List<AgendaElementPurposeItem> getPurposes() {
		return purposes;
	}

	public void setPurposes(List<AgendaElementPurposeItem> purposes) {
		this.purposes = purposes;
	}

	@Override
	public String toString() {
		return "AgendaPurposeItemList [purposes=" + purposes + "]";
	}

}
