package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioDataCount;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Wrapper for returning count of portfolios for particular criteria in JSON
 * response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetPortfolioDataCountNCTResult implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int recordCount;

	/**
	 * default constructor for Get Portfolio Data Count NCT Result
	 */
	public GetPortfolioDataCountNCTResult() {
		super();
	}

	/**
	 * Get Portfolio Data Count NCT Result
	 * 
	 * @param recordCount
	 * 				Record count
	 */
	public GetPortfolioDataCountNCTResult(int recordCount) {
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
		return "GetPortfolioDataCountNCTResult [recordCount=" + recordCount + "]";
	}

}
