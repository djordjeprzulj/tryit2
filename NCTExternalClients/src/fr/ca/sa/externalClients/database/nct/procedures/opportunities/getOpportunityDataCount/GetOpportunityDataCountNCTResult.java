package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityDataCount;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning count of opportunities for particular criteria in JSON
 * response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunityDataCountNCTResult implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int recordCount;

	/**
	 * default constructor for NCT Database Get Opportunity Data
	 */
	public GetOpportunityDataCountNCTResult() {
		super();
	}

	/**
	 * NCT Database Get Opportunity Data
	 * 
	 * @param recordCount
	 * 				Record count
	 */
	public GetOpportunityDataCountNCTResult(int recordCount) {
		super();
		this.recordCount = recordCount;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	@Override
	public String toString() {
		return "GetOpportunityDataCountNCTResult [recordCount=" + recordCount + "]";
	}

}
