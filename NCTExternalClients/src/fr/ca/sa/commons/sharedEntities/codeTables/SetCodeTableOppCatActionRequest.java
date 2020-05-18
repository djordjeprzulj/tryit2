package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetCodeTableOppCatActionRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer opportunityCategoryId;
	private Integer cancel;
	private Integer treatOnOppList;
	private Integer treatOnQCR;
	private Integer expire;

	/**
	 * default constructor for Set Code Table Opportunity Category Action Request
	 */
	public SetCodeTableOppCatActionRequest() {
		super();
	}

	/**
	 * Set Code Table Opportunity Category Action Request
	 * 
	 * @param opportunityCategoryId
	 * 				Opportunity category ID
	 * 
	 * @param cancel
	 * 				Cancellation
	 * 
	 * @param treatOnOppList
	 * 				Treat on opportunity list
	 * 
	 * @param treatOnQCR
	 * 				Treat on QCR
	 * 
	 * @param expire
	 * 				Expiration
	 */
	public SetCodeTableOppCatActionRequest(Integer opportunityCategoryId, Integer cancel, Integer treatOnOppList,
			Integer treatOnQCR, Integer expire) {
		super();
		this.opportunityCategoryId = opportunityCategoryId;
		this.cancel = cancel;
		this.treatOnOppList = treatOnOppList;
		this.treatOnQCR = treatOnQCR;
		this.expire = expire;
	}

	public Integer getOpportunityCategoryId() {
		return opportunityCategoryId;
	}

	public void setOpportunityCategoryId(Integer opportunityCategoryId) {
		this.opportunityCategoryId = opportunityCategoryId;
	}

	public Integer getCancel() {
		return cancel;
	}

	public void setCancel(Integer cancel) {
		this.cancel = cancel;
	}

	public Integer getTreatOnOppList() {
		return treatOnOppList;
	}

	public void setTreatOnOppList(Integer treatOnOppList) {
		this.treatOnOppList = treatOnOppList;
	}

	public Integer getTreatOnQCR() {
		return treatOnQCR;
	}

	public void setTreatOnQCR(Integer treatOnQCR) {
		this.treatOnQCR = treatOnQCR;
	}

	public Integer getExpire() {
		return expire;
	}

	public void setExpire(Integer expire) {
		this.expire = expire;
	}

	@Override
	public String toString() {
		return "SetCodeTableOppCatActionRequest [opportunityCategoryId=" + opportunityCategoryId + ", cancel=" + cancel
				+ ", treatOnOppList=" + treatOnOppList + ", treatOnQCR=" + treatOnQCR + ", expire=" + expire + "]";
	}

	
}
