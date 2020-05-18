package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getClientDataByContactId;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Milos Topalovic
 *
 */
public class GetClientDataByContactIdNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer clientId;
	private Integer clientEntityId;
	private Integer portfolioId;
	private String cl;
	private Integer contactTypeId;

	/**
	 * default constructor for Get Client Data By Contact Id NCT Result Item
	 */
	public GetClientDataByContactIdNCTResultItem() {
		super();
	}

	/**
	 * Get Client Data By Contact Id NCT Result Item
	 * 
	 * @param clientId
	 * 			Client ID
	 * 
	 * @param clientEntityId
	 * 			Client entity ID
	 * 
	 * @param portfolioId
	 * 			Portfolio ID
	 * 
	 * @param cl
	 * 			Client
	 * 
	 * @param contactTypeId
	 * 			Contact type ID
	 */
	public GetClientDataByContactIdNCTResultItem(Integer clientId, Integer clientEntityId, Integer portfolioId, String cl,
			Integer contactTypeId) {
		super();
		this.clientId = clientId;
		this.clientEntityId = clientEntityId;
		this.portfolioId = portfolioId;
		this.cl = cl;
		this.contactTypeId = contactTypeId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getClientEntityId() {
		return clientEntityId;
	}

	public void setClientEntityId(Integer clientEntityId) {
		this.clientEntityId = clientEntityId;
	}

	public Integer getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getCl() {
		return cl;
	}

	public void setCl(String cl) {
		this.cl = cl;
	}

	public Integer getContactTypeId() {
		return contactTypeId;
	}

	public void setContactTypeId(Integer contactTypeId) {
		this.contactTypeId = contactTypeId;
	}

	@Override
	public String toString() {
		return "GetClientDataByTaskIdNCTResultItem [clientId=" + clientId + ", clientEntityId=" + clientEntityId
				+ ", portfolioId=" + portfolioId + ", cl=" + cl + ", contactTypeId=" + contactTypeId + "]";
	}

}
