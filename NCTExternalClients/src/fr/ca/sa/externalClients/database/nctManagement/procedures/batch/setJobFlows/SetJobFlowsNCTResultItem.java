package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.setJobFlows;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Stefan Djokic
 *
 *         Wrapper class for single result in result set from
 *         batch.spSetJobFlows store procedure
 */
public class SetJobFlowsNCTResultItem implements StoreProcedureResult {

	private int flowId;

	/**
	 * default constructor for Set Job Flows NCT Result Item
	 */
	public SetJobFlowsNCTResultItem() {
		super();
	}

	/**
	 * Set Job Flows NCT Result Item
	 * 
	 * @param flowId
	 * 				Flow ID
	 */
	public SetJobFlowsNCTResultItem(int flowId) {
		super();
		this.flowId = flowId;
	}

	public int getFlowId() {
		return flowId;
	}

	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}

	@Override
	public String toString() {
		return "SetJobFlowsNCTResultItem [flowId=" + flowId + "]";
	}

}
