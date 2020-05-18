package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.setAgendaItem;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Set agenda item/element return value
 * 
 * @author Sasa Radovanovic
 *
 */
public class SetAgendaItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer agendaElementId;

	/**
	 * default constructor for Set Agenda Item
	 */
	public SetAgendaItem() {
		super();
	}

	/**
	 * Set Agenda Item
	 * 
	 * @param agendaElementId
	 * 				Agenda element ID
	 */
	public SetAgendaItem(Integer agendaElementId) {
		super();
		this.agendaElementId = agendaElementId;
	}

	public Integer getAgendaElementId() {
		return agendaElementId;
	}

	public void setAgendaElementId(Integer agendaElementId) {
		this.agendaElementId = agendaElementId;
	}

	@Override
	public String toString() {
		return "SetAgendaItem [agendaElementId=" + agendaElementId + "]";
	}

}
