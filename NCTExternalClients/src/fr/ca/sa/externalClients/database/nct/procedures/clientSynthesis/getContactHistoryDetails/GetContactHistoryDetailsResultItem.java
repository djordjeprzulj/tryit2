package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getContactHistoryDetails;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.ContactHistory;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetContactHistoryDetailsResultItem implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	ContactHistory contactHistory;

	/**
	 * default constructor for Get Contact History Details Result Item
	 */
	public GetContactHistoryDetailsResultItem() {
		super();
	}

	/**
	 * Get Contact History Details Result Item
	 * 
	 * @param contactHistory
	 * 				Contact history
	 * 
	 */
	public GetContactHistoryDetailsResultItem(ContactHistory contactHistory) {
		super();
		this.contactHistory = contactHistory;
	}

	public ContactHistory getContactHistory() {
		return contactHistory;
	}

	public void setContactHistory(ContactHistory contactHistory) {
		this.contactHistory = contactHistory;
	}
	
	@Override
	public String toString() {
		return "GetContactHistoryDetailsResultItem [contactHistory=" + contactHistory + "]";
	}
}
