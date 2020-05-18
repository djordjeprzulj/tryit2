package fr.ca.sa.externalClients.database.nct.procedures.portfolio.reassignProspectPortfolio;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning single reassigned prospect portfolio data
 * 
 * @author Stefan Djokic
 *
 */
public class ReassignProspectPortfolioNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int portfolioId;

	/**
	 * default constructor for Reassign Prospect Portfolio NCT Result Item
	 */
	public ReassignProspectPortfolioNCTResultItem() {
		super();
	}

	/**
	 * Reassign Prospect Portfolio NCT Result Item
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 */
	public ReassignProspectPortfolioNCTResultItem(int portfolioId) {
		super();
		this.portfolioId = portfolioId;
	}

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}

	@Override
	public String toString() {
		return "ReassignProspectPortfolioNCTResultItem [portfolioId=" + portfolioId + "]";
	}

}
