package fr.ca.sa.nct.commons.services.json.agenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.AgendaElement;
import fr.ca.sa.nct.commons.authorizationUtils.json.Target;
import fr.ca.sa.nct.commons.authorizationUtils.json.TargetAction;

/**
 * 
 * Set Agenda element request
 * 
 * @author Sasa Radovanovic
 *
 */
public class SetAgendaItemRequest implements Target, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer langId;
	private String lang;
	
	private AgendaElement agendaElement;
	
	/**
	 * default constructor for Agenda Item Request
	 */
	public SetAgendaItemRequest() {
		super();
	}

	/**
	 * Agenda Item Request
	 *
	 * 
	 * @param agendaElement
	 * 				Agenda element
	 * 
	 */
	public SetAgendaItemRequest(AgendaElement agendaElement, Integer langId, String lang) {
		super();
		this.agendaElement = agendaElement;
		this.langId = langId;
		this.lang = lang;
	}

	public Integer getLangId() {
		return langId;
	}

	public void setLangId(Integer langId) {
		this.langId = langId;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public AgendaElement getAgendaElement() {
		return agendaElement;
	}

	public void setAgendaElement(AgendaElement agendaElement) {
		this.agendaElement = agendaElement;
	}

	@Override
	public List<TargetAction> getTargetActionObjects() {
		ArrayList<TargetAction> taList = new ArrayList<>();
		if (agendaElement != null) {
			taList.add(new TargetAction(agendaElement.getAdvisor().getPrimaryEntity().getId(), agendaElement.getAdvisor().getId()));
		} else {
			taList.add(new TargetAction(0, 0));
		}
			
		return taList;
	}

	@Override
	public void defineTargetActionObjects() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SetAgendaItemRequest [langId=" + langId + ", lang=" + lang + ", agendaElement=" + agendaElement + "]";
	}
}
