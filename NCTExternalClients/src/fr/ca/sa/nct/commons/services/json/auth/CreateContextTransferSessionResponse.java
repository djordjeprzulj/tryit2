package fr.ca.sa.nct.commons.services.json.auth;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Create context transfer response container
 * 
 * @author Nemanja Ignjatov
 *
 */
public class CreateContextTransferSessionResponse implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String sslbId;

	public CreateContextTransferSessionResponse() {
	}

	/**
	 * Create Context Transfer Session Response
	 * 
	 * @param sslbId
	 */
	public CreateContextTransferSessionResponse(String sslbId) {
		super();
		this.sslbId = sslbId;
	}

	public String getSslbId() {
		return sslbId;
	}

	public void setSslbId(String sslbId) {
		this.sslbId = sslbId;
	}

}
