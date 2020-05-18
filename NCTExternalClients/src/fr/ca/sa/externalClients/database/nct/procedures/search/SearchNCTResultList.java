package fr.ca.sa.externalClients.database.nct.procedures.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.nct.commons.NCTSystemConstants;

/**
 * 
 * List containing found client records, with total count and system list size
 * limit
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SearchNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<SearchNCTResultItem> searchResults;
	private int resultSetLimit;
	private int totalRecordCount;

	/**
	 * default constructor for Search NCT Result List
	 */
	public SearchNCTResultList() {
		super();
		this.searchResults = new ArrayList<SearchNCTResultItem>();
		this.totalRecordCount = 0;
		this.resultSetLimit = NCTSystemConstants.getUserSearchLimit();
	}

	/**
	 * Search NCT Result List
	 * 
	 * @param searchResults
	 * 				Search results
	 * 
	 * @param totalRecordCount
	 * 				Total record count
	 */
	public SearchNCTResultList(List<SearchNCTResultItem> searchResults, int totalRecordCount) {
		super();
		this.searchResults = searchResults;
		this.totalRecordCount = totalRecordCount;
		this.resultSetLimit = NCTSystemConstants.getUserSearchLimit();
	}

	public List<SearchNCTResultItem> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<SearchNCTResultItem> searchResults) {
		this.searchResults = searchResults;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public int getResultSetLimit() {
		return resultSetLimit;
	}

	@Override
	public String toString() {
		return "SearchNCTResultList [searchResults=" + searchResults + ", resultSetLimit=" + resultSetLimit
				+ ", totalRecordCount=" + totalRecordCount + "]";
	}

}
