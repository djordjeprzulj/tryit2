package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class OpportunitiesCancellationReasonsTranslatableItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int reasonId;
	private Map<String, String> reasonNames;

	/**
	 * default constructor for Opportunities Cancellation Reasons Translatable Item
	 */
	public OpportunitiesCancellationReasonsTranslatableItem() {
		super();
	}

	/**
	 * Opportunities Cancellation Reasons Translatable Item
	 * 
	 * @param reasonId
	 * 				Reason ID
	 * 
	 * @param reasonNames
	 * 				Reason names
	 */
	public OpportunitiesCancellationReasonsTranslatableItem(int reasonId, Map<String, String> reasonNames) {
		super();
		this.reasonId = reasonId;
		this.reasonNames = reasonNames;
	}

	public int getReasonId() {
		return reasonId;
	}

	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}

	public Map<String, String> getReasonNames() {
		return reasonNames;
	}

	public void setReasonNames(Map<String, String> reasonNames) {
		this.reasonNames = reasonNames;
	}

}
