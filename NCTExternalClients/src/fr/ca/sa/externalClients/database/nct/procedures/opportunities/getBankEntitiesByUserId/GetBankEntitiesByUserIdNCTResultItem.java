package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getBankEntitiesByUserId;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Wrapper for returning single item of opportunity category in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetBankEntitiesByUserIdNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer entityId;
	private String entityCode;
	
	/**
	 * default constructor for Get Bank Entities By User Id NCT Result Item
	 */
	public GetBankEntitiesByUserIdNCTResultItem() {
		super();
	}
	
	/**
	 * Get Bank Entities By User Id NCT Result Item
	 * 
	 * @param entityId
	 * 			Entity ID
	 * 
	 * @param entityCode
	 * 			Entity code
	 */
	public GetBankEntitiesByUserIdNCTResultItem(Integer entityId, String entityCode) {
		super();
		this.entityId = entityId;
		this.entityCode = entityCode;
	}
	public Integer getEntityId() {
		return entityId;
	}
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}
	public String getEntityCode() {
		return entityCode;
	}
	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}
	@Override
	public String toString() {
		return "GetBankEntitiesByUserIdNCTResultItem [entityId=" + entityId + ", entityCode=" + entityCode + "]";
	}
	
	
}
