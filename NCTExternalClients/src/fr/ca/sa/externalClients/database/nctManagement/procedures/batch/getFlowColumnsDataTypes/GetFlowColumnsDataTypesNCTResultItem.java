package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowColumnsDataTypes;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 *
 * Wrapper class for single result in result set from
 * batch.spGetFlowColumnsDataTypes store procedure
 * 
 * @author Nemanja Ignjatov
 */
public class GetFlowColumnsDataTypesNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int dataTypeId;
	private String name;

	/**
	 * default constructor for Get Flow Columns Data Types NCT Result Item
	 */
	public GetFlowColumnsDataTypesNCTResultItem() {
		super();
	}

	/**
	 * Get Flow Columns Data Types NCT Result Item
	 * 
	 * @param dataTypeId
	 * 				Data type ID
	 * 
	 * @param name
	 * 				Name
	 */
	public GetFlowColumnsDataTypesNCTResultItem(int dataTypeId, String name) {
		super();
		this.dataTypeId = dataTypeId;
		this.name = name;
	}

	public int getDataTypeId() {
		return dataTypeId;
	}

	public void setDataTypeId(int dataTypeId) {
		this.dataTypeId = dataTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GetFlowColumnsDataTypesNCTResultItem [dataTypeId=" + dataTypeId + ", name=" + name + "]";
	}

}
