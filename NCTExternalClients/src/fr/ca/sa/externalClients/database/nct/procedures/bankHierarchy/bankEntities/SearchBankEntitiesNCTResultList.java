package fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Milivoj Bozic
 *
 *         Wrapper class for entities' search results list
 */

public class SearchBankEntitiesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<SearchBankEntitiesNCTResultItem> entities;

	/**
	 * default constructor for Get Bank Entities NCT Result List
	 */
	public SearchBankEntitiesNCTResultList() {
		super();
		entities = new ArrayList<SearchBankEntitiesNCTResultItem>();
	}

	/**
	 * Search Bank Entities NCT Result List
	 * 
	 * @param entities
	 *            Entities
	 */
	public SearchBankEntitiesNCTResultList(List<SearchBankEntitiesNCTResultItem> entities) {
		super();
		this.entities = entities;
	}

	public List<SearchBankEntitiesNCTResultItem> getEntities() {
		return entities;
	}

	public void setEntities(List<SearchBankEntitiesNCTResultItem> entities) {
		this.entities = entities;
	}

	@Override
	public String toString() {
		return "SearchBankEntitiesNCTResultList [entities=" + entities + "]";
	}

}
