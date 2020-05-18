package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response JSON wrapper for merged branch hierarchy object
 * 
 * 
 * @author Nemanja Ignjatov
 *
 */
public class BankBranchMergedItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String branch;
	private String parentEntityCode;
	private List<Integer> advisors;

	/**
	 * default constructor for Bank Branch Merged Item
	 */
	public BankBranchMergedItem() {
		super();
		this.advisors = new ArrayList<Integer>();
	}

	/**
	 * Bank Branch Merged Item
	 * 
	 * @param branch
	 * 				Branch
	 * 
	 * @param parentEntityCode
	 * 				Parent entity code
	 * 
	 * @param advisors
	 * 				Advisors
	 */
	public BankBranchMergedItem(String branch, String parentEntityCode, List<Integer> advisors) {
		super();
		this.branch = branch;
		this.parentEntityCode = parentEntityCode;
		this.advisors = advisors;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
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

}
