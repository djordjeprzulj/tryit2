package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlows;

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

public class GetFlowsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetFlowsNCTResultItem> flows;

	/**
	 * default constructor for Get Flows NCT Result List
	 */
	public GetFlowsNCTResultList() {
		super();
		flows = new ArrayList<GetFlowsNCTResultItem>();
	}

	/**
	 * Get Flows NCT Result List
	 * 
	 * @param flows
	 * 				Flows
	 */
	public GetFlowsNCTResultList(List<GetFlowsNCTResultItem> flows) {
		super();
		this.flows = flows;
	}

	public List<GetFlowsNCTResultItem> getFlows() {
		return flows;
	}

	public void setFlows(List<GetFlowsNCTResultItem> flows) {
		this.flows = flows;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetFlowsNCTResultList [ ");
		if (this.flows != null) {
			for (GetFlowsNCTResultItem flow : this.flows) {
				sbRetValue.append(flow.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetFlowsNCTResultList is empty!!!";
	}

}
