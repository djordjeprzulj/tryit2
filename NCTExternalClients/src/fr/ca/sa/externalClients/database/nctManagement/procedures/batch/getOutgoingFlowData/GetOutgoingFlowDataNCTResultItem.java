package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getOutgoingFlowData;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetOutgoingFlowDataNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String fileRow;

	/**
	 * default constructor for Get Outgoing Flow Data NCT Result Item
	 */
	public GetOutgoingFlowDataNCTResultItem() {
		super();
	}

	/**
	 * Get Outgoing Flow Data NCT Result Item
	 * 
	 * @param fileRow
	 * 				File row
	 */
	public GetOutgoingFlowDataNCTResultItem(String fileRow) {
		super();
		this.fileRow = fileRow;
	}

	public String getFileRow() {
		return fileRow;
	}

	public void setFileRow(String fileRow) {
		this.fileRow = fileRow;
	}

	@Override
	public String toString() {
		return "GetOutgoingFlowDataNCTResultItem [fileRow=" + fileRow + "]";
	}

}
