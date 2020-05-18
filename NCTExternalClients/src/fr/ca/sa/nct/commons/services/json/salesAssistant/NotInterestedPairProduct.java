package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author sasa.radovanovic
 *
 */
public class NotInterestedPairProduct implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer productId;

	private Integer notIntReasonId;
	
	private Integer opportunityId;

	/**
	 * default constructor for Not Interested Pair Product
	 */
	public NotInterestedPairProduct() {
		super();
	}

	/**
	 * Not Interested Pair Product
	 * 
	 * @param productId
	 * 				Product ID
	 * 
	 * @param notIntReasonId
	 * 				Not interested reason ID
	 */
	public NotInterestedPairProduct(Integer productId, Integer notIntReasonId, Integer opportunityId) {
		super();
		this.productId = productId;
		this.notIntReasonId = notIntReasonId;
		this.opportunityId = opportunityId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getNotIntReasonId() {
		return notIntReasonId;
	}

	public void setNotIntReasonId(Integer notIntReasonId) {
		this.notIntReasonId = notIntReasonId;
	}

	public Integer getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(Integer opportunityId) {
		this.opportunityId = opportunityId;
	}

}
