package fr.ca.sa.nct.commons.services.json.audit;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response containing audit data
 * 
 * @author Nemanja Ignjatov
 *
 */
public class AuditMergedTransactionType implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int transactionId;

	private Map<String, String> transactionDescs;

	/**
	 * default constructor for Audit Merged Transaction Type
	 */
	public AuditMergedTransactionType() {
		super();
		this.transactionDescs = new HashMap<String, String>();
	}

	/**
	 * Audit Merged Transaction Type
	 * 
	 * @param transactionId
	 * 				Transaction ID
	 */
	public AuditMergedTransactionType(int transactionId) {
		super();
		this.transactionId = transactionId;
		this.transactionDescs = new HashMap<String, String>();
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Map<String, String> getTransactionDescs() {
		return transactionDescs;
	}

	public void setTransactionDescs(Map<String, String> transactionDescs) {
		this.transactionDescs = transactionDescs;
	}

	@Override
	public String toString() {
		return "AuditMergedTransactionType [transactionId=" + transactionId + ", transactionDescs=" + transactionDescs
				+ "]";
	}

}
