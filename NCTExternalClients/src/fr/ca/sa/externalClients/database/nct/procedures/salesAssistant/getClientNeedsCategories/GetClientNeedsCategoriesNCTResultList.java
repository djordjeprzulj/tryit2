package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientNeedsCategories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Data holder for needs list retrieved from database. Used in pair
 * with @GetClientNeedsCategoriesNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientNeedsCategoriesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetClientNeedsCategoriesNCTResultItem> needsCategories;

	/**
	 * default constructor for Get Client Needs Categories NCT Result List
	 */
	public GetClientNeedsCategoriesNCTResultList() {
		this.needsCategories = new ArrayList<GetClientNeedsCategoriesNCTResultItem>();
	}

	/**
	 * Get Client Needs Categories NCT Result List
	 * 
	 * @param needsCategories
	 * 				Needs categories
	 */
	public GetClientNeedsCategoriesNCTResultList(List<GetClientNeedsCategoriesNCTResultItem> needsCategories) {
		super();
		this.needsCategories = needsCategories;
	}

	public List<GetClientNeedsCategoriesNCTResultItem> getNeedsCategories() {
		return needsCategories;
	}

	public void setNeedsCategories(List<GetClientNeedsCategoriesNCTResultItem> needsCategories) {
		this.needsCategories = needsCategories;
	}

	@Override
	public String toString() {
		return "GetClientNeedsCategoriesNCTResultList [needsCategories=" + needsCategories + "]";
	}

}
