package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.clientTypes;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from spGetClientTypes
 *         store procedure
 */
public class GetClientTypesNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int clientTypeId;
	private String clientTypeName;

	/**
	 * default constructor for Get Client Types NCT Result Item
	 */
	public GetClientTypesNCTResultItem() {
		super();
	}

	/**
	 * Get Client Types NCT Result Item
	 * 
	 * @param clientTypeId
	 * 				Client type ID
	 * 
	 * @param clientTypeName
	 * 				Client type name
	 */
	public GetClientTypesNCTResultItem(int clientTypeId, String clientTypeName) {
		super();
		this.clientTypeId = clientTypeId;
		this.clientTypeName = clientTypeName;
	}

	public int getClientTypeId() {
		return clientTypeId;
	}

	public void setClientTypeId(int clientTypeId) {
		this.clientTypeId = clientTypeId;
	}

	public String getClientTypeName() {
		return clientTypeName;
	}

	public void setClientTypeName(String clientTypeName) {
		this.clientTypeName = clientTypeName;
	}

	@Override
	public String toString() {
		return "GetClientTypesNCTResultItem [clientTypeId=" + clientTypeId + ", clientTypeName=" + clientTypeName + "]";
	}

}
