package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.getJMSTraceByExecutionId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for all results from batch.spGetFlows store procedure
 * 
 * * @author Nemanja Ignjatov
 */

public class GetJMSTraceNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetJMSTraceNCTResultItem> traces;

	/**
	 * default constructor for Get JMS Flows NCT Result List
	 */
	public GetJMSTraceNCTResultList() {
		super();
		traces = new ArrayList<GetJMSTraceNCTResultItem>();
	}

	/**
	 * Get JMS Flows NCT Result List
	 * 
	 * @param flows Flows
	 */
	public GetJMSTraceNCTResultList(List<GetJMSTraceNCTResultItem> traces) {
		super();
		this.traces = traces;
	}

	public List<GetJMSTraceNCTResultItem> getTraces() {
		return traces;
	}

	public void setTraces(List<GetJMSTraceNCTResultItem> traces) {
		this.traces = traces;
	}

	@Override
	public String toString() {
		return "GetJMSTraceNCTResultList [traces=" + traces + "]";
	}

}
