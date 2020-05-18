package fr.ca.sa.nct.commons.services.json.auth;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Create Context Transfer Session Request
 * 
 * @author Nemanja Ignjatov
 *
 */
public class CreateContextTransferSessionRequest implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, String> elmtKsAttrbts;

	/**
	 * default constructor for Create Context Transfer Session Request
	 */
	public CreateContextTransferSessionRequest() {
		this.elmtKsAttrbts = new HashMap<>();

	}

	/**
	 * Create Context Transfer Session Request
	 * 
	 * @param elmtKsAttrbts
	 * 				Attributes
	 */
	public CreateContextTransferSessionRequest(Map<String, String> elmtKsAttrbts) {
		super();
		this.elmtKsAttrbts = elmtKsAttrbts;
	}

	public Map<String, String> getElmtKsAttrbts() {
		return elmtKsAttrbts;
	}

	public void setElmtKsAttrbts(Map<String, String> elmtKsAttrbts) {
		this.elmtKsAttrbts = elmtKsAttrbts;
	}

	@Override
	public String toString() {
		return "CreateContextTransferSessionRequest [elmtKsAttrbts=" + elmtKsAttrbts + "]";
	}

}
