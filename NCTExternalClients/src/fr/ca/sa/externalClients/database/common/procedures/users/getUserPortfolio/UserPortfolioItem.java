package fr.ca.sa.externalClients.database.common.procedures.users.getUserPortfolio;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Single portfolio data holder retrieved from database
 * 
 * @author Sasa Radovanovic
 *
 */
public class UserPortfolioItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String portfolioCode;

	private String portfolioName;

	private int portfolioId;

	/**
	 * default constructor for User Portfolio Item
	 */
	public UserPortfolioItem() {
		super();
	}

	/**
	 * User Portfolio Item
	 * 
	 * @param portfolioCode
	 * 				Portfolio code
	 * 
	 * @param portfolioName
	 * 				Portfolio name
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 */
	public UserPortfolioItem(String portfolioCode, String portfolioName, int portfolioId) {
		super();
		this.portfolioCode = portfolioCode;
		this.portfolioName = portfolioName;
		this.portfolioId = portfolioId;
	}

	public String getPortfolioCode() {
		return portfolioCode;
	}

	public void setPortfolioCode(String portfolioCode) {
		this.portfolioCode = portfolioCode;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}

	@Override
	public String toString() {
		return "UserPortfolioItem [portfolioCode=" + portfolioCode + ", portfolioName=" + portfolioName
				+ ", portfolioId=" + portfolioId + "]";
	}

}
