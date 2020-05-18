package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowExecutionsByJobId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetFlowExecutionsByJobIdNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetFlowExecutionsByJobIdNCTResultItem> flowExecutions;

	/**
	 * default constructor for Get Flow Executions By Job Id NCT Result List
	 */
	public GetFlowExecutionsByJobIdNCTResultList() {
		super();
		this.flowExecutions = new ArrayList<GetFlowExecutionsByJobIdNCTResultItem>();
	}

	public List<GetFlowExecutionsByJobIdNCTResultItem> getFlowExecutions() {
		return flowExecutions;
	}

	public void setFlowExecutions(List<GetFlowExecutionsByJobIdNCTResultItem> flowExecutions) {
		this.flowExecutions = flowExecutions;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetFlowExecutionsByJobIdNCTResultList [ ");

		if (this.flowExecutions != null) {
			for (GetFlowExecutionsByJobIdNCTResultItem flowExecution : this.flowExecutions) {
				sbRetValue.append(flowExecution.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetFlowExecutionsByJobIdNCTResultList is empty!!!";
	}
}
