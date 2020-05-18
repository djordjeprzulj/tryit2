package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getCategories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * List of opportunities categories fetched from DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunitiesCategoriesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetOpportunitiesCategoriesNCTResultItem> categories;

	/**
	 * default constructor for Get Opportunities Categories NCT Result List
	 */
	public GetOpportunitiesCategoriesNCTResultList() {
		this.categories = new ArrayList<GetOpportunitiesCategoriesNCTResultItem>();
	}

	/**
	 * Get Opportunities Categories NCT Result List
	 * 
	 * @param categories
	 * 				Categories
	 */
	public GetOpportunitiesCategoriesNCTResultList(List<GetOpportunitiesCategoriesNCTResultItem> categories) {
		super();
		this.categories = categories;
	}

	public List<GetOpportunitiesCategoriesNCTResultItem> getCategories() {
		return categories;
	}

	public void setCategories(List<GetOpportunitiesCategoriesNCTResultItem> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "GetOpportunitiesCategoriesNCTResultList [categories=" + categories + "]";
	}

}
