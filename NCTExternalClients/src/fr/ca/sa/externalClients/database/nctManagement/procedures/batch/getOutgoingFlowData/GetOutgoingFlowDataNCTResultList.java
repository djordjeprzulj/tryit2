package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getOutgoingFlowData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for all results from batch.spGetFlows store procedure
 * 
 * * @author Nemanja Ignjatov
 */

public class GetOutgoingFlowDataNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetOutgoingFlowDataNCTResultItem> fileRows;

	/**
	 * default constructor for Get Outgoing Flow Data NCT Result List
	 */
	public GetOutgoingFlowDataNCTResultList() {
		super();
		this.fileRows = new ArrayList<GetOutgoingFlowDataNCTResultItem>();
	}

	/**
	 * Get Outgoing Flow Data NCT Result List
	 * 
	 * @param fileRows
	 * 				File rows
	 */
	public GetOutgoingFlowDataNCTResultList(List<GetOutgoingFlowDataNCTResultItem> fileRows) {
		super();
		this.fileRows = fileRows;
	}

	public List<GetOutgoingFlowDataNCTResultItem> getFileRows() {
		return fileRows;
	}

	public void setFileRows(List<GetOutgoingFlowDataNCTResultItem> fileRows) {
		this.fileRows = fileRows;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetOutgoingFlowDataNCTResultList [ ");
		if (this.fileRows != null) {
			for (GetOutgoingFlowDataNCTResultItem fileRow : this.fileRows) {
				sbRetValue.append(fileRow.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetOutgoingFlowDataNCTResultList is empty!!!";
	}

}
