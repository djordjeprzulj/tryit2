package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.getOutgoingJMSFlowData;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Milivoj Bozic
 *
 */
public class GetOutgoingJMSFlowDataNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<String> data;

	/**
	 * default constructor for Get Outgoing JMS Flow Data NCT Result Item
	 */
	public GetOutgoingJMSFlowDataNCTResultItem() {
		super();
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "GetOutgoingJMSFlowDataNCTResultItem [" + String.join(",", data) + "]";
	}

}
