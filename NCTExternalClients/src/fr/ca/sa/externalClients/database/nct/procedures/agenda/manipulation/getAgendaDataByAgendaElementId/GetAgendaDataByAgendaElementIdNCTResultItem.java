package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaDataByAgendaElementId;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Jelena Raca
 *
 */
public class GetAgendaDataByAgendaElementIdNCTResultItem implements StoreProcedureResult, Serializable {
	
	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer advisorId;
	private Integer entityId;
	
	/**
	 * default constructor for Get Agenda Data By Agenda Element Id NCT Result Item
	 */
	public GetAgendaDataByAgendaElementIdNCTResultItem() {
		super();
	}
	
	/**
	 * Get Agenda Data By Agenda Element Id NCT Result Item
	 * 
	 * @param advisorId
	 * 			Advisor ID
	 * 
	 * @param entityId
	 * 			Entity ID
	 */
	public GetAgendaDataByAgendaElementIdNCTResultItem(Integer advisorId, Integer entityId) {
		super();
		this.advisorId = advisorId;
		this.entityId = entityId;
	}

	public Integer getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Integer advisorId) {
		this.advisorId = advisorId;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	@Override
	public String toString() {
		return "GetAgendaDataByAgendaElementIdNCTResultItem [advisorId=" + advisorId + ", entityId=" + entityId + "]";
	}
	
}
