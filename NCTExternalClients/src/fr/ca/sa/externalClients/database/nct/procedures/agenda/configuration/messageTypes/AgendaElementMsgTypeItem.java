package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.messageTypes;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Agenda message type single item
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaElementMsgTypeItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int msgTypeId;

	private String msgTypeName;

	/**
	 * default constructor for Agenda Element Message Type Item
	 */
	public AgendaElementMsgTypeItem() {
		super();
	}

	/**
	 * Agenda Element Message Type Item
	 * 
	 * @param msgTypeId
	 * 				Message type ID
	 * 
	 * @param msgTypeName
	 * 				Message type name
	 */
	public AgendaElementMsgTypeItem(int msgTypeId, String msgTypeName) {
		super();
		this.msgTypeId = msgTypeId;
		this.msgTypeName = msgTypeName;
	}

	public int getMsgTypeId() {
		return msgTypeId;
	}

	public void setMsgTypeId(int msgTypeId) {
		this.msgTypeId = msgTypeId;
	}

	public String getMsgTypeName() {
		return msgTypeName;
	}

	public void setMsgTypeName(String msgTypeName) {
		this.msgTypeName = msgTypeName;
	}

	@Override
	public String toString() {
		return "AgendaElementMsgTypeItem [msgTypeId=" + msgTypeId + ", msgTypeName=" + msgTypeName + "]";
	}
}
