package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * List of fetched portfolio types from DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetPortfolioTypesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetPortfolioTypesNCTResultItem> types;

	/**
	 * default constructor for Get Portfolio Types NCT Result List
	 */
	public GetPortfolioTypesNCTResultList() {
		super();
		this.types = new ArrayList<GetPortfolioTypesNCTResultItem>();
	}

	public List<GetPortfolioTypesNCTResultItem> getTypes() {
		return types;
	}

	public void setTypes(List<GetPortfolioTypesNCTResultItem> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "GetPortfolioTypesNCTResultList [types=" + types + "]";
	}

}
