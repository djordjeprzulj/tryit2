package fr.ca.sa.commons.sharedEntities.codeTables;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetSimpleCodeTableRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String codeTableName;
	private Integer id;
	private String nameL1;
	private String nameL2;
	private boolean active;

	/**
	 * default constructor for Set Simple Code Table Request
	 */
	public SetSimpleCodeTableRequest() {
		super();
	}

	/**
	 * Set Simple Code Table Request
	 * 
	 * @param codeTableName
	 * 				Code table name
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
	 * 				Activity
	 */
	public SetSimpleCodeTableRequest(String codeTableName, Integer id, String nameL1, String nameL2, boolean active) {
		super();
		this.codeTableName = codeTableName;
		this.id = id;
		this.nameL1 = nameL1;
		this.nameL2 = nameL2;
		this.active = active;
	}

	/**
	 * Set Simple Code Table Request
	 * 
	 * @param update
	 * 				Update request
	 */
	public SetSimpleCodeTableRequest(SimpleCodeTableUpdateRequest update) {
		super();
		this.codeTableName = update.getCodeTableName();
		this.id = update.getId();
		this.nameL1 = update.getNameL1();
		this.nameL2 = update.getNameL2();
		this.active = update.isActive();
	}

	/**
	 * Set Simple Code Table Request
	 * 
	 * @param insert
	 * 				Insert request
	 */
	public SetSimpleCodeTableRequest(SimpleCodeTableInsertRequest insert) {
		super();
		this.codeTableName = insert.getCodeTableName();
		this.id = null;
		this.nameL1 = insert.getNameL1();
		this.nameL2 = insert.getNameL2();
		this.active = insert.isActive();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodeTableName() {
		return codeTableName;
	}

	public void setCodeTableName(String codeTableName) {
		this.codeTableName = codeTableName;
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
		return "SetSimpleCodeTableRequest [codeTableName=" + codeTableName + ", id=" + id + ", nameL1=" + nameL1
				+ ", nameL2=" + nameL2 + ", active=" + active + "]";
	}

}
