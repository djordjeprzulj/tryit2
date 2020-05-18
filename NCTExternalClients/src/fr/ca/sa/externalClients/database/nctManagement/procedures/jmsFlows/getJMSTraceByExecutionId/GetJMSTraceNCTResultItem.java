package fr.ca.sa.externalClients.database.nctManagement.procedures.jmsFlows.getJMSTraceByExecutionId;

import java.io.Serializable;
import java.util.Date;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 *
 * Wrapper class for single result in result set from
 * batchTrace.spGetJMSTraceByExecutionId store procedure
 * 
 * @author Nemanja Ignjatov
 */
public class GetJMSTraceNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int jmsId;
		private String messageId;
		private String correlationId;
		private Date traceTimeStamp;
		private String description;


	/**
	 * default constructor for Get JMS Trace NCT Result Item
	 */
	public GetJMSTraceNCTResultItem() {
		super();
	}


	public GetJMSTraceNCTResultItem(int jmsId, String messageId, String correlationId, Date traceTimeStamp,
			String description) {
		super();
		this.jmsId = jmsId;
		this.messageId = messageId;
		this.correlationId = correlationId;
		this.traceTimeStamp = traceTimeStamp;
		this.description = description;
	}


	public int getJmsId() {
		return jmsId;
	}


	public void setJmsId(int jmsId) {
		this.jmsId = jmsId;
	}


	public String getMessageId() {
		return messageId;
	}


	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}


	public String getCorrelationId() {
		return correlationId;
	}


	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}


	public Date getTraceTimeStamp() {
		return traceTimeStamp;
	}


	public void setTraceTimeStamp(Date traceTimeStamp) {
		this.traceTimeStamp = traceTimeStamp;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "GetJMSTraceNCTResultItem [jmsId=" + jmsId + ", messageId=" + messageId + ", correlationId="
				+ correlationId + ", traceTimeStamp=" + traceTimeStamp + ", description=" + description + "]";
	}

	

}
