package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaParticipants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.model.Collaborator;

/**
 * 
 * Agenda Item participant list entity
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaElementParticipantList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<Collaborator> participantsList;

	/**
	 * default constructor for Agenda Element Participant List
	 */
	public AgendaElementParticipantList() {
		super();
		this.participantsList = new ArrayList<>();
	}

	/**
	 * Agenda Element Participant List
	 * 
	 * @param participantsList
	 * 				Participants list
	 */
	public AgendaElementParticipantList(List<Collaborator> participantsList) {
		super();
		this.participantsList = participantsList;
	}

	public List<Collaborator> getParticipantsList() {
		return participantsList;
	}

	public void setParticipantsList(List<Collaborator> participantsList) {
		this.participantsList = participantsList;
	}

	@Override
	public String toString() {
		return "AgendaElementParticipantList [participantsList=" + participantsList + "]";
	}

}
