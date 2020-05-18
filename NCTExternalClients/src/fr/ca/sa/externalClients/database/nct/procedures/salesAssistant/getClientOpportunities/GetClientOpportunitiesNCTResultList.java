package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientOpportunities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for opportunities list retrieved from database. Used in pair
 * with @GetOpportunitiesNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientOpportunitiesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetClientOpportunitiesNCTResultItem> opportunities;

	/**
	 * default constructor for Get Client Opportunities NCT Result List
	 */
	public GetClientOpportunitiesNCTResultList() {
		super();
		opportunities = new ArrayList<GetClientOpportunitiesNCTResultItem>();
	}

	/**
	 * Get Client Opportunities NCT Result List
	 * 
	 * @param opportunities
	 * 				Opportunities 
	 */
	public GetClientOpportunitiesNCTResultList(List<GetClientOpportunitiesNCTResultItem> opportunities) {
		super();
		this.opportunities = opportunities;
	}

	public List<GetClientOpportunitiesNCTResultItem> getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(List<GetClientOpportunitiesNCTResultItem> opportunities) {
		this.opportunities = opportunities;
	}

	@Override
	public String toString() {
		return "GetOpportunitiesNCTResultList [opportunities=" + opportunities + "]";
	}

}
