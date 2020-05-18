package fr.ca.sa.nct.commons.services.json.leadManagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.json.Target;
import fr.ca.sa.nct.commons.authorizationUtils.json.TargetAction;

/**
 * 
 * Request JSON wrapper for getting lead prospect
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetProspectsRequest implements Target, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int prospectId;

	private ArrayList<TargetAction> targetActionObjects;

	/**
	 * default constructor for Get Prospects Request
	 */
	public GetProspectsRequest() {
		super();
	}

	/**
	 * Get Prospects Request
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 */
	public GetProspectsRequest(int prospectId) {
		super();
		this.prospectId = prospectId;
	}

	public int getProspectId() {
		return prospectId;
	}

	public void setProspectId(int prospectId) {
		this.prospectId = prospectId;
	}

	@Override
	public String toString() {
		return "GetProspectsRequest [prospectId=" + prospectId + ", targetActionObjects=" + targetActionObjects + "]";
	}

	@Override
	public List<TargetAction> getTargetActionObjects() {
		return targetActionObjects;
	}

	@Override
	public void defineTargetActionObjects() {
	}

}
