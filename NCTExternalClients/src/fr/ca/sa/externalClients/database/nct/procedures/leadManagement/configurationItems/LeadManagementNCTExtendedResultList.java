package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.configurationItems;

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
public class LeadManagementNCTExtendedResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<LeadManagementNCTExtendedResultItem> extendedList;

	/**
	 * default constructor for Lead Management NCT Extended Result List
	 */
	public LeadManagementNCTExtendedResultList() {
		super();
		this.extendedList = new ArrayList<>();
	}

	/**
	 * Lead Management NCT Extended Result List
	 * 
	 * @param extendedList
	 * 				Extended list
	 */
	public LeadManagementNCTExtendedResultList(List<LeadManagementNCTExtendedResultItem> extendedList) {
		super();
		this.extendedList = extendedList;
	}

	public List<LeadManagementNCTExtendedResultItem> getExtendedList() {
		return extendedList;
	}

	public void setExtendedList(List<LeadManagementNCTExtendedResultItem> extendedList) {
		this.extendedList = extendedList;
	}

	@Override
	public String toString() {
		return "LeadManagementNCTExtendedResultList [extendedList=" + extendedList + "]";
	}

}
