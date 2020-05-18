package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class OpportunitySubCategoryContainer implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int id;
	private int oppCategoryId;
	private Map<String, String> oppSubCategoryNames;

	/**
	 * default constructor for Opportunity Sub Category Container
	 */
	public OpportunitySubCategoryContainer() {
		super();
		this.oppSubCategoryNames = new HashMap<String, String>();
	}

	/**
	 * Opportunity Sub Category Container
	 * 
	 * @param id
	 * 				ID
	 * 
	 * @param oppCategoryId
	 * 				Opportunity category ID
	 * 
	 * @param oppSubCategoryNames
	 * 				Opportunity category names
	 */
	public OpportunitySubCategoryContainer(int id, int oppCategoryId, Map<String, String> oppSubCategoryNames) {
		super();
		this.id = id;
		this.oppCategoryId = oppCategoryId;
		this.oppSubCategoryNames = oppSubCategoryNames;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOppCategoryId() {
		return oppCategoryId;
	}

	public void setOppCategoryId(int oppCategoryId) {
		this.oppCategoryId = oppCategoryId;
	}

	public Map<String, String> getOppSubCategoryNames() {
		return oppSubCategoryNames;
	}

	public void setOppSubCategoryNames(Map<String, String> oppSubCategoryNames) {
		this.oppSubCategoryNames = oppSubCategoryNames;
	}

	@Override
	public String toString() {
		return "OpportunitySubCategoryContainer [id=" + id + ", oppCategoryId=" + oppCategoryId
				+ ", oppSubCategoryNames=" + oppSubCategoryNames + "]";
	}

}
