package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientAccountByClientId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for client account list retrieved from database. Used in pair
 * 
 * with @GetClientAccountByClientIdNCTResultItem
 * 
 * @author Jelena Raca
 *
 */
public class GetClientAccountByClientIdNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetClientAccountByClientIdNCTResultItem> clientAccounts;

	/**
	 * default constructor for Get Client Account By Client Id NCT Result List
	 */
	public GetClientAccountByClientIdNCTResultList() {
		this.clientAccounts = new ArrayList<GetClientAccountByClientIdNCTResultItem>();
	}

	/**
	 * Get Client Account By Client Id NCT Result List
	 * 
	 * @param clientAccounts
	 * 				Client Accounts
	 */
	public GetClientAccountByClientIdNCTResultList(List<GetClientAccountByClientIdNCTResultItem> clientAccounts) {
		super();
		this.clientAccounts = clientAccounts;
	}

	public List<GetClientAccountByClientIdNCTResultItem> getClientAccounts() {
		return clientAccounts;
	}

	public void setClientAccounts(List<GetClientAccountByClientIdNCTResultItem> clientAccounts) {
		this.clientAccounts = clientAccounts;
	}

	@Override
	public String toString() {
		return "GetClientAccountByClientIdNCTResultList [clientAccounts=" + clientAccounts + "]";
	}
}