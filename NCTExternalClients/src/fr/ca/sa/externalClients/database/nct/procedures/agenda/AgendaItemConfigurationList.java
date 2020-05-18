package fr.ca.sa.externalClients.database.nct.procedures.agenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Holder for a list of Agenda configuration items retrieved from databaseW
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaItemConfigurationList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<AgendaConfigurationItem> itemTypeList;

	/**
	 * default constructor for Agenda Item Configuration List
	 */
	public AgendaItemConfigurationList() {
		super();
		this.itemTypeList = new ArrayList<>();
	}

	/**
	 * Agenda Item Configuration List
	 * 
	 * @param itemTypeList
	 * 				Item type list
	 */
	public AgendaItemConfigurationList(List<AgendaConfigurationItem> itemTypeList) {
		super();
		this.itemTypeList = itemTypeList;
	}

	public List<AgendaConfigurationItem> getItemTypeList() {
		return itemTypeList;
	}

	public void setItemTypeList(List<AgendaConfigurationItem> itemTypeList) {
		this.itemTypeList = itemTypeList;
	}

	@Override
	public String toString() {
		return "AgendaItemConfigurationList [itemTypeList=" + itemTypeList + "]";
	}
}
