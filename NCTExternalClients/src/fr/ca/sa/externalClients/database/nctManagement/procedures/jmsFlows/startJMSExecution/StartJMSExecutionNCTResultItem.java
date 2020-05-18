package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.startJMSExecution;

import java.io.Serializable;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for single result in result set from
 * batch.spStartJmsExecution store procedure
 * 
 * @author Nemanja Ignjatov
 */
public class StartJMSExecutionNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private int jmsExecutionId;
	private boolean previousExecutionInProgress;

	/**
	 * default constructor for Start JMS Execution NCT Result Item
	 */
	public StartJMSExecutionNCTResultItem() {
		super();
	}

	/**
	 * Start JMS Execution NCT Result Item
	 * 
	 * @param jmsExecutionId
	 * 				JMS execution ID
	 * 
	 * @param previousExecutionInProgress
	 * 				Previous execution in progress
	 */
	public StartJMSExecutionNCTResultItem(int jmsExecutionId, int previousExecutionInProgress) {
		this.jmsExecutionId = jmsExecutionId;
		this.previousExecutionInProgress = previousExecutionInProgress == NCTDatabaseConstants.ACTIVE_INTEGER_VALUE;
	}

	public int getJmsExecutionId() {
		return jmsExecutionId;
	}

	public void setJmsExecutionId(int jmsExecutionId) {
		this.jmsExecutionId = jmsExecutionId;
	}

	public boolean getPreviousExecutionInProgress() {
		return previousExecutionInProgress;
	}

	public void setPreviousExecutionInProgress(boolean previousExecutionInProgress) {
		this.previousExecutionInProgress = previousExecutionInProgress;
	}

	@Override
	public String toString() {
		return "StartJMSExecutionNCTResultItem [jmsExecutionId=" + jmsExecutionId + ", previousExecutionInProgress="
				+ previousExecutionInProgress + "]";
	}

}
