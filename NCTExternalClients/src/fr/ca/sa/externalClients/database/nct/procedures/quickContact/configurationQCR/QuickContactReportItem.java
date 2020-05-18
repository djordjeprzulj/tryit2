package fr.ca.sa.externalClients.database.nct.procedures.quickContact.configurationQCR;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class QuickContactReportItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer itemId;

	private String itemName;

	/**
	 * default constructor for Quick Contact Report Item
	 */
	public QuickContactReportItem() {
		super();
	}

	/**
	 * Quick Contact Report Item
	 * 
	 * @param itemId
	 * 				Item ID
	 * 
	 * @param itemName
	 * 				Item name
	 */
	public QuickContactReportItem(Integer itemId, String itemName) {
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
		return "QuickContactReportItem [itemId=" + itemId + ", itemName=" + itemName + "]";
	}

}
