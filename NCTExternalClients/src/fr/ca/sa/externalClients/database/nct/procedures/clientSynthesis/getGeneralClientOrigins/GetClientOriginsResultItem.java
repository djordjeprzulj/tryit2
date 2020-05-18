package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getGeneralClientOrigins;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Result Item for client origin store procedure
 * 
 * @author Nemanja Ignjatov
 */
public class GetClientOriginsResultItem implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int clientOriginId;

	private String clientOriginName;

	/**
	 * Get Client Origins Result Item
	 * 
	 * @param clientOriginId
	 * 				Client origin ID
	 * 
	 * @param clientOriginName
	 * 				Client origin name
	 */
	public GetClientOriginsResultItem(int clientOriginId, String clientOriginName) {
		super();
		this.clientOriginId = clientOriginId;
		this.clientOriginName = clientOriginName;
	}

	public int getClientOriginId() {
		return clientOriginId;
	}

	public void setClientOriginId(int clientOriginId) {
		this.clientOriginId = clientOriginId;
	}

	public String getClientOriginName() {
		return clientOriginName;
	}

	public void setClientOriginName(String clientOriginName) {
		this.clientOriginName = clientOriginName;
	}

	@Override
	public String toString() {
		return "GetClientOriginsResultItem [clientOriginId=" + clientOriginId + ", clientOriginName=" + clientOriginName
				+ "]";
	}

}
