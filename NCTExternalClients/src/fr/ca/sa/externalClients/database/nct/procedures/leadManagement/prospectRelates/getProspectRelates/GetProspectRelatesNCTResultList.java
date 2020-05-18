package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.prospectRelates.getProspectRelates;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetProspectRelatesNCTResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetProspectRelatesNCTResultItem> relatesList;

	/**
	 * default constructor for Get Prospect Relates NCT Result List
	 */
	public GetProspectRelatesNCTResultList() {
		super();
		this.relatesList = new ArrayList<>();
	}

	/**
	 * Get Prospect Relates NCT Result List
	 * 
	 * @param relatesList
	 * 				Relates list
	 */
	public GetProspectRelatesNCTResultList(List<GetProspectRelatesNCTResultItem> relatesList) {
		super();
		this.relatesList = relatesList;
	}

	public List<GetProspectRelatesNCTResultItem> getRelatesList() {
		return relatesList;
	}

	public void setRelatesList(List<GetProspectRelatesNCTResultItem> relatesList) {
		this.relatesList = relatesList;
	}

	@Override
	public String toString() {
		return "GetProspectRelatesNCTResultList [relatesList=" + relatesList + "]";
	}

}
