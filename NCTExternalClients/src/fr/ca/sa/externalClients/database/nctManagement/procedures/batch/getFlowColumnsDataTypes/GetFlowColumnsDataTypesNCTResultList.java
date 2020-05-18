package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowColumnsDataTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for all results from batch.spGetFlowColumnsDataTypes store procedure
 * 
 * * @author Nemanja Ignjatov
 */

public class GetFlowColumnsDataTypesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetFlowColumnsDataTypesNCTResultItem> columnDataTypes;

	/**
	 * default constructor for Get Flow Columns Data Types NCT Result List
	 */
	public GetFlowColumnsDataTypesNCTResultList() {
		super();
		columnDataTypes = new ArrayList<GetFlowColumnsDataTypesNCTResultItem>();
	}

	/**
	 * Get Flow Columns Data Types NCT Result List
	 * 
	 * @param columnDataTypes
	 * 				Column data type
	 */
	public GetFlowColumnsDataTypesNCTResultList(List<GetFlowColumnsDataTypesNCTResultItem> columnDataTypes) {
		super();
		this.columnDataTypes = columnDataTypes;
	}

	public List<GetFlowColumnsDataTypesNCTResultItem> getColumnDataTypes() {
		return columnDataTypes;
	}

	public void setColumnDataTypes(List<GetFlowColumnsDataTypesNCTResultItem> columnDataTypes) {
		this.columnDataTypes = columnDataTypes;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetFlowColumnsDataTypesNCTResultList [ ");
		if (this.columnDataTypes != null) {
			for (GetFlowColumnsDataTypesNCTResultItem dataType : this.columnDataTypes) {
				sbRetValue.append(dataType.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetFlowColumnsDataTypesNCTResultList is empty!!!";
	}

}
