package fr.ca.sa.nct.commons.services.json.auth;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Read context transfer response container
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ReadContextTransferSessionResponse implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<String, String> attrbts;

	/**
	 * default constructor for Read Context Transfer Session Response
	 */
	public ReadContextTransferSessionResponse() {
		this.attrbts = new HashMap<>();
	}

	/**
	 * Read Context Transfer Session Response
	 * 
	 * @param attrbts
	 * 			Attributes
	 */
	public ReadContextTransferSessionResponse(Map<String, String> attrbts) {
		super();
		this.attrbts = attrbts;
	}

	public Map<String, String> getAttrbts() {
		return attrbts;
	}

	public void setAttrbts(Map<String, String> attrbts) {
		this.attrbts = attrbts;
	}

	@Override
	public String toString() {
		return "ReadContextTransferSessionResponse [attrbts=" + attrbts + "]";
	}

}
