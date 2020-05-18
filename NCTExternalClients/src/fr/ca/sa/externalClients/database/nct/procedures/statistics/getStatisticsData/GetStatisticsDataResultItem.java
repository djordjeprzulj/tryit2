package fr.ca.sa.externalClients.database.nct.procedures.statistics.getStatisticsData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetStatisticsDataResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int rowCount;
	private Map<String, ArrayList<String>> statisticsData;

	/**
	 * default constructor for Get Statistics Data Result Item
	 */
	public GetStatisticsDataResultItem() {
		super();
		this.rowCount = 0;
		this.statisticsData = new LinkedHashMap<String, ArrayList<String>>();
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public Map<String, ArrayList<String>> getStatisticsData() {
		return statisticsData;
	}

	public void setStatisticsData(Map<String, ArrayList<String>> statisticsData) {
		this.statisticsData = statisticsData;
	}

	@Override
	public String toString() {
		return "GetStatisticsDataResultItem [rowCount=" + rowCount + ", statisticsData=" + statisticsData + "]";
	}

}
