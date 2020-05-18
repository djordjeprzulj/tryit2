package fr.ca.sa.externalClients.database.nct.procedures.statistics.getStatisticsList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Result holder for statistics list
 * 
 * @author Stefan Djokic
 *
 */
public class GetStatisticsListResultList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetStatisticsListResultItem> statisticsList;

	/**
	 * default constructor for Get Statistics List Result List
	 */
	public GetStatisticsListResultList() {
		super();
		this.statisticsList = new ArrayList<GetStatisticsListResultItem>();
	}

	public List<GetStatisticsListResultItem> getStatisticsList() {
		return statisticsList;
	}

	public void setStatisticsList(List<GetStatisticsListResultItem> statisticsList) {
		this.statisticsList = statisticsList;
	}

	@Override
	public String toString() {
		return "GetStatisticsListResultList [statisticsList=" + statisticsList + "]";
	}

}
