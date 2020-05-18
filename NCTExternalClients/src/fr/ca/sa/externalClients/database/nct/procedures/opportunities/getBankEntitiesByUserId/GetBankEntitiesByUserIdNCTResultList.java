package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getBankEntitiesByUserId;

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
public class GetBankEntitiesByUserIdNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetBankEntitiesByUserIdNCTResultItem> entities;

	/**
	 * default constructor for Get Opportunities Categories NCT Result List
	 */
	public GetBankEntitiesByUserIdNCTResultList() {
		this.entities = new ArrayList<GetBankEntitiesByUserIdNCTResultItem>();
	}

	/**
	 * Get Opportunities Categories NCT Result List
	 * 
	 * @param entities
	 * 				Entities
	 */
	public GetBankEntitiesByUserIdNCTResultList(List<GetBankEntitiesByUserIdNCTResultItem> entities) {
		super();
		this.entities = entities;
	}

	public List<GetBankEntitiesByUserIdNCTResultItem> getEntities() {
		return entities;
	}

	public void setEntities(List<GetBankEntitiesByUserIdNCTResultItem> entities) {
		this.entities = entities;
	}

	@Override
	public String toString() {
		return "GetOpportunitiesCategoriesNCTResultList [categories=" + entities + "]";
	}

}
