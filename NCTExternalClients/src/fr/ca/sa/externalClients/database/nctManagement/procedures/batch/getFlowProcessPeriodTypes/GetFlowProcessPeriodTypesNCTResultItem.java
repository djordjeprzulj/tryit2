package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowProcessPeriodTypes;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 *
 * Wrapper class for single result in result set from
 * batch.spGetFlowProcessPeriodTypes store procedure
 * 
 * @author Nemanja Ignjatov
 */
public class GetFlowProcessPeriodTypesNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int flowProcessPeriodTypeId;
	private String name;

	/**
	 * default constructor for Get Flow Process Period Types NCT Result Item
	 */
	public GetFlowProcessPeriodTypesNCTResultItem() {
		super();
	}

	/**
	 * Get Flow Process Period Types NCT Result Item
	 * 
	 * @param flowProcessPeriodTypeId
	 * 				Flow process period type ID
	 * 
	 * @param name
	 * 				Name
	 */
	public GetFlowProcessPeriodTypesNCTResultItem(int flowProcessPeriodTypeId, String name) {
		super();
		this.flowProcessPeriodTypeId = flowProcessPeriodTypeId;
		this.name = name;
	}

	public int getFlowProcessPeriodTypeId() {
		return flowProcessPeriodTypeId;
	}

	public void setFlowProcessPeriodTypeId(int flowProcessPeriodTypeId) {
		this.flowProcessPeriodTypeId = flowProcessPeriodTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GetFlowProcessPeriodTypesNCTResultItem [flowProcessPeriodTypeId=" + flowProcessPeriodTypeId + ", name=" + name
				+ "]";
	}

}
