package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getClientActiveOpportunities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * List of client active opportunities fetched from DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientActiveOpportunitiesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetClientActiveOpportunitiesNCTResultItem> opportunities;

	/**
	 * default constructor for Get Client Active Opportunities NCT Result List
	 */
	public GetClientActiveOpportunitiesNCTResultList() {
		this.opportunities = new ArrayList<GetClientActiveOpportunitiesNCTResultItem>();
	}

	/**
	 * Get Client Active Opportunities NCT Result List
	 * 
	 * @param opportunities
	 * 				Opportunities
	 */
	public GetClientActiveOpportunitiesNCTResultList(
			List<GetClientActiveOpportunitiesNCTResultItem> opportunities) {
		super();
		this.opportunities = opportunities;
	}

	public List<GetClientActiveOpportunitiesNCTResultItem> getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(List<GetClientActiveOpportunitiesNCTResultItem> opportunities) {
		this.opportunities = opportunities;
	}

	@Override
	public String toString() {
		return "GetClientActiveOpportunitiesNCTResultList [opportunities=" + opportunities + "]";
	}

}
