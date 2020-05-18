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
public class CancelAgendaRequest implements Target, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer agendaElementId;

	private Integer closeReasonId;

	private Integer cancelReasonId;

	private Integer advisorId;

	private Integer advisorEntityId;

	private String comment;

	private Integer clientId;

	private Integer agendaElementTypeId;

	private Integer langId;

	/**
	 * default constructor for Cancel Agenda Request
	 */
	public CancelAgendaRequest() {
		super();
	}

	/**
	 * Cancel Agenda Request
	 * 
	 * @param agendaElementId
	 * 				Agenda element ID
	 * 
	 * @param closeReasonId
	 * 				Close reason ID
	 * 
	 * @param cancelReasonId
	 * 				Cancel reason ID
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 * 
	 * @param advisorEntityid
	 * 				Advisor entity ID
	 * 
	 * @param comment
	 * 				Comment
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param agendaElementTypeId
	 * 				Agenda element type ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public CancelAgendaRequest(Integer agendaElementId, Integer closeReasonId, Integer cancelReasonId,
			Integer advisorId, Integer advisorEntityid, String comment, Integer clientId, Integer agendaElementTypeId,
			Integer langId) {
		super();
		this.agendaElementId = agendaElementId;
		this.closeReasonId = closeReasonId;
		this.cancelReasonId = cancelReasonId;
		this.advisorId = advisorId;
		this.advisorEntityId = advisorEntityid;
		this.comment = comment;
		this.clientId = clientId;
		this.agendaElementTypeId = agendaElementTypeId;
		this.langId = langId;
	}

	public Integer getAgendaElementId() {
		return agendaElementId;
	}

	public void setAgendaElementId(Integer agendaElementId) {
		this.agendaElementId = agendaElementId;
	}

	public Integer getCloseReasonId() {
		return closeReasonId;
	}

	public void setCloseReasonId(Integer closeReasonId) {
		this.closeReasonId = closeReasonId;
	}

	public Integer getCancelReasonId() {
		return cancelReasonId;
	}

	public void setCancelReasonId(Integer cancelReasonId) {
		this.cancelReasonId = cancelReasonId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Integer advisorId) {
		this.advisorId = advisorId;
	}

	public Integer getAdvisorEntityId() {
		return advisorEntityId;
	}

	public void setAdvisorEntityId(Integer advisorEntityid) {
		this.advisorEntityId = advisorEntityid;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getAgendaElementTypeId() {
		return agendaElementTypeId;
	}

	public void setAgendaElementTypeId(Integer agendaElementTypeId) {
		this.agendaElementTypeId = agendaElementTypeId;
	}

	public Integer getLangId() {
		return langId;
	}

	public void setLangId(Integer langId) {
		this.langId = langId;
	}

	@Override
	public List<TargetAction> getTargetActionObjects() {
		ArrayList<TargetAction> ta = new ArrayList<>();
		ta.add(new TargetAction(advisorEntityId, advisorId));
		return ta;
	}

	@Override
	public void defineTargetActionObjects() {
	}

	@Override
	public String toString() {
		return "CancelAgendaRequest [agendaElementId=" + agendaElementId + ", closeReasonId=" + closeReasonId
				+ ", cancelReasonId=" + cancelReasonId + ", advisorId=" + advisorId + ", advisorEntityId="
				+ advisorEntityId + ", comment=" + comment + ", clientId=" + clientId + ", agendaElementTypeId="
				+ agendaElementTypeId + ", langId=" + langId + "]";
	}

}
