package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getCurrencies;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for needs list retrieved from database. Used in pair
 * with @GetClientNeedsCategoriesNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetCurrenciesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetCurrenciesNCTResultItem> currencies;

	/**
	 * default constructor for Get Currencies NCT Result List
	 */
	public GetCurrenciesNCTResultList() {
		this.currencies = new ArrayList<GetCurrenciesNCTResultItem>();
	}

	/**
	 * Get Currencies NCT Result List
	 * 
	 * @param currencies
	 * 					Currencies
	 */
	public GetCurrenciesNCTResultList(List<GetCurrenciesNCTResultItem> currencies) {
		super();
		this.currencies = currencies;
	}

	public List<GetCurrenciesNCTResultItem> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<GetCurrenciesNCTResultItem> currencies) {
		this.currencies = currencies;
	}

	@Override
	public String toString() {
		return "GetClientNeedsCategoriesNCTResultList [currencies=" + currencies + "]";
	}

}
