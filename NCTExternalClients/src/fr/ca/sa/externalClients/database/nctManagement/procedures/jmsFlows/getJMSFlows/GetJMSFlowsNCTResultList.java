package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.getJMSFlows;

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

public class GetJMSFlowsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetJMSFlowsNCTResultItem> flows;

	/**
	 * default constructor for Get JMS Flows NCT Result List
	 */
	public GetJMSFlowsNCTResultList() {
		super();
		flows = new ArrayList<GetJMSFlowsNCTResultItem>();
	}

	/**
	 * Get JMS Flows NCT Result List
	 * 
	 * @param flows
	 * 				Flows
	 */
	public GetJMSFlowsNCTResultList(List<GetJMSFlowsNCTResultItem> flows) {
		super();
		this.flows = flows;
	}

	public List<GetJMSFlowsNCTResultItem> getFlows() {
		return flows;
	}

	public void setFlows(List<GetJMSFlowsNCTResultItem> flows) {
		this.flows = flows;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetFlowsNCTResultList [ ");
		if (this.flows != null) {
			for (GetJMSFlowsNCTResultItem flow : this.flows) {
				sbRetValue.append(flow.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetFlowsNCTResultList is empty!!!";
	}

}
