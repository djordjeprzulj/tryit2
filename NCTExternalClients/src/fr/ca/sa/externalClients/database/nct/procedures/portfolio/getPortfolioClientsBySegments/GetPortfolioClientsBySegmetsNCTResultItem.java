package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioClientsBySegments;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Single item in Portfolio by segment
 * 
 * @author Stefan Djokic
 *
 */
public class GetPortfolioClientsBySegmetsNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int segmentId;
	private String clientSegment;
	private int clientNumber;
	private boolean belongs;

	/**
	 * default constructor for Get Portfolio Clients By Segmets NCT Result Item
	 */
	public GetPortfolioClientsBySegmetsNCTResultItem() {
		super();
	}

	/**
	 * Get Portfolio Clients By Segmets NCT Result Item
	 * 
	 * @param segmentId
	 * 				Segment ID
	 * 
	 * @param clientSegment
	 * 				Client segment
	 * 
	 * @param clientNumber
	 * 				Client number
	 * 
	 * @param belongs
	 * 				Belongs
	 */
	public GetPortfolioClientsBySegmetsNCTResultItem(int segmentId, String clientSegment, int clientNumber,
			int belongs) {
		super();
		this.segmentId = segmentId;
		this.clientSegment = clientSegment;
		this.clientNumber = clientNumber;
		this.belongs = belongs == 1;
	}

	public int getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(int segmentId) {
		this.segmentId = segmentId;
	}

	public String getClientSegment() {
		return clientSegment;
	}

	public void setClientSegment(String clientSegment) {
		this.clientSegment = clientSegment;
	}

	public int getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}

	public boolean isBelongs() {
		return belongs;
	}

	public void setBelongs(boolean belongs) {
		this.belongs = belongs;
	}

	@Override
	public String toString() {
		return "GetPortfolioClientsBySegmetsNCTResultItem [segmentId=" + segmentId + ", clientSegment=" + clientSegment
				+ ", clientNumber=" + clientNumber + ", belongs=" + belongs + "]";
	}

}
