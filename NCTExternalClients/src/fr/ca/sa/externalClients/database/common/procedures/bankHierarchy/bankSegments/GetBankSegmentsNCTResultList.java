package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankSegments;

import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for all results from spGetBankSegments store procedure
 */

public class GetBankSegmentsNCTResultList implements StoreProcedureResult {

	private List<GetBankSegmentsNCTResultItem> segments;

	/**
	 * default constructor for Get Bank Segments NCT Result List
	 */
	public GetBankSegmentsNCTResultList() {
		super();
		this.segments = new ArrayList<GetBankSegmentsNCTResultItem>();
	}

	/**
	 * Get Bank Segments NCT Result List
	 * 
	 * @param segments
	 * 				Segments
	 */
	public GetBankSegmentsNCTResultList(List<GetBankSegmentsNCTResultItem> segments) {
		super();
		this.segments = segments;
	}

	public List<GetBankSegmentsNCTResultItem> getSegments() {
		return segments;
	}

	public void setSegments(List<GetBankSegmentsNCTResultItem> segments) {
		this.segments = segments;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetBankSegmentsNCTResultList [ ");
		if (this.segments != null) {
			for (GetBankSegmentsNCTResultItem bankSegment : this.segments) {
				sbRetValue.append(bankSegment.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetBankSegmentsNCTResultList is empty!!!";
	}

}
