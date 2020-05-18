package fr.ca.sa.externalClients.database.nct.procedures.statistics.getStatisticsList;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Result Item for single statistics list row from store procedure
 * 
 * @author Stefna Djokic
 */
public class GetStatisticsListResultItem implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int statisticId;
	private String statisticName;

	/**
	 * default constructor for Get Statistics List Result Item
	 */
	public GetStatisticsListResultItem() {
		super();
	}

	/**
	 * Get Statistics List Result Item
	 * 
	 * @param statisticId
	 * 				Statistic ID
	 * 
	 * @param statisticName
	 * 				Statistic name
	 */
	public GetStatisticsListResultItem(int statisticId, String statisticName) {
		super();
		this.statisticId = statisticId;
		this.statisticName = statisticName;
	}

	public int getStatisticId() {
		return statisticId;
	}

	public void setStatisticId(int statisticId) {
		this.statisticId = statisticId;
	}

	public String getStatisticName() {
		return statisticName;
	}

	public void setStatisticName(String statisticName) {
		this.statisticName = statisticName;
	}

	@Override
	public String toString() {
		return "GetStatisticsListResulItem [statisticId=" + statisticId + ", statisticName=" + statisticName + "]";
	}

}
