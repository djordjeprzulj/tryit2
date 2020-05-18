package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getCurrencies;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Single client need data holder retrieved from database
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetCurrenciesNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int currencyId;
	private String currencyName;

	/**
	 * default constructor for Get Currencies NCT Result Item
	 */
	public GetCurrenciesNCTResultItem() {
		super();
	}

	/**
	 * Get Currencies NCT Result Item
	 * 
	 * @param currencyId
	 * 				Currency ID
	 * 
	 * @param currencyName
	 * 				Currency name
	 */
	public GetCurrenciesNCTResultItem(int currencyId, String currencyName) {
		super();
		this.currencyId = currencyId;
		this.currencyName = currencyName;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	@Override
	public String toString() {
		return "GetCurrenciesNCTResultItem [currencyId=" + currencyId + ", currencyName=" + currencyName + "]";
	}

}
