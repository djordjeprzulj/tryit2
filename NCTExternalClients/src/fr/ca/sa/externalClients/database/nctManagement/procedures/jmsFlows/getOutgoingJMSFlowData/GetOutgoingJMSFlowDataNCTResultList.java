package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.getOutgoingJMSFlowData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for all results from batch.spGetFlows store procedure
 * 
 * * @author Milivoj Bozic
 */

public class GetOutgoingJMSFlowDataNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetOutgoingJMSFlowDataNCTResultItem> rows;
	private List<String> columns;

	/**
	 * default constructor for Get Outgoing JMS Flow Data NCT Result List
	 */
	public GetOutgoingJMSFlowDataNCTResultList() {
		super();
		this.rows = new ArrayList<GetOutgoingJMSFlowDataNCTResultItem>();
	}

	/**
	 * Get Outgoing JMS Flow Data NCT Result List
	 * 
	 * @param fileRows
	 * 				File rows
	 */
	public GetOutgoingJMSFlowDataNCTResultList(List<GetOutgoingJMSFlowDataNCTResultItem> fileRows) {
		super();
		this.rows = fileRows;
	}

	public List<GetOutgoingJMSFlowDataNCTResultItem> getRows() {
		return rows;
	}

	public void setRows(List<GetOutgoingJMSFlowDataNCTResultItem> rows) {
		this.rows = rows;
	}

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetOutgoingJMSFlowDataNCTResultList [ ");
		if (this.rows != null) {
			for (GetOutgoingJMSFlowDataNCTResultItem fileRow : this.rows) {
				sbRetValue.append(fileRow.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetOutgoingJMSFlowDataNCTResultList is empty!!!";
	}

}
