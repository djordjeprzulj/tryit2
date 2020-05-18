package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioDetailsData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Portfolio data details result list
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetPortfolioDetailsDataNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetPortfolioDetailsDataNCTResultItem> portfolioClients;

	/**
	 * default constructor for Get Portfolio Details Data NCT Result List
	 */
	public GetPortfolioDetailsDataNCTResultList() {
		super();
		this.portfolioClients = new ArrayList<>();
	}

	/**
	 * Get Portfolio Details Data NCT Result List
	 * 
	 * @param portfolioClients
	 * 				Portfolio clients
	 */
	public GetPortfolioDetailsDataNCTResultList(List<GetPortfolioDetailsDataNCTResultItem> portfolioClients) {
		super();
		this.portfolioClients = portfolioClients;
	}

	public List<GetPortfolioDetailsDataNCTResultItem> getPortfolioClients() {
		return portfolioClients;
	}

	public void setPortfolioClients(List<GetPortfolioDetailsDataNCTResultItem> portfolioClients) {
		this.portfolioClients = portfolioClients;
	}

	@Override
	public String toString() {
		return "GetPortfolioDetailsDataNCTResultList [portfolioClients=" + portfolioClients + "]";
	}

}
