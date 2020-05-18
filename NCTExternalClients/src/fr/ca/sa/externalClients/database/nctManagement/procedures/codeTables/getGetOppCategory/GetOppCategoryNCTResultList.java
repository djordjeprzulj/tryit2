package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getGetOppCategory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Stefan Djokic
 *
 */
public class GetOppCategoryNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetOppCategoryNCTResultItem> opportunityCategories;

	/**
	 * default constructor for Get Opportunity Category NCT Result List
	 */
	public GetOppCategoryNCTResultList() {
		super();
		this.opportunityCategories = new ArrayList<GetOppCategoryNCTResultItem>();
	}

	/**
	 * Get Opportunity Category NCT Result List
	 * 
	 * @param opportunityCategories
	 * 					Opportunity categories
	 */
	public GetOppCategoryNCTResultList(List<GetOppCategoryNCTResultItem> opportunityCategories) {
		super();
		this.opportunityCategories = opportunityCategories;
	}

	public List<GetOppCategoryNCTResultItem> getOpportunityCategories() {
		return opportunityCategories;
	}

	public void setOpportunityCategories(List<GetOppCategoryNCTResultItem> opportunityCategories) {
		this.opportunityCategories = opportunityCategories;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetOppCategoryNCTResultList [ ");

		if (this.opportunityCategories != null) {
			for (GetOppCategoryNCTResultItem item : this.opportunityCategories) {
				sbRetValue.append(item.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetOppCategoryNCTResultList is empty!!!";
	}

}
