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
public class GetOpportunityDataReq extends GetOpportunityDataMyTasksReq implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int pageIndex;
	private int branchId;
	private Integer advisorId;

	/**
	 * default constructor for Get Opportunity Data Request
	 */
	public GetOpportunityDataReq() {
		super();
	}

	/**
	 * Get Opportunity Data Request
	 * 
	 * @param pageSize                 Page size
	 * 
	 * @param pageIndex                Page index
	 * 
	 * @param orderColumnName          Order column name
	 * 
	 * @param orderCriteria            Order criteria
	 * 
	 * @param opportunityCategoryIds   Opportunity category IDs
	 * 
	 * @param opportunitySubcategoryId Opportunity subcategory ID
	 * 
	 * @param opportunityPrioritiesIds Opportunity priorities IDs
	 * 
	 * @param branchId                 Branch ID
	 * 
	 * @param advisorId                Advisor ID
	 * 
	 * @param segmentId                Segment ID
	 * 
	 * @param firstName                First name
	 * 
	 * @param famlilyName              Last name
	 * 
	 * @param clientCode               Client code
	 * 
	 * @param contactPriority          Contact priority
	 * 
	 * @param familyName               Family name
	 */
	public GetOpportunityDataReq(int pageSize, int pageIndex, String orderColumnName, String orderCriteria,
			List<Integer> opportunityCategoryIds, Integer opportunitySubcategoryId,
			List<Integer> opportunityPrioritiesIds, int branchId, Integer advisorId, Integer segmentId,
			String firstName, String familyName, String clientCode, Integer contactPriority) {
		super(pageSize, orderColumnName, orderCriteria, opportunityCategoryIds, opportunitySubcategoryId,
				opportunityPrioritiesIds, segmentId, firstName, familyName, clientCode, contactPriority);
		this.pageIndex = pageIndex;
		this.branchId = branchId;
		this.advisorId = advisorId;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public Integer getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Integer advisorId) {
		this.advisorId = advisorId;
	}

}
