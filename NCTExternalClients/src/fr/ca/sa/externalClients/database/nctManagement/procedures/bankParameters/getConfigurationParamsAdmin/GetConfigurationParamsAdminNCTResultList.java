package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.getConfigurationParamsAdmin;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetConfigurationParamsAdminNCTResultList implements StoreProcedureResult {
	
	private List<GetConfigurationParamsAdminNCTResultItem> paramsList;

	/**
	 * default constructor for Get Configuration Parameters Admin NCT Result List
	 */
	public GetConfigurationParamsAdminNCTResultList() {
		super();
		paramsList=new ArrayList<GetConfigurationParamsAdminNCTResultItem>();
	}

	/**
	 * Get Configuration Parameters Admin NCT Result List
	 * 
	 * @param paramsList
	 * 				List of parameters
	 */
	public GetConfigurationParamsAdminNCTResultList(List<GetConfigurationParamsAdminNCTResultItem> paramsList) {
		super();
		this.paramsList = paramsList;
	}

	public List<GetConfigurationParamsAdminNCTResultItem> getParamsList() {
		return paramsList;
	}

	public void setParamsList(List<GetConfigurationParamsAdminNCTResultItem> paramsList) {
		this.paramsList = paramsList;
	}

	@Override
	public String toString() {
		return "GetConfigurationParamsAdminNCTResultList [paramsList=" + paramsList + "]";
	}
	
	 


}
