package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getCodeTableNames;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for all results from spGetCodeTableNames store
 *         procedure
 */

public class GetCodeTableNamesNCTResultList implements StoreProcedureResult {

	private List<GetCodeTableNamesNCTResultItem> names;

	/**
	 * default constructor for Get Code Table Names NCT Result List
	 */
	public GetCodeTableNamesNCTResultList() {
		super();
		names = new ArrayList<GetCodeTableNamesNCTResultItem>();
	}

	/**
	 * Get Code Table Names NCT Result List
	 * 
	 * @param names
	 * 				Names of tables
	 */
	public GetCodeTableNamesNCTResultList(List<GetCodeTableNamesNCTResultItem> names) {
		super();
		this.names = names;
	}

	public List<GetCodeTableNamesNCTResultItem> getNames() {
		return names;
	}

	public void setNames(List<GetCodeTableNamesNCTResultItem> names) {
		this.names = names;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetCodeTableNamesNCTResultList [ ");
		if (this.names != null) {
			for (GetCodeTableNamesNCTResultItem name : this.names) {
				sbRetValue.append(name.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetCodeTableNamesNCTResultList is empty!!!";
	}

}
