package fr.ca.sa.nct.commons.services.json.quickContactReport;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request for validating access to the QCR
 * 
 * @author Stefan Djokic
 *
 */
public class QuickContactReportAccessRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int clientId;
	private Integer portfolioId;
	private Integer entityId;
	private String clientType;

	/**
	 * default constructor for Quick Contact Report Access Request
	 */
	public QuickContactReportAccessRequest() {
		super();
	}

	/**
	 * Quick Contact Report Access Request
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 * 
	 * @param entityId
	 * 				Entity ID
	 * 
	 * @param clientType
	 * 				Client type
	 */
	public QuickContactReportAccessRequest(int clientId, Integer portfolioId, Integer entityId, String clientType) {
		super();
		this.clientId = clientId;
		this.portfolioId = portfolioId;
		this.entityId = entityId;
		this.clientType = clientType;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public Integer getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
}
