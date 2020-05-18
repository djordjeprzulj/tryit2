package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getCodeTableData;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for all results from spGetTableData store procedure for
 *         simple code tables
 */

public class GetCodeTableDataSimpleNCTResultList implements StoreProcedureResult {

	private List<GetCodeTableDataSimpleNCTResultItem> data;

	/**
	 * default constructor for Get Code Table Data Simple NCT Result List
	 */
	public GetCodeTableDataSimpleNCTResultList() {
		super();
		data = new ArrayList<GetCodeTableDataSimpleNCTResultItem>();
	}

	/**
	 * Get Code Table Data Simple NCT Result List
	 * 
	 * @param data
	 * 				Data
	 */
	public GetCodeTableDataSimpleNCTResultList(List<GetCodeTableDataSimpleNCTResultItem> data) {
		super();
		this.data = data;
	}

	public List<GetCodeTableDataSimpleNCTResultItem> getData() {
		return data;
	}

	public void setData(List<GetCodeTableDataSimpleNCTResultItem> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetCodeTableDataSimpleNCTResultList [ ");
		if (this.data != null) {
			for (GetCodeTableDataSimpleNCTResultItem item : this.data) {
				sbRetValue.append(item.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetCodeTableDataSimpleNCTResultList is empty!!!";
	}

}
