package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for result in result set from
 *         spSetCodeTableSimpleStrucData store procedure
 */
public class SetCodeTableNCTResultItem implements StoreProcedureResult {

	private int id;

	/**
	 * default constructor for Set Code Table NCT Result Item
	 */
	public SetCodeTableNCTResultItem() {
		super();
	}

	/**
	 * Set Code Table NCT Result Item
	 * 
	 * @param id
	 * 			ID
	 */
	public SetCodeTableNCTResultItem(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SetCodeTableNamesNCTResultItem [id=" + id + "]";
	}

}
