package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getCodeTableData.GetCodeTableDataSimpleNCTResultItem;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SimpleCodeTableContainer implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int codeTableId;
	private String codeTableName;
	private boolean simple;
	private boolean readOnly;
	private String tableAlias;

	private List<GetCodeTableDataSimpleNCTResultItem> data;

	/**
	 * default constructor for Simple CodeTable Container
	 */
	public SimpleCodeTableContainer() {
		super();
	}

	/**
	 * Simple CodeTable Container
	 * 
	 * @param codeTableId
	 * 				Code table ID
	 * 
	 * @param codeTableName
	 * 				Code table name
	 * 
	 * @param simple
	 * 				If code table is simple
	 * 
	 * @param readOnly
	 * 				Read only
	 * 
	 * @param data
	 * 				Data
	 * 
	 * @param tableAlias
	 * 				Table alias
	 */
	public SimpleCodeTableContainer(int codeTableId, String codeTableName, boolean simple, boolean readOnly,
			List<GetCodeTableDataSimpleNCTResultItem> data, String tableAlias) {
		super();
		this.codeTableId = codeTableId;
		this.codeTableName = codeTableName;
		this.simple = simple;
		this.readOnly = readOnly;
		this.data = data;
		this.tableAlias=tableAlias;
	}

	public int getCodeTableId() {
		return codeTableId;
	}

	public void setCodeTableId(int codeTableId) {
		this.codeTableId = codeTableId;
	}

	public String getCodeTableName() {
		return codeTableName;
	}

	public void setCodeTableName(String codeTableName) {
		this.codeTableName = codeTableName;
	}

	public boolean isSimple() {
		return simple;
	}

	public void setSimple(boolean simple) {
		this.simple = simple;
	}

	public List<GetCodeTableDataSimpleNCTResultItem> getData() {
		return data;
	}

	public void setData(List<GetCodeTableDataSimpleNCTResultItem> data) {
		this.data = data;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public String getTableAlias() {
		return tableAlias;
	}

	public void setTableAlias(String tableAlias) {
		this.tableAlias = tableAlias;
	}

	@Override
	public String toString() {
		return "SimpleCodeTableContainer [codeTableId=" + codeTableId + ", codeTableName=" + codeTableName
				+ ", simple=" + simple + ", readOnly=" + readOnly + ", tableAlias=" + tableAlias + ", data=" + data
				+ "]";
	}

	

}
