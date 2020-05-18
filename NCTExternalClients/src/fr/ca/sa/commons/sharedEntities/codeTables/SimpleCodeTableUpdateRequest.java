package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SimpleCodeTableUpdateRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String codeTableName;
	private int id;
	private String nameL1;
	private String nameL2;
	private boolean active;

	/**
	 * default constructor for Simple CodeTable Update Request
	 */
	public SimpleCodeTableUpdateRequest() {
		super();
	}

	/**
	 * Simple CodeTable Update Request
	 * 
	 * @param codeTableName
	 * 				Code table name
	 * 
	 * @param id
	 * 				ID
	 * 
	 * @param nameL1
	 * 				Name in first language
	 * 
	 * @param nameL2
	 * 				Name in second language
	 * 
	 * @param active
	 * 				Active
	 */
	public SimpleCodeTableUpdateRequest(String codeTableName, int id, String nameL1, String nameL2, boolean active) {
		super();
		this.codeTableName = codeTableName;
		this.id = id;
		this.nameL1 = nameL1;
		this.nameL2 = nameL2;
		this.active = active;
	}

	public String getCodeTableName() {
		return codeTableName;
	}

	public void setCodeTableName(String codeTableName) {
		this.codeTableName = codeTableName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "SimpleCodeTableUpdateRequest [codeTableName=" + codeTableName + ", id=" + id + ", nameL1=" + nameL1
				+ ", nameL2=" + nameL2 + ", active=" + active + "]";
	}

}
