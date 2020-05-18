package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioClientFilter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanj Ignjatov
 *
 */
public class GetPortfolioClientFilterNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private List<GetPortfolioClientFilterNCTResultItem> portfolioClientFilter;

	/**
	 * default constructor for Get Portfolio Client Filter NCT Result List
	 */
	public GetPortfolioClientFilterNCTResultList() {
		super();
		this.portfolioClientFilter=new ArrayList<GetPortfolioClientFilterNCTResultItem>();
	}

	/**
	 * Get Portfolio Client Filter NCT Result List
	 * 
	 * @param portfolioClientFilter
	 * 			Portfolio client filter
	 */
	public GetPortfolioClientFilterNCTResultList(List<GetPortfolioClientFilterNCTResultItem> portfolioClientFilter) {
		super();
		this.portfolioClientFilter = portfolioClientFilter;
	}

	public List<GetPortfolioClientFilterNCTResultItem> getPortfolioClientFilter() {
		return portfolioClientFilter;
	}

	public void setPortfolioClientFilter(List<GetPortfolioClientFilterNCTResultItem> portfolioClientFilter) {
		this.portfolioClientFilter = portfolioClientFilter;
	}

	@Override
	public String toString() {
		return "GetPortfolioClientFilterNCTResultList [portfolioClientFilter=" + portfolioClientFilter + "]";
	}
	
	
	
}
