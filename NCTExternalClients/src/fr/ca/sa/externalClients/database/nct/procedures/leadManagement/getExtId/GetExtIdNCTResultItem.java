package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.getExtId;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning single item of prospect in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetExtIdNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	private String extId;
	
	/**
	 * Get External ID NCT Result Item
	 * 
	 * @param extId
	 * 				External ID
	 */
	public GetExtIdNCTResultItem(String extId) {
		super();
		this.extId = extId;
	}

	/**
	 * default constructor for Get External ID NCT Result Item
	 */
	public GetExtIdNCTResultItem() {
		super();
	}

	/**
	 * @return the extId
	 */
	public String getExtId() {
		return extId;
	}

	/**
	 * @param extId the extId to set
	 */
	public void setExtId(String extId) {
		this.extId = extId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GetExtIdNCTResultItem [extId=" + extId + "]";
	}
	
}
