package fr.ca.sa.nct.commons.services.json.search;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities.SearchBankEntitiesNCTResultList;

/**
 * 
 * Response JSON wrapper for branch filters
 * 
 * 
 * @author Milivoj Bozic
 *
 */
public class SearchNCTBankEntities implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private SearchBankEntitiesNCTResultList result;

	/**
	 * default constructor for Search NCT Bank Entities
	 */
	public SearchNCTBankEntities() {
		super();
	}

	/**
	 * Search NCT Bank Entities
	 * 
	 * @param item
	 * 				Search NCT Bank Entities result list item
	 */
	public SearchNCTBankEntities(SearchBankEntitiesNCTResultList item) {
		super();
		this.setResult(item);
	}

	public SearchBankEntitiesNCTResultList getResult() {
		return result;
	}

	public void setResult(SearchBankEntitiesNCTResultList item) {
		this.result = item;
	}

}
