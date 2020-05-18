package fr.ca.sa.externalClients.database.nct.procedures.getNctId;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetNctIdNCTResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer nctId;

	/**
	 * default constructor for Get Nct Id NCT Result Item
	 */
	public GetNctIdNCTResultItem() {
		super();
	}

	/**
	 * Get Nct Id NCT Result Item
	 * 
	 * @param nctId
	 * 			NCT ID
	 */
	public GetNctIdNCTResultItem(Integer nctId) {
		super();
		this.nctId = nctId;
	}

	public Integer getNctId() {
		return nctId;
	}

	public void setNctId(Integer nctId) {
		this.nctId = nctId;
	}

	@Override
	public String toString() {
		return "GetNctIdNCTResultItem [nctId=" + nctId + "]";
	}
}
