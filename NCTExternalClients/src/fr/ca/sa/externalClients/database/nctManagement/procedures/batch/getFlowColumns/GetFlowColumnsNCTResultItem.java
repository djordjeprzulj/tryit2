package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getFlowColumns;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 *
 * Wrapper class for single result in result set from
 * batch.spGetFlowDirectionTypes store procedure
 * 
 * @author Nemanja Ignjatov
 */
public class GetFlowColumnsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int flowId;
	private int ordinalPosition;
	private String columnName;
	private int isNullable;
	private String dataType;
	private int maxLength;
	private String codeTableName;

	/**
	 * default constructor for Get Flow Columns NCT Result Item
	 */
	public GetFlowColumnsNCTResultItem() {
		super();
	}

	/**
	 * Get Flow Columns NCT Result Item
	 * 
	 * @param flowId
	 * 				Flow ID
	 * 
	 * @param ordinalPosition
	 * 				Position
	 * 
	 * @param columnName
	 * 				Column name
	 * 
	 * @param isNullable
	 * 				Is nullable
	 * 
	 * @param dataType
	 * 				Data type
	 * 
	 * @param maxLength
	 * 				Max length
	 * 
	 * @param codeTableName
	 * 				Code table name
	 */
	public GetFlowColumnsNCTResultItem(int flowId, int ordinalPosition, String columnName, int isNullable,
			String dataType, int maxLength, String codeTableName) {
		super();
		this.flowId = flowId;
		this.ordinalPosition = ordinalPosition;
		this.columnName = columnName;
		this.isNullable = isNullable;
		this.dataType = dataType;
		this.maxLength = maxLength;
		this.codeTableName = codeTableName;
	}

	public int getFlowId() {
		return flowId;
	}

	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}

	public int getOrdinalPosition() {
		return ordinalPosition;
	}

	public void setOrdinalPosition(int ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(int isNullable) {
		this.isNullable = isNullable;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public String getCodeTableName() {
		return codeTableName;
	}

	public void setCodeTableName(String codeTableName) {
		this.codeTableName = codeTableName;
	}

	@Override
	public String toString() {
		return "GetFlowColumnsNCTResultItem [flowId=" + flowId + ", ordinalPosition=" + ordinalPosition
				+ ", columnName=" + columnName + ", isNullable=" + isNullable + ", dataType=" + dataType
				+ ", maxLength=" + maxLength + ", codeTableName=" + codeTableName + "]";
	}

}
