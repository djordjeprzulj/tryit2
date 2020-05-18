package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.competitors.getProspectCompetitors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for list of prospect competitors
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetProspectCompetitorsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetProspectCompetitorsNCTResultItem> prospectCompetitors;

	/**
	 * default constructor for Get Prospect Competitors NCT Result List
	 */
	public GetProspectCompetitorsNCTResultList() {
		prospectCompetitors = new ArrayList<GetProspectCompetitorsNCTResultItem>();
	}

	public List<GetProspectCompetitorsNCTResultItem> getProspectCompetitors() {
		return prospectCompetitors;
	}

	public void setProspectCompetitors(List<GetProspectCompetitorsNCTResultItem> prospectCompetitors) {
		this.prospectCompetitors = prospectCompetitors;
	}

	/**
	 * Get Prospect Competitors NCT Result List
	 * 
	 * @param prospectCompetitors
	 * 				Prospect competitor
	 */
	public GetProspectCompetitorsNCTResultList(List<GetProspectCompetitorsNCTResultItem> prospectCompetitors) {
		super();
		this.prospectCompetitors = prospectCompetitors;
	}

	@Override
	public String toString() {
		return "GetProspectCompetitorsNCTResultList [prospectCompetitors=" + prospectCompetitors + "]";
	}

}
