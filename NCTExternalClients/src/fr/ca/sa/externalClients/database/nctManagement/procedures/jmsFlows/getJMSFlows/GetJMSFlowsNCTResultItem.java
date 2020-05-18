package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.getJMSFlows;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 *
 * Wrapper class for single result in result set from
 * batch.spGetFlowDirectionTypes store procedure
 * 
 * @author Nemanja Ignjatov
 */
public class GetJMSFlowsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int flowId;
	private int flowDirectionId;
	private String flowName;
	private int jmsId;
	private String jmsQueueName;
	private int skipLimit;
	private int retryLimit;

	/**
	 * default constructor for Get JMS Flows NCT Result Item
	 */
	public GetJMSFlowsNCTResultItem() {
		super();
	}

	/**
	 * Get JMS Flows NCT Result Item
	 * 
	 * @param flowId
	 * 				Flow ID
	 * 
	 * @param flowDirectionId
	 * 				Flow direction ID
	 * 
	 * @param flowName
	 * 				Flow name
	 * 
	 * @param jmsId
	 * 				JMS ID
	 * 
	 * @param jmsQueueName
	 * 				JMS queue name
	 * 
	 * @param skipLimit
	 * 				Skip limit
	 * 
	 * @param retryLimit
	 * 				Retry limit
	 */
	public GetJMSFlowsNCTResultItem(int flowId, int flowDirectionId, String flowName, int jmsId, String jmsQueueName,
			int skipLimit, int retryLimit) {
		super();
		this.flowId = flowId;
		this.flowDirectionId = flowDirectionId;
		this.flowName = flowName;
		this.jmsId = jmsId;
		this.jmsQueueName = jmsQueueName;
		this.skipLimit = skipLimit;
		this.retryLimit = retryLimit;
	}

	public int getFlowId() {
		return flowId;
	}

	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}

	public int getFlowDirectionId() {
		return flowDirectionId;
	}

	public void setFlowDirectionId(int flowDirectionId) {
		this.flowDirectionId = flowDirectionId;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public int getJmsId() {
		return jmsId;
	}

	public void setJmsId(int jmsId) {
		this.jmsId = jmsId;
	}

	public String getJmsQueueName() {
		return jmsQueueName;
	}

	public void setJmsQueueName(String jmsQueueName) {
		this.jmsQueueName = jmsQueueName;
	}

	public int getSkipLimit() {
		return skipLimit;
	}

	public void setSkipLimit(int skipLimit) {
		this.skipLimit = skipLimit;
	}

	public int getRetryLimit() {
		return retryLimit;
	}

	public void setRetryLimit(int retryLimit) {
		this.retryLimit = retryLimit;
	}

	@Override
	public String toString() {
		return "GetJMSFlowsNCTResultItem [flowId=" + flowId + ", flowDirectionId=" + flowDirectionId + ", flowName="
				+ flowName + ", jmsId=" + jmsId + ", jmsQueueName=" + jmsQueueName + ", skipLimit=" + skipLimit
				+ ", retryLimit=" + retryLimit + "]";
	}

}
