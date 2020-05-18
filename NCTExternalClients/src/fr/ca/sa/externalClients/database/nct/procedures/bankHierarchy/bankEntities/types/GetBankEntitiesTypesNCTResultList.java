package fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities.types;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Milivoj Bozic
 *
 *        Wrapper class for entities' types results 
 */

public class GetBankEntitiesTypesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Map<Integer, String> items;

	/**
	 * default constructor for Get Bank Entities Types NCT Result List
	 */
	public GetBankEntitiesTypesNCTResultList() {
		super();
		items = new HashMap<Integer, String>();
	}

	/**
	 * Get Bank Entities Types NCT Result List
	 * 
	 * @param items
	 * 				Items
	 */
	public GetBankEntitiesTypesNCTResultList(Map<Integer, String> items) {
		super();
		this.items = items;
	}

	public Map<Integer, String> getItems() {
		return items;
	}

	public void setItems(Map<Integer, String> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "GetBankEntitiesTypesNCTResultList " + items.toString();
	}

}
