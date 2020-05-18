package fr.ca.sa.externalClients.database.nct.procedures.audit.getTransationType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Holder audit transactions item list
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetAuditTransactionTypeList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetAuditTransactionTypeItem> transactions;

	/**
	 * default constructor for Get Audit Transaction Type List
	 */
	public GetAuditTransactionTypeList() {
		super();
		this.transactions = new ArrayList<>();
	}

	/**
	 * Get Audit Transaction Type List
	 * 
	 * @param transactions
	 * 				Transaction
	 */
	public GetAuditTransactionTypeList(List<GetAuditTransactionTypeItem> transactions) {
		super();
		this.transactions = transactions;
	}

	public List<GetAuditTransactionTypeItem> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<GetAuditTransactionTypeItem> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "GetAuditTransactionTypeList [transactions=" + transactions + "]";
	}

}
