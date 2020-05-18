package fr.ca.sa.nct.commons.services.json.portfolioManagement;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetPortfoliosResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<PortfolioDetailsDataContainer> portfolios;
	private int totalCount;

	/**
	 * default constructor for Get Portfolios Response
	 */
	public GetPortfoliosResponse() {
		super();
	}

	/**
	 * Get Portfolios Response
	 * 
	 * @param portfolios
	 * 				List of portfolios 
	 * 
	 * @param totalCount
	 * 				Total count
	 */
	public GetPortfoliosResponse(List<PortfolioDetailsDataContainer> portfolios, int totalCount) {
		super();
		this.portfolios = portfolios;
		this.totalCount = totalCount;
	}

	public List<PortfolioDetailsDataContainer> getPortfolios() {
		return portfolios;
	}

	public void setPortfolios(List<PortfolioDetailsDataContainer> portfolios) {
		this.portfolios = portfolios;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
