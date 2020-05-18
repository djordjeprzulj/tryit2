package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getJobsByScheduleId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class JobItemList implements StoreProcedureResult, Serializable {

	
	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private List<JobItem> jobList;
	
	/**
	 * default constructor for Job Item List
	 */
	public JobItemList() {
		super();
		this.jobList = new ArrayList<>();
	}


	/**
	 * Job Item List
	 * 
	 * @param jobList
	 * 				Job list
	 */
	public JobItemList(List<JobItem> jobList) {
		super();
		this.jobList = jobList;
	}

	

	public List<JobItem> getJobList() {
		return jobList;
	}


	public void setJobList(List<JobItem> jobList) {
		this.jobList = jobList;
	}


	@Override
	public String toString() {
		return "JobItemList [jobList=" + jobList + "]";
	}

}
