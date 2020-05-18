package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response JSON wrapper for merged bank hierarchy object
 * 
 * @author Nemanja Ignjatov
 *
 */
public class BankBankMergedItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String bank;
	private List<BankRegionMergedItem> regions;
	private List<BankMainBranchMergedItem> mainBranches;
	private List<BankBranchMergedItem> branches;
	private List<Integer> advisors;

	/**
	 * default constructor for Bank Bank Merged Item
	 */
	public BankBankMergedItem() {
		super();
	}

	/**
	 * Bank Bank Merged Item
	 * 
	 * @param bank
	 * 				Bank
	 * 
	 * @param regions
	 * 				Regions
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
	public BankBankMergedItem(String bank, List<BankRegionMergedItem> regions,
			List<BankMainBranchMergedItem> mainBranches, List<BankBranchMergedItem> branches, List<Integer> advisors) {
		super();
		this.bank = bank;
		this.regions = regions;
		this.mainBranches = mainBranches;
		this.branches = branches;
		this.advisors = advisors;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public void setAdvisors(List<Integer> advisors) {
		this.advisors = advisors;
	}

	public List<Integer> getAdvisors() {
		return advisors;
	}

	public List<BankRegionMergedItem> getRegions() {
		return regions;
	}

	public void setRegions(List<BankRegionMergedItem> regions) {
		this.regions = regions;
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

}
