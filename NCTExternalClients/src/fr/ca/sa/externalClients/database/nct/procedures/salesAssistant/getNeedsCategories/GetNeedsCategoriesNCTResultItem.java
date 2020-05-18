package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getNeedsCategories;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.NeedCategory;

/**
 * 
 * Single need data holder retrieved from database
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetNeedsCategoriesNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private NeedCategory needCategory;
	
	/**
	 * default constructor for Get Needs Categories NCT Result Item
	 */
	public GetNeedsCategoriesNCTResultItem() {
		super();
	}

	/**
	 * Get Needs Categories NCT Result Item
	 * 
	 * @param needCategory
	 * 			Need category
	 * 
	 */
	public GetNeedsCategoriesNCTResultItem(NeedCategory needCategory) {
		super();
		this.needCategory = needCategory;
	}

	public NeedCategory getNeedCategory() {
		return needCategory;
	}

	public void setNeedCategory(NeedCategory needCategory) {
		this.needCategory = needCategory;
	}
}
