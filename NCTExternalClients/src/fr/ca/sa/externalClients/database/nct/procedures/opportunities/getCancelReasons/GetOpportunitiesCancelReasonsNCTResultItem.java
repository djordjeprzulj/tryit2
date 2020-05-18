package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getCancelReasons;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Wrapper for returning single item of opportunity cancellation reason in JSON
 * response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunitiesCancelReasonsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int reasonId;
	private String reasonName;

	/**
	 * default constructor for Get Opportunities Cancel Reasons NCT Result Item
	 */
	public GetOpportunitiesCancelReasonsNCTResultItem() {
		super();
	}

	/**
	 * Get Opportunities Cancel Reasons NCT Result Item
	 * 
	 * @param reasonId
	 * 				Reason ID
	 * 
	 * @param reasonName
	 * 				Reason name
	 */
	public GetOpportunitiesCancelReasonsNCTResultItem(int reasonId, String reasonName) {
		super();
		this.reasonId = reasonId;
		this.reasonName = reasonName;
	}

	public int getReasonId() {
		return reasonId;
	}

	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}

	public String getReasonName() {
		return reasonName;
	}

	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}

	@Override
	public String toString() {
		return "GetOpportunitiesCancelReasonsNCTResultItem [reasonId=" + reasonId + ", reasonName=" + reasonName + "]";
	}

}
