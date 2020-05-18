package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.getBankHierarchy;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Sasa Radovanovic
 * 
 *         Wrapper class for all results from spGetBankHierarchy store procedure
 */
public class GetBankHierarchyNCTResultList implements StoreProcedureResult {

	private List<GetBankHierarchyNCTResultItem> entities;

	/**
	 * default constructor for Get Bank Hierarchy NCT Result List
	 */
	public GetBankHierarchyNCTResultList() {
		super();
		entities = new ArrayList<GetBankHierarchyNCTResultItem>();
	}

	/**
	 * Get Bank Hierarchy NCT Result List
	 * 
	 * @param entities
	 * 				Entities
	 */
	public GetBankHierarchyNCTResultList(List<GetBankHierarchyNCTResultItem> entities) {
		super();
		this.entities = entities;
	}

	public List<GetBankHierarchyNCTResultItem> getEntities() {
		return entities;
	}

	public void setEntities(List<GetBankHierarchyNCTResultItem> entities) {
		this.entities = entities;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetBankHierarchyNCTResultList [ ");
		if(this.entities != null){
			for (GetBankHierarchyNCTResultItem enititiesItem : this.entities) {
				sbRetValue.append(enititiesItem.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}
		
		return "GetBankHierarchyNCTResultList is empty!!!";
	}

}
