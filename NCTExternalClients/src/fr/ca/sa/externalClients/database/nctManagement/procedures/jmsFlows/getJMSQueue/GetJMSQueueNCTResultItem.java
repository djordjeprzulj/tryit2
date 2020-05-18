package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.getJMSQueue;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 *
 * Wrapper class for single result in result set from batch.spGetJmsQueue store
 * procedure
 * 
 * @author Nemanja Ignjatov
 */
public class GetJMSQueueNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int jmsId;
	private int jmsQueueId;
	private String jmsQueueName;
	private int flowId;
	private String flowName;
	private int flowDirectionId;

	/**
	 * default constructor for Get JMS Queue NCT Result Item
	 */
	public GetJMSQueueNCTResultItem() {
		super();
	}

	/**
	 * Get JMS Queue NCT Result Item
	 * 
	 * @param jmsId
	 * 				JMS ID
	 * 
	 * @param jmsQueueId
	 * 				JMS queue ID
	 * 
	 * @param jmsQueueName
	 * 				JMS queue name
	 * 
	 * @param flowId
	 * 				Flow ID
	 * 
	 * @param flowName
	 * 				Flow name
	 * 
	 * @param flowDirectionId
	 * 				Flow direction ID
	 */
	public GetJMSQueueNCTResultItem(int jmsId, int jmsQueueId, String jmsQueueName, int flowId, String flowName,
			int flowDirectionId) {
		super();
		this.jmsId = jmsId;
		this.jmsQueueId = jmsQueueId;
		this.jmsQueueName = jmsQueueName;
		this.flowId = flowId;
		this.flowName = flowName;
		this.flowDirectionId = flowDirectionId;
	}

	public int getJmsId() {
		return jmsId;
	}

	public void setJmsId(int jmsId) {
		this.jmsId = jmsId;
	}

	public int getJmsQueueId() {
		return jmsQueueId;
	}

	public void setJmsQueueId(int jmsQueueId) {
		this.jmsQueueId = jmsQueueId;
	}

	public String getJmsQueueName() {
		return jmsQueueName;
	}

	public void setJmsQueueName(String jmsQueueName) {
		this.jmsQueueName = jmsQueueName;
	}

	public int getFlowId() {
		return flowId;
	}

	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public int getFlowDirectionId() {
		return flowDirectionId;
	}

	public void setFlowDirectionId(int flowDirectionId) {
		this.flowDirectionId = flowDirectionId;
	}

	@Override
	public String toString() {
		return "GetJMSQueueNCTResultItem [jmsId=" + jmsId + ", jmsQueueId=" + jmsQueueId + ", jmsQueueName="
				+ jmsQueueName + ", flowId=" + flowId + ", flowName=" + flowName + ", flowDirectionId="
				+ flowDirectionId + "]";
	}

}
