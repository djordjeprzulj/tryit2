package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getExistsAppointments;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Existing appointment item holder (with basic info)
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetExistsAppointmentsItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer advisorId;
	private String advisorFirstName;
	private String advisorLastName;
	private String startTime;

	/**
	 * default constructor for Get Exists Appointments Item
	 */
	public GetExistsAppointmentsItem() {
		super();
	}

	/**
	 * Get Exists Appointments Item
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 * 
	 * @param advisorFirstName
	 * 				Advisor first name
	 * 
	 * @param advisorLastName
	 * 				Advisor last name
	 * 
	 * @param startTime
	 * 				Start time
	 */
	public GetExistsAppointmentsItem(Integer advisorId, String advisorFirstName, String advisorLastName,
			String startTime) {
		super();
		this.advisorId = advisorId;
		this.advisorFirstName = advisorFirstName;
		this.advisorLastName = advisorLastName;
		this.startTime = startTime;
	}

	public Integer getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Integer advisorId) {
		this.advisorId = advisorId;
	}

	public String getAdvisorFirstName() {
		return advisorFirstName;
	}

	public void setAdvisorFirstName(String advisorFirstName) {
		this.advisorFirstName = advisorFirstName;
	}

	public String getAdvisorLastName() {
		return advisorLastName;
	}

	public void setAdvisorLastName(String advisorLastName) {
		this.advisorLastName = advisorLastName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "GetExistsAppointmentsItem [advisorId=" + advisorId + ", advisorFirstName=" + advisorFirstName
				+ ", advisorLastName=" + advisorLastName + ", startTime=" + startTime + "]";
	}

}
