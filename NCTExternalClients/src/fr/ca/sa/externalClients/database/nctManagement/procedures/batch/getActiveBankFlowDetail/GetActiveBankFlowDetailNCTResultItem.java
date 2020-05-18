package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getActiveBankFlowDetail;



import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetActiveBankFlowDetailNCTResultItem implements Serializable {
	
	
	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int  bankId;
	private int flowId;
	private String flowName;
	private String flowDirection;
	private int ctiveProcessingTypeId;
	private int flowProcessingTypeID;
	private String flowProcessingTypeName;
	private int jobID;
	private String jobName;
	
	/**
	 * default constructor for Get Active Bank  Flow Detail NCT Result Item
	 */
	public GetActiveBankFlowDetailNCTResultItem()
	{
		super();
	}
	


	/**
	 * Get Active Bank  Flow Detail NCT Result Item
	 * 
	 * @param bankId
	 * 				Bank ID
	 * 
	 * @param flowId
	 * 				Flow ID
	 * 
	 * @param flowName
	 * 				Flow name
	 * 
	 * @param flowDirection
	 * 				Flow direction
	 * 
	 * @param ctiveProcessingTypeId
	 * 				Active processing type ID
	 * 
	 * @param lowProcessingTypeID
	 * 				Flow processing type ID
	 * 
	 * @param flowProcessingTypeName
	 * 				Flow processing type name
	 * 
	 * @param jobID
	 * 				Job ID
	 * 
	 * @param jobName
	 * 				Job name
	 */
	public GetActiveBankFlowDetailNCTResultItem(int bankId, int flowId, String flowName, String flowDirection,
			int ctiveProcessingTypeId, int lowProcessingTypeID, String flowProcessingTypeName, int jobID,
			String jobName) {
		super();
		this.bankId = bankId;
		this.flowId = flowId;
		this.flowName = flowName;
		this.flowDirection = flowDirection;
		this.ctiveProcessingTypeId = ctiveProcessingTypeId;
		this.flowProcessingTypeID = lowProcessingTypeID;
		this.flowProcessingTypeName = flowProcessingTypeName;
		this.jobID = jobID;
		this.jobName = jobName;
	}



	public int getBankId() {
		return bankId;
	}



	public void setBankId(int bankId) {
		this.bankId = bankId;
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



	public String getFlowDirection() {
		return flowDirection;
	}



	public void setFlowDirection(String flowDirection) {
		this.flowDirection = flowDirection;
	}



	public int getActiveProcessingTypeId() {
		return ctiveProcessingTypeId;
	}



	public void setActiveProcessingTypeId(int ctiveProcessingTypeId) {
		this.ctiveProcessingTypeId = ctiveProcessingTypeId;
	}



	public int getFlowProcessingTypeID() {
		return flowProcessingTypeID;
	}



	public void setLowProcessingTypeID(int lowProcessingTypeID) {
		this.flowProcessingTypeID = lowProcessingTypeID;
	}



	public String getFlowProcessingTypeName() {
		return flowProcessingTypeName;
	}



	public void setFlowProcessingTypeName(String flowProcessingTypeName) {
		this.flowProcessingTypeName = flowProcessingTypeName;
	}



	public int getJobID() {
		return jobID;
	}



	public void setJobID(int jobID) {
		this.jobID = jobID;
	}



	public String getJobName() {
		return jobName;
	}



	public void setJobName(String jobName) {
		this.jobName = jobName;
	}



	@Override
	public String toString() {
		return "GetActiveBankFlowDetailNCTResultItem [bankId=" + bankId + ", flowId=" + flowId + ", flowName="
				+ flowName + ", flowDirection=" + flowDirection + ", ctiveProcessingTypeId=" + ctiveProcessingTypeId
				+ ", lowProcessingTypeID=" + flowProcessingTypeID + ", flowProcessingTypeName=" + flowProcessingTypeName
				+ ", jobID=" + jobID + ", jobName=" + jobName + "]";
	}
	
	
}
