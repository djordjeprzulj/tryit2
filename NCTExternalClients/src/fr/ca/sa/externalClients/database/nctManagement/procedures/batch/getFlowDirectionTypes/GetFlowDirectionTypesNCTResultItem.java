package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowDirectionTypes;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 *
 * Wrapper class for single result in result set from
 * batch.spGetFlowDirectionTypes store procedure
 * 
 * @author Nemanja Ignjatov
 */
public class GetFlowDirectionTypesNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int flowDirectionTypeId;
	private String name;

	/**
	 * default constructor for Get Flow Direction Types NCT Result Item
	 */
	public GetFlowDirectionTypesNCTResultItem() {
		super();
	}

	/**
	 * Get Flow Direction Types NCT Result Item
	 * 
	 * @param flowDirectionTypeId
	 * 				Flow direction type ID
	 * 
	 * @param name
	 * 				Name
	 */
	public GetFlowDirectionTypesNCTResultItem(int flowDirectionTypeId, String name) {
		super();
		this.flowDirectionTypeId = flowDirectionTypeId;
		this.name = name;
	}

	public int getFlowDirectionTypeId() {
		return flowDirectionTypeId;
	}

	public void setFlowDirectionTypeId(int flowDirectionTypeId) {
		this.flowDirectionTypeId = flowDirectionTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GetFlowDirectionTypesNCTResultItem [flowDirectionTypeId=" + flowDirectionTypeId + ", name=" + name
				+ "]";
	}

}
