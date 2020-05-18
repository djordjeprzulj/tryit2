package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.status;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda single status data holder
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaStatusItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer statusId;

	private String statusName;

	/**
	 * default constructor for Agenda Status Item
	 */
	public AgendaStatusItem() {
		super();
	}

	/**
	 * Agenda Status Item
	 * 
	 * @param statusId
	 * 				Status ID
	 * 
	 * @param statusName
	 * 				Status name
	 */
	public AgendaStatusItem(Integer statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "AgendaStatusItem [statusId=" + statusId + ", statusName=" + statusName + "]";
	}

}
