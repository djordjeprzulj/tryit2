package fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities.cities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Milivoj Bozic
 *
 *         Wrapper class for entities' cities results 
 */

public class GetBankEntitiesCitiesNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<String> items;

	/**
	 * default constructor for Get Bank Entities Cities NCT Result List
	 */
	public GetBankEntitiesCitiesNCTResultList() {
		super();
		items = new ArrayList<String>();
	}

	/**
	 * Get Bank Entities Cities NCT Result List
	 * 
	 * @param items
	 * 				Items
	 */
	public GetBankEntitiesCitiesNCTResultList(List<String> items) {
		super();
		this.items = items;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "GetEntitiesCitiesNCTResultList " + items.toString();
	}

}
