package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioClientsBySegments;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Result list for Portoflio clients by segment
 * 
 * @author Stefan Djokic
 *
 */
public class GetPortfolioClientsBySegmetsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetPortfolioClientsBySegmetsNCTResultItem> portfolioClientsBySegments;

	/**
	 * default constructor for Get Portfolio Clients By Segmets NCT Result List
	 */
	public GetPortfolioClientsBySegmetsNCTResultList() {
		super();
		this.portfolioClientsBySegments = new ArrayList<GetPortfolioClientsBySegmetsNCTResultItem>();
	}

	public List<GetPortfolioClientsBySegmetsNCTResultItem> getPortfolioClientBySegments() {
		return portfolioClientsBySegments;
	}

	public void setPortfolioClientBySegments(
			List<GetPortfolioClientsBySegmetsNCTResultItem> portfolioClientBySegments) {
		this.portfolioClientsBySegments = portfolioClientBySegments;
	}

	@Override
	public String toString() {
		return "GetPortfolioClientsBySegmetsNCTResultList [portfolioClientsBySegments=" + portfolioClientsBySegments
				+ "]";
	}

}
