package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.getAgendaElementPurpose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetAgendaElementPurposeResultItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetAgendaElementPurposeResultItem> purposeList;

	/**
	 * default constructor for Get Agenda Element Purpose Result Item List
	 */
	public GetAgendaElementPurposeResultItemList() {
		super();
		this.purposeList = new ArrayList<>();
	}

	/**
	 * Get Agenda Element Purpose Result Item List
	 * 
	 * @param purposeList
	 * 				Purpose list
	 */
	public GetAgendaElementPurposeResultItemList(List<GetAgendaElementPurposeResultItem> purposeList) {
		super();
		this.purposeList = purposeList;
	}

	/**
	 * @return the purposeList
	 */
	public List<GetAgendaElementPurposeResultItem> getPurposeList() {
		return purposeList;
	}

	/**
	 * @param purposeList the purposeList to set
	 */
	public void setPurposeList(List<GetAgendaElementPurposeResultItem> purposeList) {
		this.purposeList = purposeList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GetAgendaElementPurposeResultItemList [purposeList=" + purposeList + "]";
	}


	
}
