package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getCodeTableData;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from spGetTableData
 *         store procedure for simple code tables
 */
public class GetCodeTableDataSimpleNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private int id;
	private String nameL1;
	private String nameL2;
	private boolean active;

	/**
	 * default constructor for Get Code Table Data Simple NCT Result Item
	 */
	public GetCodeTableDataSimpleNCTResultItem() {
		super();
	}

	/**
	 * Get Code Table Data Simple NCT Result Item
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
	public GetCodeTableDataSimpleNCTResultItem(int id, String nameL1, String nameL2, int active) {
		super();
		this.id = id;
		this.nameL1 = nameL1;
		this.nameL2 = nameL2;
		this.active = active == 1;
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
		return "GetCodeTableDataSimpleNCTResultItem [id=" + id + ", nameL1=" + nameL1 + ", nameL2=" + nameL2
				+ ", active=" + active + "]";
	}

}
