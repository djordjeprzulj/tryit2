package fr.ca.sa.nct.commons.services.json.agenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.json.Target;
import fr.ca.sa.nct.commons.authorizationUtils.json.TargetAction;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaReassignRequest implements Target, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer agendaElementId;

	private Integer advisorEntityId;

	private Integer advisorId;

	private Integer currentAdvisorId;

	private Integer currentAdvisorEntityId;

	private Integer langId;

	private String startTime;

	private String endTime;

	/**
	 * default constructor for Agenda Reassign Request
	 */
	public AgendaReassignRequest() {
		super();
	}

	/**
	 * Agenda Reassign Request
	 * 
	 * @param agendaElementId
	 * 				Agenda element ID
	 * 
	 * @param advisorEntityId
	 * 				Advisor entity ID
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 * 
	 * @param currentAdvisorId
	 * 				Current advisor ID
	 * 
	 * @param currentAdvisorEntityId
	 * 				Current advisor entity ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public AgendaReassignRequest(Integer agendaElementId, Integer advisorEntityId, Integer advisorId,
			Integer currentAdvisorId, Integer currentAdvisorEntityId, Integer langId, String startTime, String endTime) {
		super();
		this.agendaElementId = agendaElementId;
		this.advisorEntityId = advisorEntityId;
		this.advisorId = advisorId;
		this.currentAdvisorId = currentAdvisorId;
		this.currentAdvisorEntityId = currentAdvisorEntityId;
		this.langId = langId;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Integer getAgendaElementId() {
		return agendaElementId;
	}

	public void setAgendaElementId(Integer agendaElementId) {
		this.agendaElementId = agendaElementId;
	}

	public Integer getAdvisorEntityId() {
		return advisorEntityId;
	}

	public void setAdvisorEntityId(Integer advisorEntityId) {
		this.advisorEntityId = advisorEntityId;
	}

	public Integer getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Integer advisorId) {
		this.advisorId = advisorId;
	}

	public Integer getCurrentAdvisorId() {
		return currentAdvisorId;
	}

	public void setCurrentAdvisorId(Integer currentAdvisorId) {
		this.currentAdvisorId = currentAdvisorId;
	}

	public Integer getCurrentAdvisorEntityId() {
		return currentAdvisorEntityId;
	}

	public void setCurrentAdvisorEntityId(Integer currentAdvisorEntityId) {
		this.currentAdvisorEntityId = currentAdvisorEntityId;
	}

	public Integer getLangId() {
		return langId;
	}

	public void setLangId(Integer langId) {
		this.langId = langId;
	}

	@Override
	public List<TargetAction> getTargetActionObjects() {
		TargetAction taC = new TargetAction(currentAdvisorEntityId, currentAdvisorId);
		ArrayList<TargetAction> taList = new ArrayList<>();
		taList.add(taC);
		return taList;
	}

	@Override
	public void defineTargetActionObjects() {
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
