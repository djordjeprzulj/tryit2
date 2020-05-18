package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioTypes;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Wrapper for returning single item of portfolio types in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetPortfolioTypesNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int typeId;
	private String typeName;
	private String typeCode;

	/**
	 * default constructor for Get Portfolio Types NCT Result Item
	 */
	public GetPortfolioTypesNCTResultItem() {
		super();
	}

	/**
	 * Get Portfolio Types NCT Result Item
	 * 
	 * @param typeId
	 * 				Type ID
	 * 
	 * @param typeName
	 * 				Type name
	 * 
	 * @param typeCode
	 * 				Type code
	 */
	public GetPortfolioTypesNCTResultItem(int typeId, String typeName, String typeCode) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeCode = typeCode;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Override
	public String toString() {
		return "GetPortfolioTypesNCTResultItem [typeId=" + typeId + ", typeName=" + typeName + ", typeCode=" + typeCode
				+ "]";
	}

}
