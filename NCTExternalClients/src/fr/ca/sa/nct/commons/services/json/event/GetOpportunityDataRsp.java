package fr.ca.sa.nct.commons.services.json.event;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityData.GetOpportunityDataNCTResultItem;

/**
 * 
 * Response JSON wrapper for opportunities data
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunityDataRsp implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetOpportunityDataNCTResultItem> opportunities;

	/**
	 * default constructor for Get Opportunity Data Response
	 */
	public GetOpportunityDataRsp() {
		super();
	}

	/**
	 * Get Opportunity Data Response
	 * 
	 * @param opportunities
	 * 				Opportunities
	 */
	public GetOpportunityDataRsp(List<GetOpportunityDataNCTResultItem> opportunities) {
		super();
		this.opportunities = opportunities;
	}

	public List<GetOpportunityDataNCTResultItem> getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(List<GetOpportunityDataNCTResultItem> opportunities) {
		this.opportunities = opportunities;
	}

}
