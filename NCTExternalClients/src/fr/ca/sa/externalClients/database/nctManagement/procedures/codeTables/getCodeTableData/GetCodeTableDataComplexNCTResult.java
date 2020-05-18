package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getCodeTableData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from spGetTableData
 *         store procedure for complex code tables
 */
public class GetCodeTableDataComplexNCTResult implements StoreProcedureResult {

	private List<HashMap<String, String>> data;

	/**
	 * default constructor for Get CodeTable Data Complex NCT Result
	 */
	public GetCodeTableDataComplexNCTResult() {
		super();
		this.data = new ArrayList<HashMap<String, String>>();
	}

	/**
	 * Get CodeTable Data Complex NCT Result
	 * 
	 * @param data
	 * 				Data
	 */
	public GetCodeTableDataComplexNCTResult(List<HashMap<String, String>> data) {
		super();
		this.data = data;
	}

	public List<HashMap<String, String>> getData() {
		return data;
	}

	public void setData(List<HashMap<String, String>> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "GetCodeTableDataComplexNCTResult [data=" + data + "]";
	}

}
