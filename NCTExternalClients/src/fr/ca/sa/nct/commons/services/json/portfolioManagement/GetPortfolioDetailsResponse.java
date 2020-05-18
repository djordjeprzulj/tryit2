package fr.ca.sa.nct.commons.services.json.portfolioManagement;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioClientsBySegments.GetPortfolioClientsBySegmetsNCTResultItem;
import fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioDetailsData.GetPortfolioDetailsDataNCTResultItem;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetPortfolioDetailsResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetPortfolioDetailsDataNCTResultItem> portfolioClients;
	private List<GetPortfolioClientsBySegmetsNCTResultItem> portfolioClientsBySegments;
	private int totalCount;
	private boolean exportAllowed;

	/**
	 * default constructor for Get Portfolio Details Response
	 */
	public GetPortfolioDetailsResponse() {
		super();
	}

	/**
	 * Get Portfolio Details Response
	 * 
	 * @param portfolioClients
	 *            Portfolio clients
	 * 
	 * @param portfolioClientsBySegments
	 *            Portfolio clients by segments
	 * 
	 * @param totalCount
	 *            Total count
	 *            
	 * @param exportAllowed 
	 * 			If export of portfolio details is allowed  
	 */
	public GetPortfolioDetailsResponse(List<GetPortfolioDetailsDataNCTResultItem> portfolioClients,
			List<GetPortfolioClientsBySegmetsNCTResultItem> portfolioClientsBySegments, int totalCount,
			boolean exportAllowed) {
		super();
		this.portfolioClients = portfolioClients;
		this.portfolioClientsBySegments = portfolioClientsBySegments;
		this.totalCount = totalCount;
		this.exportAllowed = exportAllowed;
	}

	public List<GetPortfolioDetailsDataNCTResultItem> getPortfolioClients() {
		return portfolioClients;
	}

	public void setPortfolioClients(List<GetPortfolioDetailsDataNCTResultItem> portfolioClients) {
		this.portfolioClients = portfolioClients;
	}

	public List<GetPortfolioClientsBySegmetsNCTResultItem> getPortfolioClientsBySegments() {
		return portfolioClientsBySegments;
	}

	public void setPortfolioClientsBySegments(
			List<GetPortfolioClientsBySegmetsNCTResultItem> portfolioClientsBySegments) {
		this.portfolioClientsBySegments = portfolioClientsBySegments;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public boolean isExportAllowed() {
		return exportAllowed;
	}

	public void setExportAllowed(boolean exportAllowed) {
		this.exportAllowed = exportAllowed;
	}

	@Override
	public String toString() {
		return "GetPortfolioDetailsResponse [portfolioClients=" + portfolioClients + ", portfolioClientsBySegments="
				+ portfolioClientsBySegments + ", totalCount=" + totalCount + "]";
	}

}
