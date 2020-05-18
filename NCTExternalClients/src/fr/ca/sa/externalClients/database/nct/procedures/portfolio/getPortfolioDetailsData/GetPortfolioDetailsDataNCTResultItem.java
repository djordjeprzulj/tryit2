package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioDetailsData;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.Client;

/**
 * 
 * Get portfolio data single item
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetPortfolioDetailsDataNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer rowId;
	
	private Client client;
	
	/**
	 * default constructor for Get Portfolio Details Data NCT Result Item
	 */
	public GetPortfolioDetailsDataNCTResultItem() {
		super();
	}

	/**
	 * Get Portfolio Details Data NCT Result Item
	 * 
	 * @param rowId
	 * 				Row ID
	 * 
	 * @param client
	 * 				Client
	 * 
	 */
	public GetPortfolioDetailsDataNCTResultItem(Integer rowId, Client client) {
		super();
		this.rowId = rowId;
		this.client = client;
	}

	public Integer getRowId() {
		return rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "GetPortfolioDetailsDataNCTResultItem [rowId=" + rowId + ", client=" + client + "]";
	}
}
