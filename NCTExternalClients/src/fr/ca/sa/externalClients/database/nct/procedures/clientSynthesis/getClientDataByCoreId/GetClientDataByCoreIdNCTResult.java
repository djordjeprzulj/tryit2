package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getClientDataByCoreId;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning client data by core id DB result
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientDataByCoreIdNCTResult implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int clientId;
	private String cL;
	private int clientEntityId;
	private int portfolioId;

	/**
	 * default constructor for Get Client Data By Core ID NCT Result
	 */
	public GetClientDataByCoreIdNCTResult() {
		super();
	}

	/**
	 * Get Client Data By Core ID NCT Result
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param cL
	 * 				Client
	 * 
	 * @param clientEntityId
	 * 				Client entity ID
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 */
	public GetClientDataByCoreIdNCTResult(int clientId, String cL, int clientEntityId, int portfolioId) {
		super();
		this.clientId = clientId;
		this.cL = cL;
		this.clientEntityId = clientEntityId;
		this.portfolioId = portfolioId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	/**
	 * Get CL
	 * 
	 * @return cL
	 * 				Returns CL
	 */
	public String getcL() {
		return cL;
	}

	/**
	 * Set CL
	 * 
	 * @param cL
	 * 			CL
	 */
	public void setcL(String cL) {
		this.cL = cL;
	}

	public int getClientEntityId() {
		return clientEntityId;
	}

	public void setClientEntityId(int clientEntityId) {
		this.clientEntityId = clientEntityId;
	}

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}

	@Override
	public String toString() {
		return "GetClientDataByCoreIdNCTResult [clientId=" + clientId + ", cL=" + cL + ", clientEntityId="
				+ clientEntityId + ", portfolioId=" + portfolioId + "]";
	}

}
