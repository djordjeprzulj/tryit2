package fr.ca.sa.externalClients.database.common.procedures.users.getUserEntities;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * User Entity item (one entity in which user is employed to)
 * 
 * @author Sasa Radovanovic
 *
 */
public class UserEntityItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String entityCode;

	private String entityName;

	private int entityId;

	/**
	 * default constructor for User Entity Item
	 */
	public UserEntityItem() {
		super();
	}

	/**
	 * User Entity Item
	 * 
	 * @param entityCode
	 * 				Entity code
	 * 
	 * @param entityName
	 * 				Entity name
	 * 
	 * @param entityId
	 * 				Entity ID
	 */
	public UserEntityItem(String entityCode, String entityName, int entityId) {
		super();
		this.entityCode = entityCode;
		this.entityName = entityName;
		this.entityId = entityId;
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

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	@Override
	public String toString() {
		return "GetUserEntitiesNCTResultItem [entityCode=" + entityCode + ", entityName=" + entityName + ", entityId="
				+ entityId + "]";
	}
}
