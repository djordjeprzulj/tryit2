package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getSummaryOpportunityCount;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

public class GetSummaryOpportunityCountResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer opportTypeId;
	private Integer opportSubCatId;
	private Integer entityId;
	private Integer oppSum;

	public GetSummaryOpportunityCountResultItem() {
		super();
	}

	public GetSummaryOpportunityCountResultItem(Integer opportTypeId, Integer opportSubCatId, Integer entityId,
			Integer oppSum) {
		super();
		this.opportTypeId = opportTypeId;
		this.opportSubCatId = opportSubCatId;
		this.entityId = entityId;
		this.oppSum = oppSum;
	}

	public Integer getOpportTypeId() {
		return opportTypeId;
	}

	public void setOpportTypeId(Integer opportTypeId) {
		this.opportTypeId = opportTypeId;
	}

	public Integer getOpportSubCatId() {
		return opportSubCatId;
	}

	public void setOpportSubCatId(Integer opportSubCatId) {
		this.opportSubCatId = opportSubCatId;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public Integer getOppSum() {
		return oppSum;
	}

	public void setOppSum(Integer oppSum) {
		this.oppSum = oppSum;
	}

	@Override
	public String toString() {
		return "GetSummaryOpportunityCountResultItem [opportTypeId=" + opportTypeId + ", opportSubCatId="
				+ opportSubCatId + ", entityId=" + entityId + ", oppSum=" + oppSum + "]";
	}

	
}
