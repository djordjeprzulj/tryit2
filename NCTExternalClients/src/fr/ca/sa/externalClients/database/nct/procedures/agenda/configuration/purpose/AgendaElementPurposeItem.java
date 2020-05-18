package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.purpose;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda purpose item
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaElementPurposeItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int purposeId;

	private String purposeName;

	/**
	 * default constructor for Agenda Element Purpose Item
	 */
	public AgendaElementPurposeItem() {
		super();
	}

	/**
	 * Agenda Element Purpose Item
	 * 
	 * @param purposeId
	 * 				Purpose ID
	 * 
	 * @param purposeName
	 * 				Purpose name
	 */
	public AgendaElementPurposeItem(int purposeId, String purposeName) {
		super();
		this.purposeId = purposeId;
		this.purposeName = purposeName;
	}

	public int getPurposeId() {
		return purposeId;
	}

	public void setPurposeId(int purposeId) {
		this.purposeId = purposeId;
	}

	public String getPurposeName() {
		return purposeName;
	}

	public void setPurposeName(String purposeName) {
		this.purposeName = purposeName;
	}

	@Override
	public String toString() {
		return "AgendaElementPurposeItem [purposeId=" + purposeId + ", purposeName=" + purposeName + "]";
	}

}
