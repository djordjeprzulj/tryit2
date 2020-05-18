package fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities.regions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Milivoj Bozic
 *
 *         Wrapper class for entities' regions results 
 */

public class GetBankEntitiesRegionsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<String> items;

	/**
	 * default constructor for Get Bank Entities Regions NCT Result List
	 */
	public GetBankEntitiesRegionsNCTResultList() {
		super();
		items = new ArrayList<String>();
	}

	/**
	 * Get Bank Entities Regions NCT Result List
	 * 
	 * @param items
	 * 				Items
	 */
	public GetBankEntitiesRegionsNCTResultList(List<String> items) {
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
		return "GetEntitiesRegionsNCTResultList " + items.toString();
	}

}
