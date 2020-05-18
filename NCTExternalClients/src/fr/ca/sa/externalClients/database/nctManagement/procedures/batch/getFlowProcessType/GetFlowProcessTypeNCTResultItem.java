package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowProcessType;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 *
 * Wrapper class for single result in result set from batch.spGetFlowProcessType
 * store procedure
 * 
 * @author Nemanja Ignjatov
 */
public class GetFlowProcessTypeNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int flowProcessTypeId;
	private String flowProcessTypeName;

	/**
	 * default constructor for Get Flow Process Type NCT Result Item
	 */
	public GetFlowProcessTypeNCTResultItem() {
		super();
	}

	/**
	 * Get Flow Process Type NCT Result Item
	 * 
	 * @param flowProcessTypeId
	 * 				Flow process type ID
	 * 
	 * @param flowProcessTypeName
	 * 				Flow process type name
	 */
	public GetFlowProcessTypeNCTResultItem(int flowProcessTypeId, String flowProcessTypeName) {
		super();
		this.flowProcessTypeId = flowProcessTypeId;
		this.flowProcessTypeName = flowProcessTypeName;
	}

	public int getFlowProcessTypeId() {
		return flowProcessTypeId;
	}

	public void setFlowProcessTypeId(int flowProcessTypeId) {
		this.flowProcessTypeId = flowProcessTypeId;
	}

	public String getFlowProcessTypeName() {
		return flowProcessTypeName;
	}

	public void setFlowProcessTypeName(String flowProcessTypeName) {
		this.flowProcessTypeName = flowProcessTypeName;
	}

	@Override
	public String toString() {
		return "GetFlowProcessTypeNCTResultItem [flowProcessTypeId=" + flowProcessTypeId + ", flowProcessTypeName="
				+ flowProcessTypeName + "]";
	}

}
