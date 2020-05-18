package fr.ca.sa.externalClients.database.nctAgendaAPI.procedures.getAgendaElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Jelena Raca
 *
 */
public class GetAgendaElementResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetAgendaElementResultItem> agendaElementList;

	/**
	 * default constructor for Get Agenda Element Result List
	 */
	public GetAgendaElementResultList() {
		super();
		this.agendaElementList = new ArrayList<GetAgendaElementResultItem>();
	}

	/**
	 * Get Agenda Element Result List
	 * 
	 * @param agendaElementList
	 * 				Agenda element list
	 */
	public GetAgendaElementResultList(List<GetAgendaElementResultItem> agendaElementList) {
		super();
		this.agendaElementList = agendaElementList;
	}

	public List<GetAgendaElementResultItem> getAgendaElementList() {
		return agendaElementList;
	}

	public void setAgendaElementList(List<GetAgendaElementResultItem> agendaElementList) {
		this.agendaElementList = agendaElementList;
	}

	@Override
	public String toString() {
		return "GetAgendaElementResultList [agendaElementList=" + agendaElementList + "]";
	}

}
