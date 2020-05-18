package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class CodeTablesConfigurationContainer implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<OpportunityCategoryContainer> opportunityCategories;

	/**
	 * default constructor for CodeTables Configuration Container
	 */
	public CodeTablesConfigurationContainer() {
		super();
		this.opportunityCategories = new ArrayList<OpportunityCategoryContainer>();
	}

	/**
	 * CodeTables Configuration Container
	 * 
	 * @param opportunityCategories
	 * 				Opportunity categories
	 */
	public CodeTablesConfigurationContainer(List<OpportunityCategoryContainer> opportunityCategories) {
		super();
		this.opportunityCategories = opportunityCategories;
	}

	public List<OpportunityCategoryContainer> getOpportunityCategories() {
		return opportunityCategories;
	}

	/**
	 * CodeTables Configuration Container
	 * 
	 * @param opportunityCategories
	 * 				Opportunity categories
	 */
	public void setOpportunityCategories(List<OpportunityCategoryContainer> opportunityCategories) {
		this.opportunityCategories = opportunityCategories;
	}

	@Override
	public String toString() {
		return "CodeTablesConfigurationContainer [opportunityCategories=" + opportunityCategories + "]";
	}

}
