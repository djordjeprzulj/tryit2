package fr.ca.sa.nctAgendaAPI.commons.services.json.agendaAPI;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Read Agenda Request
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ReadAgendaRequest implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<Integer> agendaElementIdList;
	private Long clientId;
	private Integer entityId;
	private List<String> period;
	private List<Integer> statusList;
	private List<Integer> typeList;
	private Integer collaboratorId;

	/**
	 * @param default
	 *            constructor
	 */
	public ReadAgendaRequest() {
	}
	/**
	 * 
	 * @param agendaElementIdList
	 * @param clientId
	 * @param entityId
	 * @param period
	 * @param statusList
	 * @param typeList
	 * @param collaboratorId
	 */
	public ReadAgendaRequest(List<Integer> agendaElementIdList, Long clientId, Integer entityId, List<String> period,
			List<Integer> statusList, List<Integer> typeList, Integer collaboratorId) {
		super();
		this.agendaElementIdList = agendaElementIdList;
		this.clientId = clientId;
		this.entityId = entityId;
		this.period = period;
		this.statusList = statusList;
		this.typeList = typeList;
		this.collaboratorId = collaboratorId;
	}

	/**
	 * @return the agendaElementIdList
	 */
	public List<Integer> getAgendaElementIdList() {
		return agendaElementIdList;
	}

	/**
	 * @param agendaElementIdList the agendaElementIdList to set
	 */
	public void setAgendaElementIdList(List<Integer> agendaElementIdList) {
		this.agendaElementIdList = agendaElementIdList;
	}

	/**
	 * @return the clientId
	 */
	public Long getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the entityId
	 */
	public Integer getEntityId() {
		return entityId;
	}

	/**
	 * @param entityId the entityId to set
	 */
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	/**
	 * @return the period
	 */
	public List<String> getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(List<String> period) {
		this.period = period;
	}

	/**
	 * @return the statusList
	 */
	public List<Integer> getStatusList() {
		return statusList;
	}

	/**
	 * @param statusList the statusList to set
	 */
	public void setStatusList(List<Integer> statusList) {
		this.statusList = statusList;
	}

	/**
	 * @return the typeList
	 */
	public List<Integer> getTypeList() {
		return typeList;
	}

	/**
	 * @param typeList the typeList to set
	 */
	public void setTypeList(List<Integer> typeList) {
		this.typeList = typeList;
	}

	/**
	 * @return the collaboratorId
	 */
	public Integer getCollaboratorId() {
		return collaboratorId;
	}

	/**
	 * @param collaboratorId the collaboratorId to set
	 */
	public void setCollaboratorId(Integer collaboratorId) {
		this.collaboratorId = collaboratorId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReadAgendaRequest [agendaElementIdList=" + agendaElementIdList + ", clientId=" + clientId
				+ ", entityId=" + entityId + ", period=" + period + ", statusList=" + statusList + ", typeList="
				+ typeList + ", collaboratorId=" + collaboratorId + "]";
	}
	
}
