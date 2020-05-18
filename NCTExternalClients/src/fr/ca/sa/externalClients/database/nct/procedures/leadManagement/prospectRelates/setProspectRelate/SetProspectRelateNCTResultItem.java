package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.prospectRelates.setProspectRelate;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning prospect relate Id
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetProspectRelateNCTResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int relateId;

	/**
	 * default constructor for Set Prospect Relate NCT Result Item
	 */
	public SetProspectRelateNCTResultItem() {
		super();
	}

	/**
	 * Set Prospect Relate NCT Result Item
	 * 
	 * @param relateId
	 * 				Relate ID
	 */
	public SetProspectRelateNCTResultItem(int relateId) {
		super();
		this.relateId = relateId;
	}

	public int getRelateId() {
		return relateId;
	}

	public void setRelateId(int relateId) {
		this.relateId = relateId;
	}

	@Override
	public String toString() {
		return "SetProspectRelateNCTResultItem [relateId=" + relateId + "]";
	}

}
