package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.getCodeTableStructure;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for all results from spGetTableStructure store
 *         procedure
 */

public class GetCodeTableStructureNCTResultList implements StoreProcedureResult {

	private List<GetCodeTableStructureNCTResultItem> structures;

	/**
	 * default constructor for Get Code Table Structure NCT Result List
	 */
	public GetCodeTableStructureNCTResultList() {
		super();
		structures = new ArrayList<GetCodeTableStructureNCTResultItem>();
	}

	/**
	 * Get Code Table Structure NCT Result List
	 * 
	 * @param structures
	 * 				Structures
	 */
	public GetCodeTableStructureNCTResultList(List<GetCodeTableStructureNCTResultItem> structures) {
		super();
		this.structures = structures;
	}

	public List<GetCodeTableStructureNCTResultItem> getStructures() {
		return structures;
	}

	public void setStructures(List<GetCodeTableStructureNCTResultItem> structures) {
		this.structures = structures;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetCodeTableStructureNCTResultList [ ");
		if (this.structures != null) {
			for (GetCodeTableStructureNCTResultItem struct : this.structures) {
				sbRetValue.append(struct.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetCodeTableStructureNCTResultList is empty!!!";
	}

}
