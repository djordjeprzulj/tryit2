package fr.ca.sa.nct.commons.services.json.event;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ReassignOpportunity implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer branchId;
	private Integer collaboratorId;
	private Integer callerId;
	private Integer callerBranchId;

	private List<Integer> opportunityIds;

	/**
	 * default constructor for Reassign Opportunity
	 */
	public ReassignOpportunity() {
		super();
	}

	/**
	 * Reassign Opportunity
	 * 
	 * @param branchId
	 * 				Branch ID
	 * 
	 * @param collaboratorId
	 * 				Collaborator ID
	 * 
	 * @param callerId
	 * 				Caller ID
	 * 
	 * @param callerBranchId
	 * 				Caller branch ID
	 * 
	 * @param opportunityIds
	 * 				Opportunity IDs
	 */
	public ReassignOpportunity(Integer branchId, Integer collaboratorId, Integer callerId, Integer callerBranchId,
			List<Integer> opportunityIds) {
		super();
		this.branchId = branchId;
		this.collaboratorId = collaboratorId;
		this.callerId = callerId;
		this.callerBranchId = callerBranchId;
		this.opportunityIds = opportunityIds;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getCollaboratorId() {
		return collaboratorId;
	}

	public void setCollaboratorId(Integer collaboratorId) {
		this.collaboratorId = collaboratorId;
	}

	public Integer getCallerId() {
		return callerId;
	}

	public void setCallerId(Integer callerId) {
		this.callerId = callerId;
	}

	public Integer getCallerBranchId() {
		return callerBranchId;
	}

	public void setCallerBranchId(Integer callerBranchId) {
		this.callerBranchId = callerBranchId;
	}

	public List<Integer> getOpportunityIds() {
		return opportunityIds;
	}

	public void setOpportunityIds(List<Integer> opportunityIds) {
		this.opportunityIds = opportunityIds;
	}

}
