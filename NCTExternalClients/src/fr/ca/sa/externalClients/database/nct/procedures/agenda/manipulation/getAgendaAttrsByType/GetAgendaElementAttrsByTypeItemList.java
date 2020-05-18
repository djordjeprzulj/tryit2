package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaAttrsByType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Get agenda element attributes by item type list
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetAgendaElementAttrsByTypeItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetAgendaElementAttrsByTypeItem> elementAttrList;

	/**
	 * Get Agenda Element Attributes By Type Item List
	 * 
	 * @param elementAttrList
	 */
	public GetAgendaElementAttrsByTypeItemList(List<GetAgendaElementAttrsByTypeItem> elementAttrList) {
		super();
		this.elementAttrList = elementAttrList;
	}

	/**
	 * default constructor for Get Agenda Element Attributes By Type Item List
	 */
	public GetAgendaElementAttrsByTypeItemList() {
		super();
		this.elementAttrList = new ArrayList<>();
	}

	public List<GetAgendaElementAttrsByTypeItem> getElementAttrList() {
		return elementAttrList;
	}

	public void setElementAttrList(List<GetAgendaElementAttrsByTypeItem> elementAttrList) {
		this.elementAttrList = elementAttrList;
	}

	@Override
	public String toString() {
		return "GetAgendaElementAttrsByTypeItemList [elementAttrList=" + elementAttrList + "]";
	}

}
