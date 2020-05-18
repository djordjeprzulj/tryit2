package fr.ca.sa.externalClients.database.nct.procedures.quickContact.configurationQCR;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class QuickContactReportItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<QuickContactReportItem> itemList;

	/**
	 * default constructor for Quick Contact Report Item List
	 */
	public QuickContactReportItemList() {
		super();
		this.itemList = new ArrayList<>();
	}

	/**
	 * Quick Contact Report Item List
	 * 
	 * @param itemList
	 * 				List of QCR items
	 */
	public QuickContactReportItemList(List<QuickContactReportItem> itemList) {
		super();
		this.itemList = itemList;
	}

	public List<QuickContactReportItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<QuickContactReportItem> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "QuickContactReportItemList [itemList=" + itemList + "]";
	}

}
