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
public class GetPortfolioDetailsRequest implements Target, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int pageSize;
	private int pageIndex;
	private String orderColumnName;
	private String orderCriteria;
	private Integer portfolioId;
	private Integer clientTypeId;
	private Integer clientSegmentId;
	private String clientCode;

	private ArrayList<TargetAction> targetActionObjects;

	/**
	 * default constructor for Get Portfolio Details Request
	 */
	public GetPortfolioDetailsRequest() {
		super();
	}

	/**
	 * Get Portfolio Details Request
	 * 
	 * @param pageSize
	 * 				Page size
	 * 
	 * @param pageIndex
	 * 				Page index
	 * 
	 * @param orderColumnName
	 * 				Order column name
	 * 
	 * @param orderCriteria
	 * 				Order criteria
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 * 
	 * @param clientTypeId
	 * 				Client type ID
	 * 
	 * @param clientSegmentId
	 * 				Client segment ID
	 * 
	 * @param clientCode
	 * 				Client code
	 */
	public GetPortfolioDetailsRequest(int pageSize, int pageIndex, String orderColumnName, String orderCriteria,
			Integer portfolioId, Integer clientTypeId, Integer clientSegmentId, String clientCode) {
		super();
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
		this.orderColumnName = orderColumnName;
		this.orderCriteria = orderCriteria;
		this.portfolioId = portfolioId;
		this.clientTypeId = clientTypeId;
		this.clientSegmentId = clientSegmentId;
		this.clientCode=clientCode;
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

	public Integer getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getOrderCriteria() {
		return orderCriteria;
	}

	public void setOrderCriteria(String orderCriteria) {
		this.orderCriteria = orderCriteria;
	}

	public Integer getClientTypeId() {
		return clientTypeId;
	}

	public void setClientTypeId(Integer clientTypeId) {
		this.clientTypeId = clientTypeId;
	}

	public Integer getClientSegmentId() {
		return clientSegmentId;
	}

	public void setClientSegmentId(Integer clientSegmentId) {
		this.clientSegmentId = clientSegmentId;
	}

	@Override
	public List<TargetAction> getTargetActionObjects() {
		return targetActionObjects;
	}

	@Override
	public void defineTargetActionObjects() {
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	

}
