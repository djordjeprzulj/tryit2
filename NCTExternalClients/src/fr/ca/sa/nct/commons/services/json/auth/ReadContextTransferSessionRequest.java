package fr.ca.sa.nct.commons.services.json.auth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Read context transfer request container
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ReadContextTransferSessionRequest implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String sslbId;
	private List<String> tknKs;

	/**
	 * default constructor for Read Context Transfer Session Request
	 */
	public ReadContextTransferSessionRequest() {
		this.tknKs = new ArrayList<>();
	}

	/**
	 * Read Context Transfer Session Request
	 * 
	 * @param sslbId
	 * 			
	 * @param tknKs
	 */
	public ReadContextTransferSessionRequest(String sslbId, List<String> tknKs) {
		super();
		this.sslbId = sslbId;
		this.tknKs = tknKs;
	}

	public String getSslbId() {
		return sslbId;
	}

	public void setSslbId(String sslbId) {
		this.sslbId = sslbId;
	}

	public List<String> getTknKs() {
		return tknKs;
	}

	public void setTknKs(List<String> tknKs) {
		this.tknKs = tknKs;
	}

	@Override
	public String toString() {
		return "ReadContextTransferSessionRequest [sslbId=" + sslbId + ", tknKs=" + tknKs + "]";
	}

}
