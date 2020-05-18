package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.configurationAttributes;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for all results from spGetCONFIGURATION_ATTRIBUTES
 *         store procedure
 */

public class GetConfigurationAttributesNCTResultList implements StoreProcedureResult {

	private List<GetConfigurationAttributesNCTResultItem> parameters;

	/**
	 * default constructor for Get Configuration Attributes NCT Result List
	 */
	public GetConfigurationAttributesNCTResultList() {
		super();
		parameters = new ArrayList<GetConfigurationAttributesNCTResultItem>();
	}

	/**
	 * Get Configuration Attributes NCT Result List
	 * 
	 * @param parameters
	 * 				Parameters
	 */
	public GetConfigurationAttributesNCTResultList(List<GetConfigurationAttributesNCTResultItem> parameters) {
		super();
		this.parameters = parameters;
	}

	public List<GetConfigurationAttributesNCTResultItem> getParameters() {
		return parameters;
	}

	public void setParameters(List<GetConfigurationAttributesNCTResultItem> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetConfigurationAttributesNCTResultList [ ");
		if (this.parameters != null) {
			for (GetConfigurationAttributesNCTResultItem clientTypesItem : this.parameters) {
				sbRetValue.append(clientTypesItem.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetConfigurationAttributesNCTResultList is empty!!!";
	}

}
