package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getContactHistoryDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetContactHistoryDetailsResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetContactHistoryDetailsResultItem> contactHistoryDetails;

	/**
	 * default constructor for Get Contact History Details Result List
	 */
	public GetContactHistoryDetailsResultList() {
		super();
		this.contactHistoryDetails = new ArrayList<GetContactHistoryDetailsResultItem>();
	}

	/**
	 * Get Contact History Details Result List
	 * 
	 * @param contactHistoryDetails
	 * 				Contact history details
	 */
	public GetContactHistoryDetailsResultList(List<GetContactHistoryDetailsResultItem> contactHistoryDetails) {
		super();
		this.contactHistoryDetails = contactHistoryDetails;
	}

	public List<GetContactHistoryDetailsResultItem> getContactHistoryDetails() {
		return contactHistoryDetails;
	}

	public void setContactHistoryDetails(List<GetContactHistoryDetailsResultItem> contactHistoryDetails) {
		this.contactHistoryDetails = contactHistoryDetails;
	}

	@Override
	public String toString() {
		return "GetContactHistoryDetailsResultList [contactHistoryDetails=" + contactHistoryDetails + "]";
	}

}
