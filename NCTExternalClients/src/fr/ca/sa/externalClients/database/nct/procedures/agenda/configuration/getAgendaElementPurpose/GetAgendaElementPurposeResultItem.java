package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.getAgendaElementPurpose;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetAgendaElementPurposeResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer agendaElementPurposeId;
	private String agendaElementPurposeName;
	
	/**
	 * default constructor for Get Agenda Element Purpose Result Item
	 */
	public GetAgendaElementPurposeResultItem() {
		super();
	}

	/**
	 * Get Agenda Element Purpose Result Item
	 * 
	 * @param agendaElementPurposeId
	 * 				Agenda element purpose ID
	 * 
	 * @param agendaElementPurposeName
	 * 				Agenda element purpose name
	 */
	public GetAgendaElementPurposeResultItem(Integer agendaElementPurposeId, String agendaElementPurposeName) {
		super();
		this.agendaElementPurposeId = agendaElementPurposeId;
		this.agendaElementPurposeName = agendaElementPurposeName;
	}

	/**
	 * @return the agendaElementPurposeId
	 */
	public Integer getAgendaElementPurposeId() {
		return agendaElementPurposeId;
	}

	/**
	 * @param agendaElementPurposeId the agendaElementPurposeId to set
	 */
	public void setAgendaElementPurposeId(Integer agendaElementPurposeId) {
		this.agendaElementPurposeId = agendaElementPurposeId;
	}

	/**
	 * @return the agendaElementPurposeName
	 */
	public String getAgendaElementPurposeName() {
		return agendaElementPurposeName;
	}

	/**
	 * @param agendaElementPurposeName the agendaElementPurposeName to set
	 */
	public void setAgendaElementPurposeName(String agendaElementPurposeName) {
		this.agendaElementPurposeName = agendaElementPurposeName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GetAgendaElementPurposeResultItem [agendaElementPurposeId=" + agendaElementPurposeId
				+ ", agendaElementPurposeName=" + agendaElementPurposeName + "]";
	}
	
	

}
