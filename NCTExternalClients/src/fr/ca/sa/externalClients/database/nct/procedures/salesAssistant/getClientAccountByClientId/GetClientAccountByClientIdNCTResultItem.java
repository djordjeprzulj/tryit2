package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientAccountByClientId;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Account number data holder retrieved from database
 * 
 * @author Jelena Raca
 *
 */
public class GetClientAccountByClientIdNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String accountNb;

	/**
	 * default constructor for Get Client Account By Client Id NCT Result Item
	 */
	public GetClientAccountByClientIdNCTResultItem() {
		super();
	}

	/**
	 * Get Client Account By Client Id NCT Result Item
	 * 
	 * @param accountNb
	 * 				Account Number
	 */
	public GetClientAccountByClientIdNCTResultItem(String accountNb) {
		super();
		this.accountNb = accountNb;
	}

	public String getAccountNb() {
		return accountNb;
	}

	public void setAccountNb(String accountNb) {
		this.accountNb = accountNb;
	}

	@Override
	public String toString() {
		return "GetClientAccountByClientIdNCTResultItem [accountNb=" + accountNb + "]";
	}

}
