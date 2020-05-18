package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getGeneralClientCoreId;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning client core id DB result
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientCoreIdNCTResult implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private long clientIdCore;

	/**
	 * default constructor for Get Client Core ID NCT Result
	 */
	public GetClientCoreIdNCTResult() {
		super();
	}

	/**
	 * Get Client Core ID NCT Result
	 * 
	 * @param clientIdCore
	 * 				Client ID core
	 */
	public GetClientCoreIdNCTResult(long clientIdCore) {
		super();
		this.clientIdCore = clientIdCore;
	}

	public long getClientIdCore() {
		return clientIdCore;
	}

	public void setClientIdCore(long clientIdCore) {
		this.clientIdCore = clientIdCore;
	}

	@Override
	public String toString() {
		return "GetClientCoreIdNCTResult [clientIdCore=" + clientIdCore + "]";
	}

}
