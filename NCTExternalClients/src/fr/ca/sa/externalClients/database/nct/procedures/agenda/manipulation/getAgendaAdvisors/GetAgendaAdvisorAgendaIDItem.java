package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaAdvisors;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Get agenda advisors item
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetAgendaAdvisorAgendaIDItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer agendaId;

	private Integer advisorId;

	/**
	 * default constructor for Get Agenda Advisor Agenda ID Item
	 */
	public GetAgendaAdvisorAgendaIDItem() {
		super();
	}

	/**
	 * Get Agenda Advisor Agenda ID Item
	 * 
	 * @param agendaId
	 * 				Agenda ID
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 */
	public GetAgendaAdvisorAgendaIDItem(Integer agendaId, Integer advisorId) {
		super();
		this.agendaId = agendaId;
		this.advisorId = advisorId;
	}

	public Integer getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(Integer agendaId) {
		this.agendaId = agendaId;
	}

	public Integer getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Integer advisorId) {
		this.advisorId = advisorId;
	}

	@Override
	public String toString() {
		return "GetAgendaAdvisorAgendaIDItem [agendaId=" + agendaId + ", advisorId=" + advisorId + "]";
	}

}
