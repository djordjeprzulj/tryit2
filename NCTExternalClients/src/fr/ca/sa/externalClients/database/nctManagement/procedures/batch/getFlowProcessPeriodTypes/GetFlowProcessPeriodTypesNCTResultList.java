package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowProcessPeriodTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for all results from batch.spGetFlowProcessPeriodTypes store
 * procedure
 * 
 * * @author Nemanja Ignjatov
 */

public class GetFlowProcessPeriodTypesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetFlowProcessPeriodTypesNCTResultItem> flowPeriodTypes;

	/**
	 * default constructor for Get Flow Process Period Types NCT Result List
	 */
	public GetFlowProcessPeriodTypesNCTResultList() {
		super();
		flowPeriodTypes = new ArrayList<GetFlowProcessPeriodTypesNCTResultItem>();
	}

	/**
	 * Get Flow Process Period Types NCT Result List
	 * 
	 * @param flowPeriodTypes
	 * 				Flow period types
	 */
	public GetFlowProcessPeriodTypesNCTResultList(List<GetFlowProcessPeriodTypesNCTResultItem> flowPeriodTypes) {
		super();
		this.flowPeriodTypes = flowPeriodTypes;
	}

	public List<GetFlowProcessPeriodTypesNCTResultItem> getFlowPeriodTypes() {
		return flowPeriodTypes;
	}

	public void setFlowPeriodTypes(List<GetFlowProcessPeriodTypesNCTResultItem> flowPeriodTypes) {
		this.flowPeriodTypes = flowPeriodTypes;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetFlowProcessPeriodTypesNCTResultList [ ");
		if (this.flowPeriodTypes != null) {
			for (GetFlowProcessPeriodTypesNCTResultItem period : this.flowPeriodTypes) {
				sbRetValue.append(period.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetFlowProcessPeriodTypesNCTResultList is empty!!!";
	}

}
