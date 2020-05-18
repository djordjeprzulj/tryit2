package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankEntities;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for all results from spGetBankEntities store procedure
 */

public class GetBankEntitiesNCTResultList implements StoreProcedureResult {

	private List<GetBankEntitiesNCTResultItem> entities;

	/**
	 * default constructor for Get Bank Entities NCT Result List
	 */
	public GetBankEntitiesNCTResultList() {
		super();
		entities = new ArrayList<GetBankEntitiesNCTResultItem>();
	}

	/**
	 * Get Bank Entities NCT Result List
	 * 
	 * @param entities
	 * 				Entities
	 */
	public GetBankEntitiesNCTResultList(List<GetBankEntitiesNCTResultItem> entities) {
		super();
		this.entities = entities;
	}

	public List<GetBankEntitiesNCTResultItem> getEntities() {
		return entities;
	}

	public void setEntities(List<GetBankEntitiesNCTResultItem> entities) {
		this.entities = entities;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetBankEntitiesNCTResultList [ ");
		if(this.entities != null){
			for (GetBankEntitiesNCTResultItem enititiesItem : this.entities) {
				sbRetValue.append(enititiesItem.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}
		
		return "GetBankEntitiesNCTResultList is empty!!!";
	}

}
