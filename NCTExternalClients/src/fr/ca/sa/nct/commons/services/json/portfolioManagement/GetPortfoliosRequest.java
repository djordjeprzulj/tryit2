package fr.ca.sa.nct.commons.services.json.portfolioManagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.json.Target;
import fr.ca.sa.nct.commons.authorizationUtils.json.TargetAction;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetPortfoliosRequest implements Target, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int pageSize;
	private int pageIndex;
	private String orderColumnName;
	private String orderCriteria;
	private Integer entityId;
	private Integer advisorId;
	private Integer portfolioTypeId;
	private String portfolioCode;
	private Integer clientLead;
	private ArrayList<TargetAction> targetActionObjects;

	/**
	 * default constructor for Get Portfolios Request
	 */
	public GetPortfoliosRequest() {
		super();
	}

	
	/**
	 * 
	 * @param pageSize
	 * @param pageIndex
	 * @param orderColumnName
	 * @param orderCriteria
	 * @param entityId
	 * @param advisorId
	 * @param portfolioTypeId
	 * @param portfolioCode
	 * @param clientLead
	 * @param targetActionObjects
	 */
	public GetPortfoliosRequest(int pageSize, int pageIndex, String orderColumnName, String orderCriteria,
			Integer entityId, Integer advisorId, Integer portfolioTypeId, String portfolioCode, Integer clientLead) {
		super();
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
		this.orderColumnName = orderColumnName;
		this.orderCriteria = orderCriteria;
		this.entityId = entityId;
		this.advisorId = advisorId;
		this.portfolioTypeId = portfolioTypeId;
		this.portfolioCode = portfolioCode;
		this.clientLead = clientLead;
		
	}

	

	public int getPageSize() {
		return pageSize;
	}



	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}



	public int getPageIndex() {
		return pageIndex;
	}



	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}



	public String getOrderColumnName() {
		return orderColumnName;
	}



	public void setOrderColumnName(String orderColumnName) {
		this.orderColumnName = orderColumnName;
	}



	public String getOrderCriteria() {
		return orderCriteria;
	}



	public void setOrderCriteria(String orderCriteria) {
		this.orderCriteria = orderCriteria;
	}



	public Integer getEntityId() {
		return entityId;
	}



	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}



	public Integer getAdvisorId() {
		return advisorId;
	}



	public void setAdvisorId(Integer advisorId) {
		this.advisorId = advisorId;
	}



	public Integer getPortfolioTypeId() {
		return portfolioTypeId;
	}



	public void setPortfolioTypeId(Integer portfolioTypeId) {
		this.portfolioTypeId = portfolioTypeId;
	}



	public String getPortfolioCode() {
		return portfolioCode;
	}



	public void setPortfolioCode(String portfolioCode) {
		this.portfolioCode = portfolioCode;
	}



	public Integer getClientLead() {
		return clientLead;
	}



	public void setClientLead(Integer clientLead) {
		this.clientLead = clientLead;
	}


	@Override
	public String toString() {
		return "GetPortfoliosRequest [pageSize=" + pageSize + ", pageIndex=" + pageIndex + ", orderColumnName="
				+ orderColumnName + ", orderCriteria=" + orderCriteria + ", entityId=" + entityId + ", advisorId="
				+ advisorId + ", portfolioTypeId=" + portfolioTypeId + ", portfolioCode=" + portfolioCode
				+ ", clientLead=" + clientLead +  "]";
	}


	@Override
	public List<TargetAction> getTargetActionObjects() {
		return targetActionObjects;
	}

	@Override
	public void defineTargetActionObjects() {
	}

}
