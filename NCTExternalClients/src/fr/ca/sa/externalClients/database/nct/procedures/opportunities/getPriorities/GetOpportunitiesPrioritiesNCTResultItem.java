package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getPriorities;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Wrapper for returning single item of opportunity priority in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunitiesPrioritiesNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int priorityId;
	private String priorityName;

	/**
	 * default constructor for Get Opportunities Priorities NCT Result Item
	 */
	public GetOpportunitiesPrioritiesNCTResultItem() {
		super();
	}

	/**
	 * Get Opportunities Priorities NCT Result Item
	 * 
	 * @param priorityId
	 * 				Priority ID
	 * 
	 * @param priorityName
	 * 				Priority name
	 */
	public GetOpportunitiesPrioritiesNCTResultItem(int priorityId, String priorityName) {
		super();
		this.priorityId = priorityId;
		this.priorityName = priorityName;
	}

	public int getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	@Override
	public String toString() {
		return "GetOpportunitiesPrioritiesNCTResultItem [priorityId=" + priorityId + ", priorityName=" + priorityName
				+ "]";
	}

}
