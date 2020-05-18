package fr.ca.sa.nct.commons.services.json.audit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response containing audit data
 * 
 * @author Nemanja Ignjatov
 *
 */
public class AuditMergedApplicationType implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int applicationId;

	private Map<String, String> applicationNames;

	private List<AuditMergedTransactionType> transactions;

	/**
	 * default constructor for Audit Merged Application Type
	 */
	public AuditMergedApplicationType() {
		super();
	}

	/**
	 * Audit Merged Application Type
	 * 
	 * @param applicationId
	 * 			Application ID
	 */
	public AuditMergedApplicationType(int applicationId) {
		super();
		this.applicationId = applicationId;
		this.applicationNames = new HashMap<String, String>();
		this.transactions = new ArrayList<AuditMergedTransactionType>();
	}

	/**
	 * Audit Merged Application Type
	 * 
	 * @param applicationId
	 * 				Application ID
	 * 
	 * @param transactions
	 * 				Transactions
	 */
	public AuditMergedApplicationType(int applicationId, List<AuditMergedTransactionType> transactions) {
		super();
		this.applicationId = applicationId;
		this.applicationNames = new HashMap<String, String>();
		this.transactions = transactions;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public Map<String, String> getApplicationNames() {
		return applicationNames;
	}

	public void setApplicationNames(Map<String, String> applicationNames) {
		this.applicationNames = applicationNames;
	}

	public List<AuditMergedTransactionType> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<AuditMergedTransactionType> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "AuditMergedApplicationType [applicationId=" + applicationId + ", applicationNames=" + applicationNames
				+ ", transactions=" + transactions + "]";
	}

}
