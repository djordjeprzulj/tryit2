package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.location;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda location options list
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaElementLocationItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int locationId;

	private String locationName;

	/**
	 * default constructor for Agenda Element Location Item
	 */
	public AgendaElementLocationItem() {
		super();
	}

	/**
	 * Agenda Element Location Item
	 * 
	 * @param locationId
	 * 				Location ID
	 * 
	 * @param locationName
	 * 				Location name
	 */
	public AgendaElementLocationItem(int locationId, String locationName) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Override
	public String toString() {
		return "AgendaElementLocationItem [locationId=" + locationId + ", locationName=" + locationName + "]";
	}

}
