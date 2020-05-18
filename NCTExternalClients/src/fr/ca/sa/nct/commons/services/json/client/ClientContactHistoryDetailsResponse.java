package fr.ca.sa.nct.commons.services.json.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ClientContactHistoryDetailsResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<TranslatableClientContactHistoryDetails> contactHistoryDetails;

	/**
	 * default constructor for Client Contact History Details Response
	 */
	public ClientContactHistoryDetailsResponse() {
		super();
		this.contactHistoryDetails = new ArrayList<TranslatableClientContactHistoryDetails>();
	}

	/**
	 * Client Contact History Details Response
	 * 
	 * @param contactHistoryDetails
	 * 				Contact history details
	 */
	public ClientContactHistoryDetailsResponse(
			List<TranslatableClientContactHistoryDetails> contactHistoryDetails) {
		super();
		this.contactHistoryDetails = contactHistoryDetails;
	}

	public List<TranslatableClientContactHistoryDetails> getContactHistoryDetails() {
		return contactHistoryDetails;
	}

	public void setContactHistoryDetails(List<TranslatableClientContactHistoryDetails> contactHistoryDetails) {
		this.contactHistoryDetails = contactHistoryDetails;
	}

}
