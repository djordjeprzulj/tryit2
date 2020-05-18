package fr.ca.sa.externalClients.database.nct.procedures.audit.getTransationType;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Holder client agenda elements, single item
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetAuditTransactionTypeItem implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer transactionId;

	private String transactionDesc;

	/**
	 * default constructor for Get Audit Transaction Type Item
	 */
	public GetAuditTransactionTypeItem() {
		super();
	}

	/**
	 * Get Audit Transaction Type Item
	 * 
	 * @param transactionId
	 * 				Transaction ID
	 * 
	 * @param transactionDesc
	 * 				Transaction description
	 */
	public GetAuditTransactionTypeItem(Integer transactionId, String transactionDesc) {
		super();
		this.transactionId = transactionId;
		this.transactionDesc = transactionDesc;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionDesc() {
		return transactionDesc;
	}

	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}

	@Override
	public String toString() {
		return "GetAuditTransactionTypeItem [transactionId=" + transactionId + ", transactionDesc=" + transactionDesc
				+ "]";
	}

}
