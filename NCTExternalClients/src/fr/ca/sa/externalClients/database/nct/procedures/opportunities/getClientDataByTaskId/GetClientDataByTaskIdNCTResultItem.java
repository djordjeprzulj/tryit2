package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getClientDataByTaskId;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientDataByTaskIdNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer clientId;
	private Integer clientEntityId;
	private Integer portfolioId;
	private String cl;
	private Integer opportuntyId;

	/**
	 * default constructor for Get Client Data By Task Id NCT Result Item
	 */
	public GetClientDataByTaskIdNCTResultItem() {
		super();
	}

	/**
	 * Get Client Data By Task Id NCT Result Item
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param clientEntityId
	 * 				Client entity ID
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 * 
	 * @param cl
	 * 				Client
	 * 
	 * @param opportuntyId
	 * 				Opportunity ID
	 */
	public GetClientDataByTaskIdNCTResultItem(Integer clientId, Integer clientEntityId, Integer portfolioId, String cl,
			Integer opportuntyId) {
		super();
		this.clientId = clientId;
		this.clientEntityId = clientEntityId;
		this.portfolioId = portfolioId;
		this.cl = cl;
		this.opportuntyId = opportuntyId;
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

	public Integer getOpportuntyId() {
		return opportuntyId;
	}

	public void setOpportuntyId(Integer opportuntyId) {
		this.opportuntyId = opportuntyId;
	}

	@Override
	public String toString() {
		return "GetClientDataByTaskIdNCTResultItem [clientId=" + clientId + ", clientEntityId=" + clientEntityId
				+ ", portfolioId=" + portfolioId + ", cl=" + cl + ", opportuntyId=" + opportuntyId + "]";
	}

}
