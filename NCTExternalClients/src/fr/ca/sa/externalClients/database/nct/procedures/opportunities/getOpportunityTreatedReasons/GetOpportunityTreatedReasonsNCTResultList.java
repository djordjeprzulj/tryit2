package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityTreatedReasons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunityTreatedReasonsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetOpportunityTreatedReasonsNCTResultItem> opportunityTreatedReasons;

	/**
	 * default constructor for Get Opportunity Treated Reasons NCT Result List
	 */
	public GetOpportunityTreatedReasonsNCTResultList() {
		super();
		this.opportunityTreatedReasons = new ArrayList<GetOpportunityTreatedReasonsNCTResultItem>();
	}

	public List<GetOpportunityTreatedReasonsNCTResultItem> getOpportunityTreatedReasons() {
		return opportunityTreatedReasons;
	}

	public void setOpportunityTreatedReasons(
			List<GetOpportunityTreatedReasonsNCTResultItem> opportunityTreatedReasons) {
		this.opportunityTreatedReasons = opportunityTreatedReasons;
	}

	@Override
	public String toString() {
		return "GetOpportunityTreatedReasonsNCTResultList [opportunityTreatedReasons=" + opportunityTreatedReasons
				+ "]";
	}

}
