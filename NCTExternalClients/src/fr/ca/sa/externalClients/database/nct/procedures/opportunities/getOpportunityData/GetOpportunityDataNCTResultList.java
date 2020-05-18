package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * List of opportunities fetched from DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunityDataNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetOpportunityDataNCTResultItem> opportunities;

	/**
	 * default constructor for Get Opportunity Data NCT Result List
	 */
	public GetOpportunityDataNCTResultList() {
		this.opportunities = new ArrayList<GetOpportunityDataNCTResultItem>();
	}

	/**
	 * Get Opportunity Data NCT Result List
	 * 
	 * @param opportunities
	 * 				Opportunities
	 */
	public GetOpportunityDataNCTResultList(List<GetOpportunityDataNCTResultItem> opportunities) {
		super();
		this.opportunities = opportunities;
	}

	public List<GetOpportunityDataNCTResultItem> getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(List<GetOpportunityDataNCTResultItem> opportunities) {
		this.opportunities = opportunities;
	}

	@Override
	public String toString() {
		return "GetOpportunityDataNCTResultList [opportunities=" + opportunities + "]";
	}

}
