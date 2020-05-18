package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getCodeTableStructure;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from
 *         spGetTableStructure store procedure
 */
public class GetCodeTableStructureNCTResultItem implements StoreProcedureResult {

	private String columnName;
	private String dataType;
	private Integer maxLength;
	private int isNullable;

	/**
	 * default constructor for Get Code Table Structure NCT Result Item
	 */
	public GetCodeTableStructureNCTResultItem() {
		super();
	}

	/**
	 * Get Code Table Structure NCT Result Item
	 * 
	 * @param columnName
	 * 				Column name
	 * 
	 * @param dataType
	 * 				Data type
	 * 
	 * @param maxLength
	 * 				Max length
	 * 
	 * @param isNullable
	 * 				Is nullable
	 */
	public GetCodeTableStructureNCTResultItem(String columnName, String dataType, Integer maxLength, int isNullable) {
		super();
		this.columnName = columnName;
		this.dataType = dataType;
		this.maxLength = maxLength;
		this.isNullable = isNullable;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public int getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(int isNullable) {
		this.isNullable = isNullable;
	}

	@Override
	public String toString() {
		return "GetCodeTableStructureNCTResultItem [columnName=" + columnName + ", dataType=" + dataType
				+ ", maxLength=" + maxLength + ", isNullable=" + isNullable + "]";
	}

}
