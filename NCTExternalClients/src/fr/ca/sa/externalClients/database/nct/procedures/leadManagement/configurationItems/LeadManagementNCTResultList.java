package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.configurationItems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class LeadManagementNCTResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<LeadManagementNCTResultItem> itemList;

	/**
	 * default constructor for Lead Management NCT Result List
	 */
	public LeadManagementNCTResultList() {
		super();
		this.itemList = new ArrayList<>();
	}

	/**
	 * Lead Management NCT Result List
	 * 
	 * @param itemList
	 * 				Item list
	 */
	public LeadManagementNCTResultList(List<LeadManagementNCTResultItem> itemList) {
		super();
		this.itemList = itemList;
	}

	public List<LeadManagementNCTResultItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<LeadManagementNCTResultItem> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "LeadManagementItemList [itemList=" + itemList + "]";
	}

}
