package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getOpportunityStatuses;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Opportunity status result holder
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetSAOpportunityStatusResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer statusId;

	private String statusName;

	/**
	 * Get Sales Assistant Opportunity Status Result Item
	 * 
	 * @param statusId
	 * 				Status ID
	 * 
	 * @param statusName
	 * 				Status name
	 */
	public GetSAOpportunityStatusResultItem(Integer statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "GetSAOpportunityStatusResultItem [statusId=" + statusId + ", statusName=" + statusName + "]";
	}

}
