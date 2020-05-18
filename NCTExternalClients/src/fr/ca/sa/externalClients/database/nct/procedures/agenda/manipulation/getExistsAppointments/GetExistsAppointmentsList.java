package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getExistsAppointments;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Existing appointments item List (basic info)
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetExistsAppointmentsList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetExistsAppointmentsItem> appointments;

	/**
	 * default constructor for Get Exists Appointments List
	 */
	public GetExistsAppointmentsList() {
		super();
		this.appointments = new ArrayList<>();
	}

	/**
	 * Get Exists Appointments List
	 * 
	 * @param appointments
	 * 				Appointments
	 */
	public GetExistsAppointmentsList(List<GetExistsAppointmentsItem> appointments) {
		super();
		this.appointments = appointments;
	}

	public List<GetExistsAppointmentsItem> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<GetExistsAppointmentsItem> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "GetExistsAppointmentsList [appointments=" + appointments + "]";
	}

}
