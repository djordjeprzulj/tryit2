package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class TreatedReasonCodeTableInsertResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int reasonId;
	private int oppSubCategoryId;
	private String nameL1;
	private String nameL2;
	private Integer reasonOrder;
	private boolean active;

	/**
	 * default constructor for Treated Reason CodeTable Insert Response
	 */
	public TreatedReasonCodeTableInsertResponse() {
		super();
	}

	/**
	 * Treated Reason CodeTable Insert Response
	 * 
	 * @param reasonId
	 * 				Reason ID
	 * 
	 * @param oppSubCategoryId
	 * 				Opportunity sub category ID
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
	 * 				If it's active
	 */
	public TreatedReasonCodeTableInsertResponse(int reasonId, int oppSubCategoryId, String nameL1, String nameL2,
			Integer reasonOrder, boolean active) {
		super();
		this.reasonId = reasonId;
		this.oppSubCategoryId = oppSubCategoryId;
		this.nameL1 = nameL1;
		this.nameL2 = nameL2;
		this.reasonOrder = reasonOrder;
		this.active = active;
	}

	public int getReasonId() {
		return reasonId;
	}

	public void setReasonId(int reasonId) {
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
		return "TreatedReasonCodeTableInsertResponse [reasonId=" + reasonId + ", oppSubCategoryId=" + oppSubCategoryId
				+ ", nameL1=" + nameL1 + ", nameL2=" + nameL2 + ", reasonOrder=" + reasonOrder + ", active="
				+ active + "]";
	}

}
