package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.setProspect;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning prospect Id in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetProspectNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int prospectId;

	/**
	 * default constructor for Set Prospect NCT Result Item
	 */
	public SetProspectNCTResultItem() {
		super();
	}

	/**
	 * Set Prospect NCT Result Item
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 */
	public SetProspectNCTResultItem(int prospectId) {
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
		return "SetProspectNCTResultItem [prospectId=" + prospectId + "]";
	}

}
