package fr.ca.sa.externalClients.database.nct.procedures.agenda;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Holder for single Agenda item configuration data retrieved from database
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaConfigurationItem implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int agendaItemTypeId;

	private String agendaItemTypeName;

	private String agendaItemTypeColor;

	private Boolean agendaItemAllDay;

	/**
	 * default constructor for Agenda Configuration Item
	 */
	public AgendaConfigurationItem() {
		super();
	}

	/**
	 * Agenda Configuration Item
	 * 
	 * @param agendaItemTypeId
	 * 				Agenda item type ID
	 * 
	 * @param agendaItemTypeName
	 * 				Agenda item type name
	 * 
	 * @param agendaItemTypeColor
	 * 				Agenda item type color
	 * 
	 * @param agendaItemAllDay
	 * 				Agenda item all day
	 */
	public AgendaConfigurationItem(int agendaItemTypeId, String agendaItemTypeName, String agendaItemTypeColor,
			Integer agendaItemAllDay) {
		super();
		this.agendaItemTypeId = agendaItemTypeId;
		this.agendaItemTypeName = agendaItemTypeName;
		this.agendaItemTypeColor = agendaItemTypeColor;
		if (agendaItemAllDay == 1) {
			this.agendaItemAllDay = true;
		} else {
			this.agendaItemAllDay = false;
		}
	}

	public int getAgendaItemTypeId() {
		return agendaItemTypeId;
	}

	public void setAgendaItemTypeId(int agendaItemTypeId) {
		this.agendaItemTypeId = agendaItemTypeId;
	}

	public String getAgendaItemTypeName() {
		return agendaItemTypeName;
	}

	public void setAgendaItemTypeName(String agendaItemTypeName) {
		this.agendaItemTypeName = agendaItemTypeName;
	}

	public String getAgendaItemTypeColor() {
		return agendaItemTypeColor;
	}

	public void setAgendaItemTypeColor(String agendaItemTypeColor) {
		this.agendaItemTypeColor = agendaItemTypeColor;
	}

	public Boolean getAgendaItemAllDay() {
		return agendaItemAllDay;
	}

	public void setAgendaItemAllDay(Boolean agendaItemAllDay) {
		this.agendaItemAllDay = agendaItemAllDay;
	}

}
