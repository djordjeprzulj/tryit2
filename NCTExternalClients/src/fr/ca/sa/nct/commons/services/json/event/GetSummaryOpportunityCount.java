package fr.ca.sa.nct.commons.services.json.event;

import java.io.Serializable;
import java.util.HashMap;

import fr.ca.sa.commons.constants.ProjectConstants;

public class GetSummaryOpportunityCount implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer recordCount;
	private HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> oppSummary;
	private HashMap<Integer, Integer> totalSumByBranch;
	private HashMap<Integer, Integer> totalSumByCat;
	private HashMap<Integer, Integer> totalSumBySubCat;

	public GetSummaryOpportunityCount() {
		super();
		this.oppSummary = new HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>>();
		this.totalSumByBranch = new HashMap<Integer, Integer>();
		this.totalSumByCat = new HashMap<Integer, Integer>();
		this.totalSumBySubCat = new HashMap<Integer, Integer>();
	}

	public GetSummaryOpportunityCount(Integer recordCount,
			HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> oppSummary,
			HashMap<Integer, Integer> totalSumByBranch, HashMap<Integer, Integer> totalSumByCat,
			HashMap<Integer, Integer> totalSumBySubCat) {
		super();
		this.recordCount = recordCount;
		this.oppSummary = oppSummary;
		this.totalSumByBranch = totalSumByBranch;
		this.totalSumByCat = totalSumByCat;
		this.totalSumBySubCat = totalSumBySubCat;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> getOppSummary() {
		return oppSummary;
	}

	public void setOppSummary(HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> oppSummary) {
		this.oppSummary = oppSummary;
	}

	public HashMap<Integer, Integer> getTotalSumByBranch() {
		return totalSumByBranch;
	}

	public void setTotalSumByBranch(HashMap<Integer, Integer> totalSumByBranch) {
		this.totalSumByBranch = totalSumByBranch;
	}

	public HashMap<Integer, Integer> getTotalSumByCat() {
		return totalSumByCat;
	}

	public void setTotalSumByCat(HashMap<Integer, Integer> totalSumByCat) {
		this.totalSumByCat = totalSumByCat;
	}

	public HashMap<Integer, Integer> getTotalSumBySubCat() {
		return totalSumBySubCat;
	}

	public void setTotalSumBySubCat(HashMap<Integer, Integer> totalSumBySubCat) {
		this.totalSumBySubCat = totalSumBySubCat;
	}

}
