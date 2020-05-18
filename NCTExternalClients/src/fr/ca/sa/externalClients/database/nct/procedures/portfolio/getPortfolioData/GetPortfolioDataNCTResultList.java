package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * List of fetched portfolios from DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetPortfolioDataNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetPortfolioDataNCTResultItem> portfolios;

	/**
	 * default constructor for Get Portfolio Data NCT Result List
	 */
	public GetPortfolioDataNCTResultList() {
		super();
		this.portfolios = new ArrayList<GetPortfolioDataNCTResultItem>();
	}

	public List<GetPortfolioDataNCTResultItem> getPortfolios() {
		return portfolios;
	}

	public void setPortfolios(List<GetPortfolioDataNCTResultItem> portfolios) {
		this.portfolios = portfolios;
	}

	@Override
	public String toString() {
		return "GetPortfolioDataNCTResultList [portfolios=" + portfolios + "]";
	}

}
