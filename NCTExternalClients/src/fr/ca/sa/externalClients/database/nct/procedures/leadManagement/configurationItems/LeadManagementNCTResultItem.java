package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.configurationItems;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class LeadManagementNCTResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer itemId;

	private String itemName;

	/**
	 * default constructor for Lead Management NCT Result Item
	 */
	public LeadManagementNCTResultItem() {
		super();
	}

	/**
	 * Lead Management NCT Result Item
	 * 
	 * @param itemId
	 * 				Item ID
	 * 
	 * @param itemName
	 * 				Item name
	 */
	public LeadManagementNCTResultItem(Integer itemId, String itemName) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "LeadManagementItem [itemId=" + itemId + ", itemName=" + itemName + "]";
	}

}
