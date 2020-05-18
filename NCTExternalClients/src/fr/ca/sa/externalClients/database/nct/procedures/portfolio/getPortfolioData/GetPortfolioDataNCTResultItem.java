package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioData;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.Portfolio;

/**
 * 
 * Wrapper for returning single item of portfolio in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetPortfolioDataNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	protected Portfolio portfolio;
	
	/**
	 * default constructor for Get Portfolio Data NCT Result Item
	 */
	public GetPortfolioDataNCTResultItem() {
		super();
	}

	/**
	 * Get Portfolio Data NCT Result Item
	 * 
	 * 
	 * @param portfolio
	 * 				Portfolio 
	 */
	public GetPortfolioDataNCTResultItem(Portfolio portfolio) {
		super();
		this.portfolio = portfolio;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public String toString() {
		return "GetPortfolioDataNCTResultItem [portfolio=" + portfolio + "]";
	}

}
