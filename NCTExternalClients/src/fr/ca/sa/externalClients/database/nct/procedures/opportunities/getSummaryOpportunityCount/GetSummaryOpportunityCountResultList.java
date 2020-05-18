package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getSummaryOpportunityCount;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

public class GetSummaryOpportunityCountResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetSummaryOpportunityCountResultItem> resultList;

	public GetSummaryOpportunityCountResultList() {
		this.resultList = new ArrayList<GetSummaryOpportunityCountResultItem>();
	}

	public GetSummaryOpportunityCountResultList(List<GetSummaryOpportunityCountResultItem> resultList) {
		super();
		this.resultList = resultList;
	}

	public List<GetSummaryOpportunityCountResultItem> getResultList() {
		return resultList;
	}

	public void setResultList(List<GetSummaryOpportunityCountResultItem> resultList) {
		this.resultList = resultList;
	}

	@Override
	public String toString() {
		return "GetSummaryOpportunityCountResultList [resultList=" + resultList + "]";
	}

}
