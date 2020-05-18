package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.clientTypes;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for all results from spGetClientTypes store procedure
 */

public class GetClientTypesNCTResultList implements StoreProcedureResult {

	private List<GetClientTypesNCTResultItem> clientTypes;

	/**
	 * default constructor for Get Client Types NCT Result List
	 */
	public GetClientTypesNCTResultList() {
		super();
		clientTypes = new ArrayList<GetClientTypesNCTResultItem>();
	}

	/**
	 * Get Client Types NCT Result List
	 * 
	 * @param clientTypes
	 * 				Client types
	 */
	public GetClientTypesNCTResultList(List<GetClientTypesNCTResultItem> clientTypes) {
		super();
		this.clientTypes = clientTypes;
	}

	public List<GetClientTypesNCTResultItem> getClientTypes() {
		return clientTypes;
	}

	public void setClientTypes(List<GetClientTypesNCTResultItem> clientTypes) {
		this.clientTypes = clientTypes;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetClientTypesNCTResultList [ ");
		if (this.clientTypes != null) {
			for (GetClientTypesNCTResultItem clientTypesItem : this.clientTypes) {
				sbRetValue.append(clientTypesItem.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetClientTypesNCTResultList is empty!!!";
	}

}
