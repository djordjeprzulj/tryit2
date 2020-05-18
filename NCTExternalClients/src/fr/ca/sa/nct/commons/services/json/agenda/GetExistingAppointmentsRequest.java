package fr.ca.sa.nct.commons.services.json.agenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.json.Target;
import fr.ca.sa.nct.commons.authorizationUtils.json.TargetAction;

/**
 * 
 * Get existing appointments request container
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetExistingAppointmentsRequest implements Target, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int clientId;

	private String startTime;
	private Integer agendaElementId;

	/**
	 * default constructor for Get Existing Appointments Request
	 */
	public GetExistingAppointmentsRequest() {
		super();
	}

	/**
	 * Get Existing Appointments Request
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param startTime
	 * 				Start time
	 * 
	 * @param agendaElementId
	 * 				Agenda element ID
	 */
	public GetExistingAppointmentsRequest(int clientId, String startTime, Integer agendaElementId) {
		super();
		this.clientId = clientId;
		this.startTime = startTime;
		this.agendaElementId = agendaElementId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Integer getAgendaElementId() {
		return agendaElementId;
	}

	public void setAgendaElementId(Integer agendaElementId) {
		this.agendaElementId = agendaElementId;
	}

	@Override
	public List<TargetAction> getTargetActionObjects() {
		TargetAction ta = new TargetAction(clientId);
		ArrayList<TargetAction> list = new ArrayList<>();
		list.add(ta);
		return list;
	}

	@Override
	public void defineTargetActionObjects() {
	}
	
	@Override
	public String toString() {
		return "GetExistingAppointmentsRequest [clientId=" + clientId + ", startTime=" + startTime
				+ ", agendaElementId=" + agendaElementId + "]";
	}

}
