package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.getBankHierarchy;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Sasa Radovanovic
 *
 *         Wrapper class for single result in result set from spGetBankHierarchy
 *         store procedure
 */
public class GetBankHierarchyNCTResultItem implements StoreProcedureResult {

	private int entityId;
	private String entityName;
	private int parentEntity;
	private int level;

	/**
	 * default constructor for Get Bank Hierarchy NCT Result Item
	 */
	public GetBankHierarchyNCTResultItem() {
		super();
	}

	/**
	 * Get Bank Hierarchy NCT Result Item
	 * 
	 * @param entityId
	 * 				Entity ID
	 * 
	 * @param entityName
	 * 				Entity name
	 * 
	 * @param parentEntity
	 * 				Parent entity
	 * 
	 * @param level
	 * 				Level
	 */
	public GetBankHierarchyNCTResultItem(int entityId, String entityName, int parentEntity, int level) {
		super();
		this.entityId = entityId;
		this.entityName = entityName;
		this.parentEntity = parentEntity;
		this.level = level;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public int getParentEntity() {
		return parentEntity;
	}

	public void setParentEntity(int parentEntity) {
		this.parentEntity = parentEntity;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "GetBankHierarchyNCTResultItem [entityId=" + entityId + ", entityName=" + entityName + ", parentEntity="
				+ parentEntity + ", level=" + level + "]";
	}

}
