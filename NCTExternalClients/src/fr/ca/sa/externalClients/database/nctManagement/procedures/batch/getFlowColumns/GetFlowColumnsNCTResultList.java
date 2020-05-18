package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowColumns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for all results from batch.spGetFlowColumns store procedure
 * 
 * * @author Nemanja Ignjatov
 */

public class GetFlowColumnsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetFlowColumnsNCTResultItem> flowColumns;

	/**
	 * default constructor for Get Flow Columns NCT Result List
	 */
	public GetFlowColumnsNCTResultList() {
		super();
		flowColumns = new ArrayList<GetFlowColumnsNCTResultItem>();
	}

	/**
	 * Get Flow Columns NCT Result List
	 * 
	 * @param flowColumns
	 * 				Flow columns
	 */
	public GetFlowColumnsNCTResultList(List<GetFlowColumnsNCTResultItem> flowColumns) {
		super();
		this.flowColumns = flowColumns;
	}

	public List<GetFlowColumnsNCTResultItem> getFlowColumns() {
		return flowColumns;
	}

	public void setFlowColumns(List<GetFlowColumnsNCTResultItem> flowColumns) {
		this.flowColumns = flowColumns;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetFlowColumnsNCTResultList [ ");
		if (this.flowColumns != null) {
			for (GetFlowColumnsNCTResultItem column : this.flowColumns) {
				sbRetValue.append(column.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetFlowColumnsNCTResultList is empty!!!";
	}

}
