package fr.ca.sa.nct.commons.services.json.agenda;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * @author Nemanja Ignjatov
 *
 *         Class container for not closed agenda items
 */
public class AgendaNotClosedAppointmentsResponse implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int agendaElementId;
	private Map<String, String> titles;
	private String agendaElementStartTime;
	private String agendaElementEndTime;
	private String clientOrLead;
	private int clientId;
	private String clientName;
	private int clientEntityId;

	/**
	 * default constructor for Agenda Not Closed Appointments Response
	 */
	public AgendaNotClosedAppointmentsResponse() {
		super();
		this.titles = new HashMap<String, String>();
	}

	/**
	 * Agenda Not Closed Appointments Response
	 * 
	 * @param agendaElementId
	 * 				Agenda element ID
	 * 
	 * @param agendaElementStartTime
	 * 				Agenda element start time
	 * 
	 * @param agendaElementEndTime
	 * 				Agenda element end time
	 * 
	 * @param clientOrLead
	 * 				Client or lead
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param clientName
	 * 				Client name
	 * 
	 * @param clientEntityId
	 * 				Client entity ID
	 */
	public AgendaNotClosedAppointmentsResponse(int agendaElementId, String agendaElementStartTime,
			String agendaElementEndTime, String clientOrLead, int clientId, String clientName, int clientEntityId) {
		super();
		this.agendaElementId = agendaElementId;
		this.agendaElementStartTime = agendaElementStartTime;
		this.agendaElementEndTime = agendaElementEndTime;
		this.clientOrLead = clientOrLead;
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientEntityId = clientEntityId;

		this.titles = new HashMap<String, String>();
	}

	public int getAgendaElementId() {
		return agendaElementId;
	}

	public void setAgendaElementId(int agendaElementId) {
		this.agendaElementId = agendaElementId;
	}

	public Map<String, String> getTitles() {
		return titles;
	}

	public void setTitles(Map<String, String> titles) {
		this.titles = titles;
	}

	public String getAgendaElementStartTime() {
		return agendaElementStartTime;
	}

	public void setAgendaElementStartTime(String agendaElementStartTime) {
		this.agendaElementStartTime = agendaElementStartTime;
	}

	public String getAgendaElementEndTime() {
		return agendaElementEndTime;
	}

	public void setAgendaElementEndTime(String agendaElementEndTime) {
		this.agendaElementEndTime = agendaElementEndTime;
	}

	public String getClientOrLead() {
		return clientOrLead;
	}

	public void setClientOrLead(String clientOrLead) {
		this.clientOrLead = clientOrLead;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getClientEntityId() {
		return clientEntityId;
	}

	public void setClientEntityId(int clientEntityId) {
		this.clientEntityId = clientEntityId;
	}

	@Override
	public String toString() {
		return "AgendaNotClosedAppointmentsResponse [agendaElementId=" + agendaElementId + ", titles=" + titles
				+ ", agendaElementStartTime=" + agendaElementStartTime + ", agendaElementEndTime="
				+ agendaElementEndTime + ", clientOrLead=" + clientOrLead + ", clientId=" + clientId + ", clientName="
				+ clientName + ", clientEntityId=" + clientEntityId + "]";
	}

}
