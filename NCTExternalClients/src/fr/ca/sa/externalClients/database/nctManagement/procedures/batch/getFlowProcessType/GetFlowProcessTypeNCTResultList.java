package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowProcessType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for all results from batch.spGetFlowProcessType store
 * procedure
 * 
 * * @author Nemanja Ignjatov
 */

public class GetFlowProcessTypeNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetFlowProcessTypeNCTResultItem> types;

	/**
	 * default constructor for Get Flow Process Type NCT Result List
	 */
	public GetFlowProcessTypeNCTResultList() {
		super();
		types = new ArrayList<GetFlowProcessTypeNCTResultItem>();
	}

	/**
	 * Get Flow Process Type NCT Result List
	 * 
	 * @param types
	 * 				Types of flow processes
	 */
	public GetFlowProcessTypeNCTResultList(List<GetFlowProcessTypeNCTResultItem> types) {
		super();
		this.types = types;
	}

	public List<GetFlowProcessTypeNCTResultItem> getTypes() {
		return types;
	}

	public void setTypes(List<GetFlowProcessTypeNCTResultItem> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetFlowProcessTypeNCTResultList [ ");
		if (this.types != null) {
			for (GetFlowProcessTypeNCTResultItem typeItem : this.types) {
				sbRetValue.append(typeItem.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetFlowProcessTypeNCTResultList is empty!!!";
	}

}
