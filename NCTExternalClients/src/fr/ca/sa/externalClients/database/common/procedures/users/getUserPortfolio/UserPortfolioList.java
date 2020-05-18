package fr.ca.sa.externalClients.database.common.procedures.users.getUserPortfolio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for user portfolio list retrieved from database. Used in pair
 * with @UserPortfolioItem
 * 
 * @author Sasa Radovanovic
 *
 */
public class UserPortfolioList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<UserPortfolioItem> userPortfolios;

	/**
	 * default constructor for User Portfolio List
	 */
	public UserPortfolioList() {
		super();
		userPortfolios = new ArrayList<>();
	}

	/**
	 * User Portfolio List
	 * 
	 * @param userPortfolios
	 * 				User portfolios list
	 */
	public UserPortfolioList(List<UserPortfolioItem> userPortfolios) {
		super();
		this.userPortfolios = userPortfolios;
	}

	public List<UserPortfolioItem> getUserPortfolios() {
		return userPortfolios;
	}

	public void setUserPortfolios(List<UserPortfolioItem> userPortfolios) {
		this.userPortfolios = userPortfolios;
	}

	@Override
	public String toString() {
		return "UserPortfolioList [userPortfolios=" + userPortfolios + "]";
	}

}
