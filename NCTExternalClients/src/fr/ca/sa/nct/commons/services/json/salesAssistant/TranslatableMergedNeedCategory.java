package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request for getting client needs subcat products from catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class TranslatableMergedNeedCategory implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int id;

	private Map<String, String> names;

	private List<TranslatableNeedSubCategory> subcategories;

	/**
	 * default constructor for Translatable Merged Need Category
	 */
	public TranslatableMergedNeedCategory() {
		super();
		this.subcategories = new ArrayList<TranslatableNeedSubCategory>();
		this.names = new HashMap<String, String>();
	}

	/**
	 * Translatable Merged Need Category
	 * 
	 * @param id
	 * 				ID
	 */
	public TranslatableMergedNeedCategory(int id) {
		super();
		this.id = id;
		this.subcategories = new ArrayList<TranslatableNeedSubCategory>();
		this.names = new HashMap<String, String>();
	}

	/**
	 * Translatable Merged Need Category
	 * 
	 * @param id
	 * 				ID
	 * 
	 * @param names
	 * 				Names
	 * 
	 * @param subcategories
	 * 				Subcategories
	 */
	public TranslatableMergedNeedCategory(int id, Map<String, String> names,
			List<TranslatableNeedSubCategory> subcategories) {
		super();
		this.id = id;
		this.names = names;
		this.subcategories = subcategories;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, String> getNames() {
		return names;
	}

	public void setNames(Map<String, String> names) {
		this.names = names;
	}

	public List<TranslatableNeedSubCategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<TranslatableNeedSubCategory> subcategories) {
		this.subcategories = subcategories;
	}

	@Override
	public String toString() {
		return "GetClientNeedsSubCatProductsResponse [id=" + id + ", names=" + names + ", subcategories="
				+ subcategories + "]";
	}

}
