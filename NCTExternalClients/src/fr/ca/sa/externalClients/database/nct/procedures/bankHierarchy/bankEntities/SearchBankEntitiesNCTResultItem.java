package fr.ca.sa.externalClients.database.nct.procedures.bankHierarchy.bankEntities;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 *
 * Wrapper class for single result in result set from spSearchBankEntities store
 * procedure
 * 
 * @author Milivoj Bozic
 */
public class SearchBankEntitiesNCTResultItem implements StoreProcedureResult, Serializable {
	
	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int entityId;
	private String entityName;
	private String city;
	private String address;
	private String region;

	/**
	 * Get Bank Entities NCT Result Item
	 * 
	 * @param entityId
	 * @param entityName
	 * @param city
	 * @param address
	 * @param region
	 */
	public SearchBankEntitiesNCTResultItem(int entityId, String entityName, String city, String address,
			String region) {
		super();
		this.entityId = entityId;
		this.entityName = entityName;
		this.city = city;
		this.address = address;
		this.region = region;
	}
	
	/**
	 * default constructor for Get Bank Entities NCT Result Item
	 */
	public SearchBankEntitiesNCTResultItem() {
		super();
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "GetBankEntitiesNCTResultItem [entityId=" + entityId + ", entityName=" + entityName + ", city=" + city
				+ ", address=" + address + ", region=" + region + "]";
	}

}
