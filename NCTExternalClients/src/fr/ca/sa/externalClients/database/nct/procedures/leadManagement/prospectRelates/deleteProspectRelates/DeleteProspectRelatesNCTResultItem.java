package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.prospectRelates.deleteProspectRelates;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * Wrapper for returning prospect relate Id
 * 
 * @author Nemanja Ignjatov
 *
 */
public class DeleteProspectRelatesNCTResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int prospectId;

	/**
	 * default constructor for Delete Prospect Relates NCT Result Item
	 */
	public DeleteProspectRelatesNCTResultItem() {
		super();
	}

	/**
	 * Delete Prospect Relates NCT Result Item
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 */
	public DeleteProspectRelatesNCTResultItem(int prospectId) {
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
		return "DeleteProspectRelatesNCTResultItem [prospectId=" + prospectId + "]";
	}

}
