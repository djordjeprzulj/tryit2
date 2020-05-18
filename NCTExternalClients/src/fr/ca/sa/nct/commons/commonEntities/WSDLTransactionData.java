package fr.ca.sa.nct.commons.commonEntities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * Class that represents WSDL transaction data information
 */
public class WSDLTransactionData implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	private Integer transactId;
	private Integer collaboratorId;
	private Integer clientId;
	private String startSessionDate;
	private String endSessionDate;
	private String errorDescription;

	/**
	 * default constructor WSDL Transaction Data
	 */
	public WSDLTransactionData() {
		super();
	}

	/**
	 * WSDL Transaction Data
	 * 
	 * @param transactId       Transaction ID
	 * 
	 * @param collaboratorId   Collaborator ID
	 * 
	 * @param clientId         Client ID
	 * 
	 * @param startSessionDate Start session date
	 * 
	 * @param endSessionDate   End session date
	 * 
	 * @param xmlData          XML date
	 * 
	 * @param errorDescription Error description
	 */
	public WSDLTransactionData(Integer transactId, Integer collaboratorId, Integer clientId, String startSessionDate,
			String endSessionDate, String errorDescription) {
		super();
		this.transactId = transactId;
		this.collaboratorId = collaboratorId;
		this.clientId = clientId;
		this.startSessionDate = startSessionDate;
		this.endSessionDate = endSessionDate;
		this.errorDescription = errorDescription;
	}

	public Integer getTransactId() {
		return transactId;
	}

	public void setTransactId(Integer transactId) {
		this.transactId = transactId;
	}

	public Integer getCollaboratorId() {
		return collaboratorId;
	}

	public void setCollaboratorId(Integer collaboratorId) {
		this.collaboratorId = collaboratorId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getStartSessionDate() {
		return startSessionDate;
	}

	public void setStartSessionDate(Date startSessionDate) {
		if (startSessionDate != null) {
			DateFormat df = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
			this.startSessionDate = df.format(startSessionDate);
		}
	}

	public String getEndSessionDate() {
		return endSessionDate;
	}

	public void setEndSessionDate(Date endSessionDate) {
		if (endSessionDate != null) {
			DateFormat df = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
			this.endSessionDate = df.format(endSessionDate);
		}
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public void setStartSessionDate(String startSessionDate) {
		this.startSessionDate = startSessionDate;
	}

	public void setEndSessionDate(String endSessionDate) {
		this.endSessionDate = endSessionDate;
	}

	@Override
	public String toString() {
		return "WSDLTransactionData [transactId=" + transactId + ", collaboratorId=" + collaboratorId + ", clientId="
				+ clientId + ", startSessionDate=" + startSessionDate + ", endSessionDate=" + endSessionDate + "]";
	}

}
