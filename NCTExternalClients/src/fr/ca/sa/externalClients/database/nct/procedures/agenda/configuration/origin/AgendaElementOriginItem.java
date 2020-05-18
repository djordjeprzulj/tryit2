package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.origin;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda origin item
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaElementOriginItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int originId;

	private String originName;

	/**
	 * default constructor for Agenda Element Origin Item
	 */
	public AgendaElementOriginItem() {
		super();
	}

	/**
	 * Agenda Element Origin Item
	 * 
	 * @param originId
	 * 				Origin ID
	 * 
	 * @param originName
	 * 				Origin name
	 */
	public AgendaElementOriginItem(int originId, String originName) {
		super();
		this.originId = originId;
		this.originName = originName;
	}

	public int getOriginId() {
		return originId;
	}

	public void setOriginId(int originId) {
		this.originId = originId;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	@Override
	public String toString() {
		return "AgendaElementOriginItem [originId=" + originId + ", originName=" + originName + "]";
	}

}
