package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response JSON wrapper for merged region hierarchy object
 * 
 * 
 * @author Nemanja Ignjatov
 *
 */
public class BankRegionMergedItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String region;
	private String parentEntityCode;
	private List<BankMainBranchMergedItem> mainBranches;
	private List<BankBranchMergedItem> branches;
	private List<Integer> advisors;

	/**
	 * default constructor for Bank Region Merged Item
	 */
	public BankRegionMergedItem() {
		super();
	}

	/**
	 * Bank Region Merged Item
	 * 
	 * @param region
	 * 				Region
	 * 
	 * @param parentEntityCode
	 * 				Parent entity code
	 * 
	 * @param mainBranches
	 * 				Main branches
	 * 
	 * @param branches
	 * 				Branches
	 * 
	 * @param advisors
	 * 				Advisors
	 */
	public BankRegionMergedItem(String region, String parentEntityCode, List<BankMainBranchMergedItem> mainBranches,
			List<BankBranchMergedItem> branches, List<Integer> advisors) {
		super();
		this.region = region;
		this.parentEntityCode = parentEntityCode;
		this.mainBranches = mainBranches;
		this.branches = branches;
		this.advisors = advisors;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getParentEntityCode() {
		return parentEntityCode;
	}

	public void setParentEntityCode(String parentEntityCode) {
		this.parentEntityCode = parentEntityCode;
	}

	public List<BankMainBranchMergedItem> getMainBranches() {
		return mainBranches;
	}

	public void setMainBranches(List<BankMainBranchMergedItem> mainBranches) {
		this.mainBranches = mainBranches;
	}

	public List<BankBranchMergedItem> getBranches() {
		return branches;
	}

	public void setBranches(List<BankBranchMergedItem> branches) {
		this.branches = branches;
	}

	public List<Integer> getAdvisors() {
		return advisors;
	}

	public void setAdvisors(List<Integer> advisors) {
		this.advisors = advisors;
	}

}
