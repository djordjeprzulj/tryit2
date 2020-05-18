package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getSubcategories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * List of opportunities subcategories fetched from DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunitiesSubcategoriesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetOpportunitiesSubcategoriesNCTResultItem> subcategories;

	/**
	 * default constructor for Get Opportunities Subcategories NCT Result List
	 */
	public GetOpportunitiesSubcategoriesNCTResultList() {
		this.subcategories = new ArrayList<GetOpportunitiesSubcategoriesNCTResultItem>();
	}

	/**
	 * Get Opportunities Subcategories NCT Result List
	 * 
	 * @param subcategories
	 * 				Subcategories
	 */
	public GetOpportunitiesSubcategoriesNCTResultList(
			List<GetOpportunitiesSubcategoriesNCTResultItem> subcategories) {
		super();
		this.subcategories = subcategories;
	}

	public List<GetOpportunitiesSubcategoriesNCTResultItem> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<GetOpportunitiesSubcategoriesNCTResultItem> subcategories) {
		this.subcategories = subcategories;
	}

	@Override
	public String toString() {
		return "GetOpportunitiesSubcategoriesNCTResultList [subcategories=" + subcategories + "]";
	}

}
