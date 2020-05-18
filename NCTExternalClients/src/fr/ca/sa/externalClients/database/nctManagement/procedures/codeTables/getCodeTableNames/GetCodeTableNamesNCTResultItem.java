package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getCodeTableNames;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from
 *         spGetCodeTableNames store procedure
 */
public class GetCodeTableNamesNCTResultItem implements StoreProcedureResult {

	private int codeTableId;
	private String codeTablename;
	private boolean simpleStructure;
	private boolean readOnly;
	private String tableAlias;
	
	/**
	 * default constructor for Get CodeTable Names NCT Result Item
	 */
	public GetCodeTableNamesNCTResultItem() {
		super();
	}

	/**
	 * CodeTable Names NCT Result Item
	 * 
	 * @param codeTableId
	 * 				Code table ID
	 * 
	 * @param codeTablename
	 * 				Code table name
	 * 
	 * @param simpleStructure
	 * 				Is simple structure
	 * 
	 * @param readOnly
	 * 				Read only property
	 * 
	 * @param tableAlias
	 * 				Table alias
	 */
	public GetCodeTableNamesNCTResultItem(int codeTableId, String codeTablename, int simpleStructure, int readOnly, String tableAlias) {
		super();
		this.codeTableId = codeTableId;
		this.codeTablename = codeTablename;
		this.simpleStructure = simpleStructure == NCTDatabaseConstants.ACTIVE_INTEGER_VALUE;
		this.readOnly = readOnly == NCTDatabaseConstants.ACTIVE_INTEGER_VALUE;
		this.tableAlias=tableAlias;
	}

	public int getCodeTableId() {
		return codeTableId;
	}

	public void setCodeTableId(int codeTableId) {
		this.codeTableId = codeTableId;
	}

	public String getCodeTablename() {
		return codeTablename;
	}

	public void setCodeTablename(String codeTablename) {
		this.codeTablename = codeTablename;
	}

	public boolean isSimpleStructure() {
		return simpleStructure;
	}

	public void setSimpleStructure(boolean simpleStructure) {
		this.simpleStructure = simpleStructure;
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
		return "GetCodeTableNamesNCTResultItem [codeTableId=" + codeTableId + ", codeTablename=" + codeTablename
				+ ", simpleStructure=" + simpleStructure + ", readOnly=" + readOnly + ", tableAlias=" + tableAlias
				+ "]";
	}

	

}
