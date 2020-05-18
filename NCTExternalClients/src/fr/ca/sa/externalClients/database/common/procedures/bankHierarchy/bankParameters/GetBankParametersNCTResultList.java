package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankParameters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for all results from spGetBankParameters
 *         store procedure
 */

public class GetBankParametersNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private List<GetBankParametersNCTResultItem> parameters;

	/**
	 * default constructor for Get Bank Parameters NCT Result List
	 */
	public GetBankParametersNCTResultList() {
		super();
		parameters = new ArrayList<GetBankParametersNCTResultItem>();
	}

	/**
	 * Get Bank Parameters NCT Result List
	 * 
	 * @param parameters
	 * 				Parameters
	 */
	public GetBankParametersNCTResultList(List<GetBankParametersNCTResultItem> parameters) {
		super();
		this.parameters = parameters;
	}

	public List<GetBankParametersNCTResultItem> getParameters() {
		return parameters;
	}

	public void setParameters(List<GetBankParametersNCTResultItem> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetBankParametersNCTResultList [ ");
		if (this.parameters != null) {
			for (GetBankParametersNCTResultItem clientTypesItem : this.parameters) {
				sbRetValue.append(clientTypesItem.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetBankParametersNCTResultList is empty!!!";
	}

}
