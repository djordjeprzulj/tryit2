package fr.ca.sa.nct.commons.services.json.event;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request JSON wrapper for opportunities data
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunityDataMyTasksReq implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int pageSize;
	private String orderColumnName;
	private String orderCriteria;
	
	private List<Integer> opportunityCategoryIds;
	
	private Integer opportunitySubcategoryId;
	private List<Integer> opportunityPrioritiesIds;
	
	private Integer segmentId;
	
	private String firstName;
	private String familyName;
	private String clientCode;
	private Integer contactPriority;

	/**
	 * default constructor for Get Opportunity Data Request
	 */
	public GetOpportunityDataMyTasksReq() {
		super();
	}

	/**
	 * Get Opportunity Data My Tasks Req
	 * 
	 * @param pageSize
	 * 			Page size
	 * 
	 * @param orderColumnName
	 * 			Order column name
	 * 
	 * @param orderCriteria
	 * 			Order criteria
	 * 
	 * @param opportunityCategoryIds
	 * 			Opportunity category IDs
	 * 
	 * @param opportunitySubcategoryId
	 * 			Opportunity subcategory ID
	 * 
	 * @param opportunityPrioritiesIds
	 * 			Opportunity priorities IDs
	 * 
	 * @param segmentId
	 * 			Segment ID
	 * 
	 * @param firstName
	 * 			First name
	 * 
	 * @param familyName
	 * 			Family name
	 * 
	 * @param clientCode
	 * 			Client code
	 * 
	 * @param contactPriority
	 * 			Contact priority
	 */
	public GetOpportunityDataMyTasksReq(int pageSize, String orderColumnName, String orderCriteria,
			List<Integer> opportunityCategoryIds, Integer opportunitySubcategoryId,
			List<Integer> opportunityPrioritiesIds, Integer segmentId, String firstName, String familyName,
			String clientCode, Integer contactPriority) {
		super();
		this.pageSize = pageSize;
		this.orderColumnName = orderColumnName;
		this.orderCriteria = orderCriteria;
		this.opportunityCategoryIds = opportunityCategoryIds;
		this.opportunitySubcategoryId = opportunitySubcategoryId;
		this.opportunityPrioritiesIds = opportunityPrioritiesIds;
		this.segmentId = segmentId;
		this.firstName = firstName;
		this.familyName = familyName;
		this.clientCode = clientCode;
		this.contactPriority = contactPriority;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderColumnName() {
		return orderColumnName;
	}

	public void setOrderColumnName(String orderColumnName) {
		this.orderColumnName = orderColumnName;
	}

	public List<Integer> getOpportunityCategoryIds() {
		return opportunityCategoryIds;
	}

	public void setOpportunityCategoryIds(List<Integer> opportunityCategoryIds) {
		this.opportunityCategoryIds = opportunityCategoryIds;
	}

	public Integer getOpportunitySubcategoryId() {
		return opportunitySubcategoryId;
	}

	public void setOpportunitySubcategoryId(Integer opportunitySubcategoryId) {
		this.opportunitySubcategoryId = opportunitySubcategoryId;
	}

	public List<Integer> getOpportunityPrioritiesIds() {
		return opportunityPrioritiesIds;
	}

	public void setOpportunityPrioritiesIds(List<Integer> opportunityPrioritiesIds) {
		this.opportunityPrioritiesIds = opportunityPrioritiesIds;
	}

	public Integer getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(Integer segmentId) {
		this.segmentId = segmentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public Integer getContactPriority() {
		return contactPriority;
	}

	public void setContactPriority(Integer contactPriority) {
		this.contactPriority = contactPriority;
	}

	public String getOrderCriteria() {
		return orderCriteria;
	}

	public void setOrderCriteria(String orderCriteria) {
		this.orderCriteria = orderCriteria;
	}
}
