package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.competitors.setProspectCompetitors;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning prospect competitor Id
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetProspectCompetitorNCTResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int competitorId;

	/**
	 * default constructor for Set Prospect Competitor NCT Result Item
	 */
	public SetProspectCompetitorNCTResultItem() {
		super();
	}

	/**
	 * Set Prospect Competitor NCT Result Item
	 * 
	 * @param competitorId
	 * 				Competitor ID
	 */
	public SetProspectCompetitorNCTResultItem(int competitorId) {
		super();
		this.competitorId = competitorId;
	}

	public int getCompetitorId() {
		return competitorId;
	}

	public void setCompetitorId(int competitorId) {
		this.competitorId = competitorId;
	}

	@Override
	public String toString() {
		return "SetProspectCompetitorNCTResultItem [competitorId=" + competitorId + "]";
	}

}
