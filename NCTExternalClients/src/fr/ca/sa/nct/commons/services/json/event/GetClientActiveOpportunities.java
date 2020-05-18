package fr.ca.sa.nct.commons.services.json.event;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Get Client active opportunities request
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetClientActiveOpportunities implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer clientId;

	private Integer entityId;

	private Integer portfolioId;

	/**
	 * default constructor for Get Client Active Opportunities
	 */
	public GetClientActiveOpportunities() {
		super();
	}

	/**
	 * Get Client Active Opportunities
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param entityId
	 * 				Entity ID
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 */
	public GetClientActiveOpportunities(Integer clientId, Integer entityId, Integer portfolioId) {
		super();
		this.clientId = clientId;
		this.entityId = entityId;
		this.portfolioId = portfolioId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public Integer getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}
}
