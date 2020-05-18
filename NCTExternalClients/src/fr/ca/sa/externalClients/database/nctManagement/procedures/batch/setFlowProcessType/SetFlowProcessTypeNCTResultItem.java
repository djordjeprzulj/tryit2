package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.setFlowProcessType;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetFlowProcessTypeNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer flowId;

	/**
	 * default constructor for Set Flow Process Type NCT Result Item
	 */
	public SetFlowProcessTypeNCTResultItem() {
		super();
	}

	/**
	 * Set Flow Process Type NCT Result Item
	 * 
	 * @param flowId
	 * 				Flow ID
	 */
	public SetFlowProcessTypeNCTResultItem(Integer flowId) {
		super();
		this.flowId = flowId;
	}

	public Integer getFlowId() {
		return flowId;
	}

	public void setFlowId(Integer flowId) {
		this.flowId = flowId;
	}

	@Override
	public String toString() {
		return "SetFlowProcessTypeNCTResultItem [flowId=" + flowId + "]";
	}
	
	

	
}
