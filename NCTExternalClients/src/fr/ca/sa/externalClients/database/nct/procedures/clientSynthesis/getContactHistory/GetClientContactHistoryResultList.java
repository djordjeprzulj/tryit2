package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getContactHistory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Result holder for contact history list
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetClientContactHistoryResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetClientContactHistoryResultItem> contactHistory;

	/**
	 * default constructor for Get Client Contact History Result List
	 */
	public GetClientContactHistoryResultList() {
		super();
		this.contactHistory = new ArrayList<>();
	}

	/**
	 * Get Client Contact History Result List
	 * 
	 * @param contactHistory
	 * 				Contact history
	 */
	public GetClientContactHistoryResultList(List<GetClientContactHistoryResultItem> contactHistory) {
		super();
		this.contactHistory = contactHistory;
	}

	public List<GetClientContactHistoryResultItem> getContactHistory() {
		return contactHistory;
	}

	public void setContactHistory(List<GetClientContactHistoryResultItem> contactHistory) {
		this.contactHistory = contactHistory;
	}

	@Override
	public String toString() {
		return "GetClientContactHistoryResultList [contactHistory=" + contactHistory + "]";
	}

}
