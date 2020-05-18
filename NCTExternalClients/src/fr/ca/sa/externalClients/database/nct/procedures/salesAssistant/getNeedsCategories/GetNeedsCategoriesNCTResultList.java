package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getNeedsCategories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for needs list retrieved from database. Used in pair
 * with @GetNeedsNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetNeedsCategoriesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetNeedsCategoriesNCTResultItem> needsCategories;

	/**
	 * default constructor for Get Needs Categories NCT Result List
	 */
	public GetNeedsCategoriesNCTResultList() {
		this.needsCategories = new ArrayList<GetNeedsCategoriesNCTResultItem>();
	}

	/**
	 * Get Needs Categories NCT Result List
	 * 
	 * @param needsCategories
	 * 				Needs categories
	 */
	public GetNeedsCategoriesNCTResultList(List<GetNeedsCategoriesNCTResultItem> needsCategories) {
		super();
		this.needsCategories = needsCategories;
	}

	public List<GetNeedsCategoriesNCTResultItem> getNeedsCategories() {
		return needsCategories;
	}

	public void setNeedsCategories(List<GetNeedsCategoriesNCTResultItem> needsCategories) {
		this.needsCategories = needsCategories;
	}

	@Override
	public String toString() {
		return "GetNeedsCategoriesNCTResultList [needsCategories=" + needsCategories + "]";
	}

}
