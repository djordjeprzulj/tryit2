package fr.ca.sa.externalClients.database.nct.procedures.audit.getAuditData;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Holder client agenda elements, single item
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetAuditDataItem implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer collaboratorId;
	private String logContent;
	private String transDate;

	/**
	 * default constructor for Get Audit Data Item
	 */
	public GetAuditDataItem() {
		super();
	}

	/**
	 * Get Audit Data Item
	 * 
	 * @param collaboratorId
	 * 				Collaborator ID
	 * 
	 * @param logContent
	 * 				Log content
	 * 
	 * @param transDate
	 * 				Transaction date
	 */
	public GetAuditDataItem(Integer collaboratorId, String logContent, Date transDate) {
		super();
		this.collaboratorId = collaboratorId;
		this.logContent = logContent;

		if (transDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
			this.transDate = formatter.format(transDate);
		}
	}

	public Integer getCollaboratorId() {
		return collaboratorId;
	}

	public void setCollaboratorId(Integer collaboratorId) {
		this.collaboratorId = collaboratorId;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	@Override
	public String toString() {
		return "GetAuditDataItem [collaboratorId=" + collaboratorId + ", logContent=" + logContent + ", transDate="
				+ transDate + "]";
	}

}
