package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response JSON wrapper for merged main bank hierarchy object
 * 
 * 
 * @author Nemanja Ignjatov
 *
 */
public class BankMainBranchMergedItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String mainBranch;
	private String parentEntityCode;
	private List<BankBranchMergedItem> branches;
	private List<Integer> advisors;

	/**
	 * default constructor for Bank Main Branch Merged Item
	 */
	public BankMainBranchMergedItem() {
		super();
	}

	/**
	 * Main Branch Merged Item
	 * 
	 * @param mainBranch
	 * 				Main branch
	 * 
	 * @param parentEntityCode
	 * 				Parent entity code
	 * 
	 * @param branches
	 * 				Branches
	 * 
	 * @param advisors
	 * 				Advisors
	 */
	public BankMainBranchMergedItem(String mainBranch, String parentEntityCode, List<BankBranchMergedItem> branches,
			List<Integer> advisors) {
		super();
		this.mainBranch = mainBranch;
		this.parentEntityCode = parentEntityCode;
		this.branches = branches;
		this.advisors = advisors;
	}

	public String getMainBranch() {
		return mainBranch;
	}

	public void setMainBranch(String mainBranch) {
		this.mainBranch = mainBranch;
	}

	public String getParentEntityCode() {
		return parentEntityCode;
	}

	public void setParentEntityCode(String parentEntityCode) {
		this.parentEntityCode = parentEntityCode;
	}

	public List<Integer> getAdvisors() {
		return advisors;
	}

	public void setAdvisors(List<Integer> advisors) {
		this.advisors = advisors;
	}

	public List<BankBranchMergedItem> getBranches() {
		return branches;
	}

	public void setBranches(List<BankBranchMergedItem> branches) {
		this.branches = branches;
	}

}
