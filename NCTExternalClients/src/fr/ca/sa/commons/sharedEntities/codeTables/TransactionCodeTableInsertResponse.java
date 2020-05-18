package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class TransactionCodeTableInsertResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int transactionCode;
	private String transactionNameL1;
	private String transactionNameL2;
	private boolean active;

	/**
	 * default constructor for Transaction CodeTable Insert Response
	 */
	public TransactionCodeTableInsertResponse() {
		super();
	}

	/**
	 * Transaction CodeTable Insert Response
	 * 
	 * @param transactionCode
	 * 				Transaction code
	 * 
	 * @param transactionNameL1
	 * 				Transaction name in first language
	 * 
	 * @param transactionNameL2
	 * 				Transaction name in second language
	 * 
	 * @param active
	 * 				If it's active
	 */
	public TransactionCodeTableInsertResponse(int transactionCode, String transactionNameL1, String transactionNameL2,
			boolean active) {
		super();
		this.transactionCode = transactionCode;
		this.transactionNameL1 = transactionNameL1;
		this.transactionNameL2 = transactionNameL2;
		this.active = active;
	}

	public int getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(int transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getTransactionNameL1() {
		return transactionNameL1;
	}

	public void setTransactionNameL1(String transactionNameL1) {
		this.transactionNameL1 = transactionNameL1;
	}

	public String getTransactionNameL2() {
		return transactionNameL2;
	}

	public void setTransactionNameL2(String transactionNameL2) {
		this.transactionNameL2 = transactionNameL2;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "TransactionCodeTableInsertResponse [transactionCode=" + transactionCode + ", transactionNameL1="
				+ transactionNameL1 + ", transactionNameL2=" + transactionNameL2 + ", active=" + active + "]";
	}

}
