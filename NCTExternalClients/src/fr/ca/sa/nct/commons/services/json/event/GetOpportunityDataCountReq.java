package fr.ca.sa.nct.commons.services.json.event;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request JSON wrapper for opportunities data count
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunityDataCountReq implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<Integer> opportunityCategoryIds;
	private Integer opportunitySubcategoryId;
	private List<Integer> opportunityPrioritiesIds;
	private Integer branchId;
	private Integer advisorId;

	/**
	 * default constructor for Get Opportunity Data Count Request
	 */
	public GetOpportunityDataCountReq() {
		super();
	}

	/**
	 * Get Opportunity Data Count Request
	 *  
	 * @param opportunityCategoryIds
	 * 				Opportunity category IDs
	 * 
	 * @param opportunitySubcategoryId
	 * 				Opportunity subcategory ID
	 * 
	 * @param opportunityPrioritiesIds
	 * 				Opportunity priorities IDs
	 * 
	 * @param branchId
	 * 				Branch ID
	 * 
	 * @param advisorId
	 * 				Advisor ID
	 */
	public GetOpportunityDataCountReq(List<Integer> opportunityCategoryIds, Integer opportunitySubcategoryId,
			List<Integer> opportunityPrioritiesIds, Integer branchId, Integer advisorId) {
		super();

		this.opportunityCategoryIds = opportunityCategoryIds;
		this.opportunitySubcategoryId = opportunitySubcategoryId;
		this.opportunityPrioritiesIds = opportunityPrioritiesIds;
		this.branchId = branchId;
		this.advisorId = advisorId;
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

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Integer advisorId) {
		this.advisorId = advisorId;
	}

}
