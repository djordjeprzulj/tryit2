package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankSegments;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from spGetBankSegments
 *         store procedure
 */
public class GetBankSegmentsNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int segmentId;
	private String segmentName;
	private boolean prospect;

	/**
	 * default constructor for Get Bank Segments NCT Result Item
	 */
	public GetBankSegmentsNCTResultItem() {
		super();
	}

	/**
	 * Get Bank Segments NCT Result Item
	 * 
	 * @param segmentId
	 * 				Segment ID
	 * 
	 * @param segmentName
	 * 				Segment name
	 * 
	 * @param prospect
	 * 				If it's prospect
	 */
	public GetBankSegmentsNCTResultItem(int segmentId, String segmentName, int prospect) {
		super();
		this.segmentId = segmentId;
		this.segmentName = segmentName;
		this.prospect = prospect == 1;
	}

	public int getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(int segmentId) {
		this.segmentId = segmentId;
	}

	public String getSegmentName() {
		return segmentName;
	}

	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}

	public boolean isProspect() {
		return prospect;
	}

	public void setProspect(boolean prospect) {
		this.prospect = prospect;
	}

	@Override
	public String toString() {
		return "GetBankSegmentsNCTResultItem [segmentId=" + segmentId + ", segmentName=" + segmentName + ", prospect="
				+ prospect + "]";
	}

}
