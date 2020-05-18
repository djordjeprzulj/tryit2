package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.location;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda location item list
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaElementLocationItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<AgendaElementLocationItem> locationList;

	/**
	 * default constructor for Agenda Element Location Item List
	 */
	public AgendaElementLocationItemList() {
		super();
		this.locationList = new ArrayList<>();
	}

	/**
	 * Agenda Element Location Item List
	 * 
	 * @param locationList
	 * 				List of locations
	 */
	public AgendaElementLocationItemList(List<AgendaElementLocationItem> locationList) {
		super();
		this.locationList = locationList;
	}

	/**
	 * Get Location List
	 * 
	 * @return locationlist
	 * 				Returns location list
	 */
	public List<AgendaElementLocationItem> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<AgendaElementLocationItem> locationList) {
		this.locationList = locationList;
	}

	@Override
	public String toString() {
		return "AgendaLocationItemList [locationList=" + locationList + "]";
	}

}
