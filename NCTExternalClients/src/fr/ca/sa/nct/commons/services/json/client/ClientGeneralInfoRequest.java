package fr.ca.sa.nct.commons.services.json.client;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request for general client info
 * 
 * @author Sasa Radovanovic
 *
 */
public class ClientGeneralInfoRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	protected int clientId;

	protected Integer portfolioId;

	protected Integer entityId;

	protected String clientType;

	/**
	 * default constructor for Client General Info Request
	 */
	public ClientGeneralInfoRequest() {
		super();
	}

	/**
	 * Client General Info Request
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
	public ClientGeneralInfoRequest(int clientId, Integer portfolioId, Integer entityId, String clientType) {
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
