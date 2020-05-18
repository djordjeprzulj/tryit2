package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.configurationParameters;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for all results from spGetCONFIGURATION_PARAMS
 *         store procedure
 */

public class GetConfigurationParametersNCTResultList implements StoreProcedureResult {

	private List<GetConfigurationParametersNCTResultItem> parameters;

	/**
	 * default constructor for Get Configuration Parameters NCT Result List
	 */
	public GetConfigurationParametersNCTResultList() {
		super();
		parameters = new ArrayList<GetConfigurationParametersNCTResultItem>();
	}

	/**
	 * Get Configuration Parameters NCT Result List
	 * 
	 * @param parameters
	 * 				Parameters
	 */
	public GetConfigurationParametersNCTResultList(List<GetConfigurationParametersNCTResultItem> parameters) {
		super();
		this.parameters = parameters;
	}

	public List<GetConfigurationParametersNCTResultItem> getParameters() {
		return parameters;
	}

	public void setParameters(List<GetConfigurationParametersNCTResultItem> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetConfigurationParametersNCTResultList [ ");
		if (this.parameters != null) {
			for (GetConfigurationParametersNCTResultItem clientTypesItem : this.parameters) {
				sbRetValue.append(clientTypesItem.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetConfigurationParametersNCTResultList is empty!!!";
	}

}
