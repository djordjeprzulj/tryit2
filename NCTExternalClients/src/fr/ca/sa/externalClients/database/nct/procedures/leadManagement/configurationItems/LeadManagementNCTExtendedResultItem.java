package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.configurationItems;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class LeadManagementNCTExtendedResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer itemId;

	private String itemName;

	private Boolean isIndividual;

	/**
	 * default constructor for Lead Management NCT Extended Result Item
	 */
	public LeadManagementNCTExtendedResultItem() {
		super();
	}

	/**
	 * Lead Management NCT Extended Result Item
	 * 
	 * @param itemId
	 * 				Item ID
	 * 
	 * @param itemName
	 * 				Item name
	 * 
	 * @param individual
	 * 				Individual
	 */
	public LeadManagementNCTExtendedResultItem(Integer itemId, String itemName, Integer individual) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.isIndividual = individual == 1;
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

	public Boolean getIsIndividual() {
		return isIndividual;
	}

	public void setIsIndividual(Boolean isIndividual) {
		this.isIndividual = isIndividual;
	}

	@Override
	public String toString() {
		return "LeadManagementNCTExtendedResultItem [itemId=" + itemId + ", itemName=" + itemName + ", isIndividual="
				+ isIndividual + "]";
	}

}
