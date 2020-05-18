package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ComplexCodeTableContainer implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int codeTableId;
	private String codeTableName;
	private boolean simple;
	private boolean readOnly;
	private String tableAlias;

	private List<HashMap<String, String>> data;

	private Map<String, CodeTableConstraintContainer> constraints;

	/**
	 * default constructor for Complex CodeTable Container
	 */
	public ComplexCodeTableContainer() {
		super();
	}

	/**
	 * Complex CodeTable Container
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
	 * @param constraints
	 * 				Constraints
	 * 
	 * @param tableAlias
	 * 				Table alias
	 */
	public ComplexCodeTableContainer(int codeTableId, String codeTableName, boolean simple, boolean readOnly,
			List<HashMap<String, String>> data, Map<String, CodeTableConstraintContainer> constraints,String tableAlias) {
		super();
		this.codeTableId = codeTableId;
		this.codeTableName = codeTableName;
		this.simple = simple;
		this.readOnly = readOnly;
		this.data = data;
		this.constraints = constraints;
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

	public List<HashMap<String, String>> getData() {
		return data;
	}

	public void setData(List<HashMap<String, String>> data) {
		this.data = data;
	}

	public Map<String, CodeTableConstraintContainer> getConstraints() {
		return constraints;
	}

	public void setConstraints(Map<String, CodeTableConstraintContainer> constraints) {
		this.constraints = constraints;
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
		return "ComplexCodeTableContainer [codeTableId=" + codeTableId + ", codeTableName=" + codeTableName
				+ ", simple=" + simple + ", readOnly=" + readOnly + ", tableAlias=" + tableAlias + ", data=" + data
				+ ", constraints=" + constraints + "]";
	}

	

}
