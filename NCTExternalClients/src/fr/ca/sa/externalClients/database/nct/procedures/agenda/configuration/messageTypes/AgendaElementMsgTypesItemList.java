package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.messageTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda message types option list
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaElementMsgTypesItemList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<AgendaElementMsgTypeItem> msgTypesList = new ArrayList<>();

	/**
	 * default constructor for Agenda Element Message Types Item List
	 */
	public AgendaElementMsgTypesItemList() {
		super();
		this.msgTypesList = new ArrayList<>();
	}

	/**
	 * Agenda Element Message Types Item List
	 * 
	 * @param msgTypesList
	 * 				Message types list
	 */
	public AgendaElementMsgTypesItemList(List<AgendaElementMsgTypeItem> msgTypesList) {
		super();
		this.msgTypesList = msgTypesList;
	}

	public List<AgendaElementMsgTypeItem> getMsgTypesList() {
		return msgTypesList;
	}

	public void setMsgTypesList(List<AgendaElementMsgTypeItem> msgTypesList) {
		this.msgTypesList = msgTypesList;
	}

	@Override
	public String toString() {
		return "AgendaMsgTypesItemList [msgTypesList=" + msgTypesList + "]";
	}

}
