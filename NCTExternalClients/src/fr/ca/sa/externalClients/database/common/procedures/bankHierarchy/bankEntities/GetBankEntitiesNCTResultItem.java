package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankEntities;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for single result in result set from spGetBankEntities store
 * procedure
 * 
 * @author Nemanja Ignjatov
 */
public class GetBankEntitiesNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int entityId;
	private String entityCode;
	private String entityName;
	private String parentEntity;
	private int level;

	/**
	 * default constructor for Get Bank Entities NCT Result Item
	 */
	public GetBankEntitiesNCTResultItem() {
		super();
	}

	/**
	 * Get Bank Entities NCT Result Item
	 * 
	 * @param entityId
	 * 				Entity ID
	 * 
	 * @param entityCode
	 * 				Entity code
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
	public GetBankEntitiesNCTResultItem(int entityId, String entityCode, String entityName, String parentEntity,
			int level) {
		super();
		this.entityId = entityId;
		this.entityCode = entityCode;
		this.entityName = entityName;
		this.parentEntity = parentEntity;
		this.level = level;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getParentEntity() {
		return parentEntity;
	}

	public void setParentEntity(String parentEntity) {
		this.parentEntity = parentEntity;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	@Override
	public String toString() {
		return "GetBankEntitiesNCTResultItem [entityId=" + entityId + ", entityCode=" + entityCode + ", entityName="
				+ entityName + ", parentEntity=" + parentEntity + ", level=" + level + "]";
	}

}
