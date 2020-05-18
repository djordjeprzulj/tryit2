package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetCodeTableTransactionRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer transactionCode;
	private String transactionNameL1;
	private String transactionNameL2;
	private boolean active;

	/**
	 * default constructor for Set Code Table Transaction Request
	 */
	public SetCodeTableTransactionRequest() {
		super();
	}

	/**
	 * Set Code Table Transaction Request
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
	 * 				Activity
	 */
	public SetCodeTableTransactionRequest(Integer transactionCode, String transactionNameL1, String transactionNameL2,
			boolean active) {
		super();
		this.transactionCode = transactionCode;
		this.transactionNameL1 = transactionNameL1;
		this.transactionNameL2 = transactionNameL2;
		this.active = active;
	}

	/**
	 * Set Code Table Transaction Request
	 * 
	 * @param update
	 * 				Update request
	 */
	public SetCodeTableTransactionRequest(TransactionCodeTableUpdateRequest update) {
		super();
		this.transactionCode = update.getTransactionCode();
		this.transactionNameL1 = update.getTransactionNameL1();
		this.transactionNameL2 = update.getTransactionNameL2();
		this.active = update.isActive();
	}

	/**
	 * Set Code Table Transaction Request
	 * 
	 * @param insert
	 * 				Insert request
	 */
	public SetCodeTableTransactionRequest(TransactionCodeTableInsertRequest insert) {
		super();
		this.transactionCode = null;
		this.transactionNameL1 = insert.getTransactionNameL1();
		this.transactionNameL2 = insert.getTransactionNameL2();
		this.active = insert.isActive();
	}

	public Integer getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(Integer transactionCode) {
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
		return "SetCodeTableTransApplicationRequest [transactionCode=" + transactionCode + ", transactionNameL1="
				+ transactionNameL1 + ", transactionNameL2=" + transactionNameL2 + ", active=" + active + "]";
	}

}
