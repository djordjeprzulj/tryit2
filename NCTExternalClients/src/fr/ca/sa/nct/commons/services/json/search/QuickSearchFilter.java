package fr.ca.sa.nct.commons.services.json.search;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Wrapper for receiving keyword for quick search
 * 
 * @author Nemanja Ignjatov
 *
 */
public class QuickSearchFilter implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String quickSearch;

	/**
	 * default constructor for Quick Search Filter
	 */
	public QuickSearchFilter() {
		super();
	}

	/**
	 * Quick Search Filter
	 * 
	 * @param quickSearch
	 * 				Quick search
	 */
	public QuickSearchFilter(String quickSearch) {
		super();
		this.quickSearch = quickSearch;
	}

	public String getQuickSearch() {
		return quickSearch;
	}

	public void setQuickSearch(String quickSearch) {
		this.quickSearch = quickSearch;
	}

}
