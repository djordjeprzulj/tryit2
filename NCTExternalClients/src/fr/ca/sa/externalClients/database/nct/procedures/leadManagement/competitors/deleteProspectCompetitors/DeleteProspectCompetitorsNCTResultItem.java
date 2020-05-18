package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.competitors.deleteProspectCompetitors;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * Wrapper for returning prospect prospect Id
 * 
 * @author Nemanja Ignjatov
 *
 */
public class DeleteProspectCompetitorsNCTResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int prospectId;

	/**
	 * default constructor for Delete Prospect Competitors NCT Result Item
	 */
	public DeleteProspectCompetitorsNCTResultItem() {
		super();
	}

	/**
	 * Delete Prospect Competitors NCT Result Item
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 */
	public DeleteProspectCompetitorsNCTResultItem(int prospectId) {
		super();
		this.prospectId = prospectId;
	}

	public int getProspectId() {
		return prospectId;
	}

	public void setProspectId(int prospectId) {
		this.prospectId = prospectId;
	}

	@Override
	public String toString() {
		return "DeleteProspectCompetitorsNCTResultItem [prospectId=" + prospectId + "]";
	}

}
