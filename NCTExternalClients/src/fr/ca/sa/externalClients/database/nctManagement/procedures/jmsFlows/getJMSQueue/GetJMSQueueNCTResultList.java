package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.getJMSQueue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for all results from batch.spGetJmsQueue store procedure
 * 
 * * @author Nemanja Ignjatov
 */

public class GetJMSQueueNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetJMSQueueNCTResultItem> queues;

	/**
	 * default constructor for Get JMS Queue NCT Result List
	 */
	public GetJMSQueueNCTResultList() {
		super();
		queues = new ArrayList<GetJMSQueueNCTResultItem>();
	}

	/**
	 * Get JMS Queue NCT Result List
	 * 
	 * @param queues
	 * 				Queues
	 */
	public GetJMSQueueNCTResultList(List<GetJMSQueueNCTResultItem> queues) {
		super();
		this.queues = queues;
	}

	public List<GetJMSQueueNCTResultItem> getQueues() {
		return queues;
	}

	public void setQueues(List<GetJMSQueueNCTResultItem> queues) {
		this.queues = queues;
	}

	@Override
	public String toString() {
		StringBuilder retValue = new StringBuilder("GetJMSQueueNCTResultList [ ");
		if (this.queues != null) {
			for (GetJMSQueueNCTResultItem flow : this.queues) {
				retValue.append(flow.toString());
			}
			retValue.append(" ]");
			return retValue.toString();
		}

		return "GetJMSQueueNCTResultList is empty!!!";
	}

}
