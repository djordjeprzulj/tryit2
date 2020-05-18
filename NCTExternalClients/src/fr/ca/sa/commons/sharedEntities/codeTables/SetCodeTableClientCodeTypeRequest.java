package fr.ca.sa.commons.sharedEntities.codeTables;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetCodeTableClientCodeTypeRequest {
	
	private Integer clientCodeTypeId;
	private String externalId;
	private String nameL1;
	private String nameL2;
	private Boolean active;
	
	/**
	 * default constructor for Set Code Table Client Code Type Request
	 */
	public SetCodeTableClientCodeTypeRequest() {
		super();
	}

	/**
	 * Set Code Table Client Code Type Request
	 * 
	 * @param clientCodeTypeId
	 * 				Client code type ID
	 * 
	 * @param externalId
	 * 				External ID
	 * 
	 * @param nameL1
	 * 				Name in first language
	 * 
	 * @param nameL2
	 * 				Name in second language
	 * 
	 * @param active
	 * 				Activity
	 */
	public SetCodeTableClientCodeTypeRequest(Integer clientCodeTypeId, String externalId, String nameL1, String nameL2,
			Boolean active) {
		super();
		this.clientCodeTypeId = clientCodeTypeId;
		this.externalId = externalId;
		this.nameL1 = nameL1;
		this.nameL2 = nameL2;
		this.active = active;
	}

	public Integer getClientCodeTypeId() {
		return clientCodeTypeId;
	}

	public void setClientCodeTypeId(Integer clientCodeTypeId) {
		this.clientCodeTypeId = clientCodeTypeId;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getNameL1() {
		return nameL1;
	}

	public void setNameL1(String nameL1) {
		this.nameL1 = nameL1;
	}

	public String getNameL2() {
		return nameL2;
	}

	public void setNameL2(String nameL2) {
		this.nameL2 = nameL2;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "SetCodeTableClientCodeTypeRequest [clientCodeTypeId=" + clientCodeTypeId + ", externalId=" + externalId
				+ ", nameL1=" + nameL1 + ", nameL2=" + nameL2 + ", active=" + active + "]";
	}
	
}
