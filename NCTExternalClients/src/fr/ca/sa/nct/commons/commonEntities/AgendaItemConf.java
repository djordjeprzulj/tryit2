package fr.ca.sa.nct.commons.commonEntities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * 
 * Entity holder for Agenda configuration item
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaItemConf implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, String> titles = new HashMap<>();

	private Map<Integer, HashMap<String, String>> purposes = new HashMap<>();

	private String color;

	private Map<String, Boolean> visibleFields = new HashMap<>();

	private Map<String, Boolean> mandatoryFields = new HashMap<>();

	private Map<String, String> defaultValues = new HashMap<>();

	private Boolean allDayActivity;

	/**
	 * default constructor for Agenda Item Configuration
	 */
	public AgendaItemConf() {
		super();
		this.titles = new HashMap<>();
		this.purposes = new HashMap<>();
		this.visibleFields = new HashMap<>();
		this.mandatoryFields = new HashMap<>();
		this.defaultValues = new HashMap<>();
		this.allDayActivity = false;
	}

	/**
	 * Agenda Item Configuration
	 * 
	 * @param titles
	 * 				Titles
	 * 
	 * @param purposes
	 * 				Purposes
	 * 
	 * @param color
	 * 				Color
	 * 
	 * @param visibleFields
	 * 				Visible fields
	 * 
	 * @param allDay
	 * 				All day
	 */
	public AgendaItemConf(Map<String, String> titles, Map<Integer, HashMap<String, String>> purposes,
			String color, Map<String, Boolean> visibleFields, Boolean allDay) {
		super();
		this.titles = titles;
		this.color = color;
		this.purposes = purposes;
		this.visibleFields = visibleFields;
		this.allDayActivity = allDay;
	}

	/**
	 * Agenda Item Configuration
	 * 
	 * @param titles
	 * 				Titles
	 * 
	 * @param purposes
	 * 				Purposes
	 * 
	 * @param color
	 * 				Color
	 * 
	 * @param allDay
	 * 				All day
	 */
	public AgendaItemConf(Map<String, String> titles, Map<Integer, HashMap<String, String>> purposes,
			String color, Boolean allDay) {
		super();
		this.titles = titles;
		this.color = color;
		this.purposes = purposes;
		this.visibleFields = new HashMap<>();
		this.allDayActivity = allDay;
	}

	public Map<String, String> getTitles() {
		return titles;
	}

	public void setTitles(Map<String, String> titles) {
		this.titles = titles;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Map<Integer, HashMap<String, String>> getPurposes() {
		return purposes;
	}

	public void setPurposes(Map<Integer, HashMap<String, String>> purposes) {
		this.purposes = purposes;
	}

	public Map<String, Boolean> getVisibleFields() {
		return visibleFields;
	}

	public void setVisibleFields(Map<String, Boolean> visibleFields) {
		this.visibleFields = visibleFields;
	}

	public Map<String, Boolean> getMandatoryFields() {
		return mandatoryFields;
	}

	public void setMandatoryFields(Map<String, Boolean> mandatoryFields) {
		this.mandatoryFields = mandatoryFields;
	}

	public Map<String, String> getDefaultValues() {
		return defaultValues;
	}

	public void setDefaultValues(Map<String, String> defaultValues) {
		this.defaultValues = defaultValues;
	}

	public Boolean getAllDayActivity() {
		return allDayActivity;
	}

	public void setAllDayActivity(Boolean allDayActivity) {
		this.allDayActivity = allDayActivity;
	}
}
