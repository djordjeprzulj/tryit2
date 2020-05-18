package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getClientCodeTypeByClientId;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Jelena Raca
 *
 */
public class GetClientCodeTypeByClientIdNCTResultItem implements StoreProcedureResult, Serializable {
	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private String clientCodeType;

	/**
	 * default constructor for Get Client Code Type By Client Id NCT Result Item
	 */
	public GetClientCodeTypeByClientIdNCTResultItem() {
		super();
	}

	/**
	 * Get Client Code Type By Client Id NCT Result Item
	 * 
	 * @param clientCodeType
	 * 			Client code type
	 */
	public GetClientCodeTypeByClientIdNCTResultItem(String clientCodeType) {
		super();
		this.clientCodeType = clientCodeType;
	}

	public String getClientCodeType() {
		return clientCodeType;
	}

	public void setClientCodeType(String clientCodeType) {
		this.clientCodeType = clientCodeType;
	}

	@Override
	public String toString() {
		return "GetClientCodeTypeByClientIdNCTResultItem [clientCodeType=" + clientCodeType + "]";
	}

}
