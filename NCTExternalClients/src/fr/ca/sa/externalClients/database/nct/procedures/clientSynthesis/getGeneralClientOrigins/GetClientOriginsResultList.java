package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getGeneralClientOrigins;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Result holder for client origins list
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientOriginsResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetClientOriginsResultItem> origins;

	/**
	 * default constructor for Get Client Origins Result List
	 */
	public GetClientOriginsResultList() {
		super();
		this.origins = new ArrayList<>();
	}

	/**
	 * Get Client Origins Result List
	 * 
	 * @param origins
	 * 				Origins
	 */
	public GetClientOriginsResultList(List<GetClientOriginsResultItem> origins) {
		super();
		this.origins = origins;
	}

	public List<GetClientOriginsResultItem> getOrigins() {
		return origins;
	}

	public void setOrigins(List<GetClientOriginsResultItem> origins) {
		this.origins = origins;
	}

	@Override
	public String toString() {
		return "GetClientOriginsResultList [origins=" + origins + "]";
	}

}
