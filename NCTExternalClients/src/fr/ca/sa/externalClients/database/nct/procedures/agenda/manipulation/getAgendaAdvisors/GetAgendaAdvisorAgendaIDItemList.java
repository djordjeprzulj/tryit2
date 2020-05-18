package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaAdvisors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Get agenda advisors list
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetAgendaAdvisorAgendaIDItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetAgendaAdvisorAgendaIDItem> advisorAgendaList;

	/**
	 * default constructor for Get Agenda Advisor Agenda ID Item List
	 */
	public GetAgendaAdvisorAgendaIDItemList() {
		super();
		this.advisorAgendaList = new ArrayList<>();
	}

	/**
	 * Get Agenda Advisor Agenda ID Item List
	 * 
	 * @param advisorAgendaList
	 * 				Advisor agenda list
	 */
	public GetAgendaAdvisorAgendaIDItemList(List<GetAgendaAdvisorAgendaIDItem> advisorAgendaList) {
		super();
		this.advisorAgendaList = advisorAgendaList;
	}

	public List<GetAgendaAdvisorAgendaIDItem> getAdvisorAgendaList() {
		return advisorAgendaList;
	}

	public void setAdvisorAgendaList(List<GetAgendaAdvisorAgendaIDItem> advisorAgendaList) {
		this.advisorAgendaList = advisorAgendaList;
	}

	@Override
	public String toString() {
		return "GetAgendaAdvisorAgendaIDItemList [advisorAgendaList=" + advisorAgendaList + "]";
	}

}
