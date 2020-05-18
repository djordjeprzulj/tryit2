package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioCalc;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning single item of portfolio calculation in JSON response
 * 
 * @author Stefan Djokic
 *
 */
public class GetPortfolioCalcNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int clientCount;
	private int prospectCount;
	private int size;
	private int fillRate;
	private int quality;

	/**
	 * default constructor for Get Portfolio Calc NCT Result Item
	 */
	public GetPortfolioCalcNCTResultItem() {
		super();
	}

	/**
	 * Get Portfolio Calc NCT Result Item
	 * 
	 * @param clientCount
	 * 				Client count
	 * 
	 * @param prospectCount
	 * 				Prospect count
	 * 
	 * @param size
	 * 				Size
	 * 
	 * @param fillRate
	 * 				Fill rate
	 * 
	 * @param quality
	 * 				Quality
	 */
	public GetPortfolioCalcNCTResultItem(int clientCount, int prospectCount, int size, int fillRate, int quality) {
		super();
		this.clientCount = clientCount;
		this.prospectCount = prospectCount;
		this.size = size;
		this.fillRate = fillRate;
		this.quality = quality;
	}

	public int getClientCount() {
		return clientCount;
	}

	public void setClientCount(int clientCount) {
		this.clientCount = clientCount;
	}

	public int getProspectCount() {
		return prospectCount;
	}

	public void setProspectCount(int prospectCount) {
		this.prospectCount = prospectCount;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getFillRate() {
		return fillRate;
	}

	public void setFillRate(int fillRate) {
		this.fillRate = fillRate;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	@Override
	public String toString() {
		return "GetPortfolioCalcNCTResultItem [clientCount=" + clientCount + ", prospectCount=" + prospectCount
				+ ", size=" + size + ", fillRate=" + fillRate + ", quality=" + quality + "]";
	}

}
