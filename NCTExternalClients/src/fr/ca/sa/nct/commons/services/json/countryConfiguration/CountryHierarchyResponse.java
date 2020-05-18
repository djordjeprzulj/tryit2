package fr.ca.sa.nct.commons.services.json.countryConfiguration;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.advisors.GetAdvisorsNCTResultItem;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankEntities.GetBankEntitiesNCTResultItem;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankSegments.GetBankSegmentsNCTResultItem;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.clientTypes.GetClientTypesNCTResultItem;

/**
 * 
 * Response JSON wrapper for merged bank entities hierarchy
 * 
 * 
 * @author Nemanja Ignjatov
 *
 */
public class CountryHierarchyResponse implements Serializable {
	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<BankBankMergedItem> banks;
	private List<BankRegionMergedItem> regions;
	private List<BankMainBranchMergedItem> mainBranches;
	private List<BankBranchMergedItem> branches;
	private List<GetAdvisorsNCTResultItem> advisors;
	private List<GetBankEntitiesNCTResultItem> entities;
	private List<GetClientTypesNCTResultItem> clientTypes;
	private List<GetBankSegmentsNCTResultItem> bankSegments;

	/**
	 * default constructor for Country Hierarchy Response
	 */
	public CountryHierarchyResponse() {
		super();
	}

	/**
	 * Country Hierarchy Response
	 * 
	 * @param banks
	 * 				Banks
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
	 * 
	 * @param entities
	 * 				Entities
	 * 
	 * @param clientTypes
	 * 				Client types
	 * 
	 * @param bankSegments
	 * 				Bank segments
	 */
	public CountryHierarchyResponse(List<BankBankMergedItem> banks, List<BankRegionMergedItem> regions,
			List<BankMainBranchMergedItem> mainBranches, List<BankBranchMergedItem> branches,
			List<GetAdvisorsNCTResultItem> advisors, List<GetBankEntitiesNCTResultItem> entities,
			List<GetClientTypesNCTResultItem> clientTypes, List<GetBankSegmentsNCTResultItem> bankSegments) {
		super();
		this.banks = banks;
		this.regions = regions;
		this.mainBranches = mainBranches;
		this.branches = branches;
		this.advisors = advisors;
		this.entities = entities;
		this.clientTypes = clientTypes;
		this.bankSegments = bankSegments;
	}

	public List<GetAdvisorsNCTResultItem> getAdvisors() {
		return advisors;
	}

	public void setAdvisors(List<GetAdvisorsNCTResultItem> advisors) {
		this.advisors = advisors;
	}

	public List<BankRegionMergedItem> getRegions() {
		return regions;
	}

	public void setRegions(List<BankRegionMergedItem> regions) {
		this.regions = regions;
	}

	public List<BankBranchMergedItem> getBranches() {
		return branches;
	}

	public void setBranches(List<BankBranchMergedItem> branches) {
		this.branches = branches;
	}

	public List<BankBankMergedItem> getBanks() {
		return banks;
	}

	public void setBanks(List<BankBankMergedItem> banks) {
		this.banks = banks;
	}

	public List<BankMainBranchMergedItem> getMainBranches() {
		return mainBranches;
	}

	public void setMainBranches(List<BankMainBranchMergedItem> mainBranches) {
		this.mainBranches = mainBranches;
	}

	public List<GetBankEntitiesNCTResultItem> getEntities() {
		return entities;
	}

	public void setEntities(List<GetBankEntitiesNCTResultItem> entities) {
		this.entities = entities;
	}

	public List<GetClientTypesNCTResultItem> getClientTypes() {
		return clientTypes;
	}

	public void setClientTypes(List<GetClientTypesNCTResultItem> clientTypes) {
		this.clientTypes = clientTypes;
	}

	public List<GetBankSegmentsNCTResultItem> getBankSegments() {
		return bankSegments;
	}

	public void setBankSegments(List<GetBankSegmentsNCTResultItem> bankSegments) {
		this.bankSegments = bankSegments;
	}

}
