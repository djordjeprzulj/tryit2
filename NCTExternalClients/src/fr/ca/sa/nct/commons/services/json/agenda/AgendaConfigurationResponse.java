package fr.ca.sa.nct.commons.services.json.agenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.commonEntities.AgendaItemConf;
import fr.ca.sa.nct.commons.commonEntities.QuickContactTemplate;
import fr.ca.sa.nct.commons.commonEntities.TranslatableElementConf;

/**
 * @author Nemanja Ignjatov
 * @author Sasa Radovanovic
 *
 *         Class container for agenda configuration, includes : agenda message
 *         templates, items configuration, field configuration and agenda past
 *         days
 */
public class AgendaConfigurationResponse implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, ArrayList<TranslatableElementConf>> fields;
	private Map<Integer, AgendaItemConf> items;
	private List<QuickContactTemplate> messageTemplates;
	private Integer agendaCUDPastDays; // Field for defining how many days in
										// the past can agenda item be Created,
										// Updated or Deleted

	/**
	 * default constructor for Agenda Configuration Response
	 */
	public AgendaConfigurationResponse() {
		super();
	}

	/**
	 * Agenda Configuration Response
	 * 
	 * @param fields
	 * 				Fields 
	 * 
	 * @param items
	 * 				Items
	 * 
	 * @param messageTemplates
	 * 				Message templates
	 * 
	 * @param agendaCUDPastDays
	 * 				Agenda CUD past days
	 */
	public AgendaConfigurationResponse(Map<String, ArrayList<TranslatableElementConf>> fields,
			Map<Integer, AgendaItemConf> items, List<QuickContactTemplate> messageTemplates,
			Integer agendaCUDPastDays) {
		super();
		this.fields = fields;
		this.items = items;
		this.messageTemplates = messageTemplates;
		this.agendaCUDPastDays = agendaCUDPastDays;
	}

	public Map<String, ArrayList<TranslatableElementConf>> getFields() {
		return fields;
	}

	public void setFields(Map<String, ArrayList<TranslatableElementConf>> fields) {
		this.fields = fields;
	}

	public Map<Integer, AgendaItemConf> getItems() {
		return items;
	}

	public void setItems(Map<Integer, AgendaItemConf> items) {
		this.items = items;
	}

	public List<QuickContactTemplate> getMessageTemplates() {
		return messageTemplates;
	}

	public void setMessageTemplates(List<QuickContactTemplate> messageTemplates) {
		this.messageTemplates = messageTemplates;
	}

	public Integer getAgendaCUDPastDays() {
		return agendaCUDPastDays;
	}

	public void setAgendaCUDPastDays(Integer agendaCUDPastDays) {
		this.agendaCUDPastDays = agendaCUDPastDays;
	}

	@Override
	public String toString() {
		return "AgendaConfigurationResponse [fields=" + fields + ", items=" + items + ", messageTemplates="
				+ messageTemplates + ", agendaCUDPastDays=" + agendaCUDPastDays + "]";
	}

}
