package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response of getting client needs from catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientNeedsCategoriesResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetClientNeedsCategoriesResponseItems> clientNeeds;

	/**
	 * default constructor for Get Client Needs Categories Response
	 */
	public GetClientNeedsCategoriesResponse() {
		super();
		this.clientNeeds = new ArrayList<GetClientNeedsCategoriesResponseItems>();
	}

	/**
	 * Get Client Needs Categories Response
	 * 
	 * @param clientNeeds
	 * 				Client needs
	 */
	public GetClientNeedsCategoriesResponse(List<GetClientNeedsCategoriesResponseItems> clientNeeds) {
		super();
		this.clientNeeds = clientNeeds;
	}

	public List<GetClientNeedsCategoriesResponseItems> getClientNeeds() {
		return clientNeeds;
	}

	public void setClientNeeds(List<GetClientNeedsCategoriesResponseItems> clientNeeds) {
		this.clientNeeds = clientNeeds;
	}

	@Override
	public String toString() {
		return "GetClientNeedsCategoriesResponse [clientNeeds=" + clientNeeds + "]";
	}

}
