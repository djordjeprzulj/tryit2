package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowTraceByExecutionId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetFlowTraceByExecutionIdNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetFlowTraceByExecutionIdNCTResultItem> flowTrace;

	/**
	 * default constructor for Get Flow Trace By Execution ID NCT Result List
	 */
	public GetFlowTraceByExecutionIdNCTResultList() {
		super();
		this.flowTrace = new ArrayList<GetFlowTraceByExecutionIdNCTResultItem>();
	}

	/**
	 * Get Flow Trace By Execution ID NCT Result List
	 * 
	 * @param flowTrace
	 * 				Flow trace
	 */
	public GetFlowTraceByExecutionIdNCTResultList(List<GetFlowTraceByExecutionIdNCTResultItem> flowTrace) {
		super();
		this.flowTrace = flowTrace;
	}

	public List<GetFlowTraceByExecutionIdNCTResultItem> getFlowTrace() {
		return flowTrace;
	}

	public void setFlowTrace(List<GetFlowTraceByExecutionIdNCTResultItem> flowTrace) {
		this.flowTrace = flowTrace;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetFlowTraceByExecutionIdNCTResultList [ ");

		if (this.flowTrace != null) {
			for (GetFlowTraceByExecutionIdNCTResultItem flow : this.flowTrace) {
				sbRetValue.append(flow.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetFlowTraceByExecutionIdNCTResultList is empty!!!";
	}
}
