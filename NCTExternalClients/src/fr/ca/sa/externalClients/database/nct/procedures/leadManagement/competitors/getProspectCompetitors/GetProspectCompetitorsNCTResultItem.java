package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.competitors.getProspectCompetitors;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Wrapper for returning single item of prospect competitor in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetProspectCompetitorsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int competitorId;
	private String competitorName;

	/**
	 * default constructor for Get Prospect Competitors NCT Result Item
	 */
	public GetProspectCompetitorsNCTResultItem() {
		super();
	}

	/**
	 * Get Prospect Competitors NCT Result Item
	 * 
	 * @param competitorId
	 * 				Competitor ID
	 * 
	 * @param competitorName
	 * 				Competitor name
	 */
	public GetProspectCompetitorsNCTResultItem(int competitorId, String competitorName) {
		super();
		this.competitorId = competitorId;
		this.competitorName = competitorName;
	}

	public int getCompetitorId() {
		return competitorId;
	}

	public void setCompetitorId(int competitorId) {
		this.competitorId = competitorId;
	}

	public String getCompetitorName() {
		return competitorName;
	}

	public void setCompetitorName(String competitorName) {
		this.competitorName = competitorName;
	}

	@Override
	public String toString() {
		return "GetProspectCompetitorsNCTResultItem [competitorId=" + competitorId + ", competitorName="
				+ competitorName + "]";
	}

}
