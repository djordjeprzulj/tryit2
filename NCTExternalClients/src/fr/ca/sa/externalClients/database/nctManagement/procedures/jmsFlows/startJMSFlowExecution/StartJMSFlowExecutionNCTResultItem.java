package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.startJMSFlowExecution;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for single result in result set from
 * batch.spStartJmsFlowExecution store procedure
 * 
 * @author Nemanja Ignjatov
 */
public class StartJMSFlowExecutionNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int jmsFlowExecutionId;

	/**
	 * default constructor for Start JMS Flow Execution NCT Result Item
	 */
	public StartJMSFlowExecutionNCTResultItem() {
		super();
	}

	/**
	 * Start JMS Flow Execution NCT Result Item
	 * 
	 * @param jmsFlowExecutionId
	 * 				JMS flow execution ID
	 */
	public StartJMSFlowExecutionNCTResultItem(int jmsFlowExecutionId) {
		super();
		this.jmsFlowExecutionId = jmsFlowExecutionId;
	}

	public int getJmsFlowExecutionId() {
		return jmsFlowExecutionId;
	}

	public void setJmsFlowExecutionId(int jmsFlowExecutionId) {
		this.jmsFlowExecutionId = jmsFlowExecutionId;
	}

	@Override
	public String toString() {
		return "StartJMSFlowExecutionNCTResultItem [jmsFlowExecutionId=" + jmsFlowExecutionId + "]";
	}

}
