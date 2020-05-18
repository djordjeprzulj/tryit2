package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class SetCodeTableReasonTreatedRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer reasonId;
	private int oppSubCategoryId;
	private String nameL1;
	private String nameL2;
	private Integer reasonOrder;
	private boolean active;

	/**
	 * default constructor for Set Code Table Reason Treated Request
	 */
	public SetCodeTableReasonTreatedRequest() {
		super();
	}

	/**
	 * Set Code Table Reason Treated Request
	 * 
	 * @param reasonId
	 * 				Reason ID
	 * 
	 * @param oppSubCategoryId
	 * 				Opportunity category ID
	 * 
	 * @param nameL1
	 * 				Name in first language
	 * 
	 * @param nameL2
	 * 				Name in second language
	 * 
	 * @param reasonOrder
	 * 				Reason order
	 * 
	 * @param active
	 * 				Activity
	 */
	public SetCodeTableReasonTreatedRequest(Integer reasonId, int oppSubCategoryId, String nameL1, String nameL2,
			Integer reasonOrder, boolean active) {
		super();
		this.reasonId = reasonId;
		this.oppSubCategoryId = oppSubCategoryId;
		this.nameL1 = nameL1;
		this.nameL2 = nameL2;
		this.reasonOrder = reasonOrder;
		this.active = active;
	}

	/**
	 * Set Code Table Reason Treated Request
	 * 
	 * @param update
	 * 				Update request
	 */
	public SetCodeTableReasonTreatedRequest(TreatedReasonCodeTableUpdateRequest update) {
		super();
		this.reasonId = update.getReasonId();
		this.oppSubCategoryId = update.getOppSubCategoryId();
		this.nameL1 = update.getNameL1();
		this.nameL2 = update.getNameL2();
		this.reasonOrder = update.getReasonOrder();
		this.active = update.isActive();
	}

	/**
	 * Set Code Table Reason Treated Request
	 * 
	 * @param insert
	 * 				Insert request
	 */
	public SetCodeTableReasonTreatedRequest(TreatedReasonCodeTableInsertRequest insert) {
		super();
		this.reasonId = null;
		this.oppSubCategoryId = insert.getOppSubCategoryId();
		this.nameL1 = insert.getNameL1();
		this.nameL2 = insert.getNameL2();
		this.reasonOrder = insert.getReasonOrder();
		this.active = insert.isActive();
	}

	public Integer getReasonId() {
		return reasonId;
	}

	public void setReasonId(Integer reasonId) {
		this.reasonId = reasonId;
	}

	public int getOppSubCategoryId() {
		return oppSubCategoryId;
	}

	public void setOppSubCategoryId(int oppSubCategoryId) {
		this.oppSubCategoryId = oppSubCategoryId;
	}

	public String getNameL1() {
		return nameL1;
	}

	public void setNameL1(String nameL1) {
		this.nameL1 = nameL1;
	}

	public String getNameL2() {
		return nameL2;
	}

	public void setNameL2(String nameL2) {
		this.nameL2 = nameL2;
	}

	public Integer getReasonOrder() {
		return reasonOrder;
	}

	public void setReasonOrder(Integer reasonOrder) {
		this.reasonOrder = reasonOrder;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "SetCodeTableReasonTreatedRequest [reasonId=" + reasonId + ", oppSubCategoryId=" + oppSubCategoryId
				+ ", nameL1=" + nameL1 + ", nameL2=" + nameL2 + ", reasonOrder=" + reasonOrder + ", active="
				+ active + "]";
	}

}
