package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.setFlowProcessType;


import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetFlowProcessTypeNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private List<SetFlowProcessTypeNCTResultItem> flowIdList;
	
	/**
	 * default constructor for Set Flow Process Type NCT Result List
	 */
	public SetFlowProcessTypeNCTResultList() {
		super();
	}
	
	/**
	 * Set Flow Process Type NCT Result List
	 * 
	 * @param flowIdList
	 * 				Flow ID list
	 */
	public SetFlowProcessTypeNCTResultList(List<SetFlowProcessTypeNCTResultItem> flowIdList) {
		super();
		this.flowIdList = flowIdList;
	}
	public List<SetFlowProcessTypeNCTResultItem> getFlowIdList() {
		return flowIdList;
	}
	public void setFlowIdList(List<SetFlowProcessTypeNCTResultItem> flowIdList) {
		this.flowIdList = flowIdList;
	}
	@Override
	public String toString() {
		return "SetFlowProcessTypeNCTResultList [flowIdList=" + flowIdList + "]";
	}
	

}
