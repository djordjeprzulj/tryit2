package fr.ca.sa.nct.commons.services.json.audit;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response containing audit data
 * 
 * @author Nemanja Ignjatov
 *
 */
public class AuditDataResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<String> logData;

	private boolean limitExceeded;

	private int resultSetLimit;

	/**
	 * default constructor for Audit Data Response
	 */
	public AuditDataResponse() {
		super();
	}

	/**
	 * Audit Data Response
	 * 
	 * @param logData
	 * 				Log data
	 * 
	 * @param resultSetLimit
	 * 			Result set limit
	 * 
	 * @param limitExceeded
	 * 				Limit exceeded
	 */
	public AuditDataResponse(List<String> logData, boolean limitExceeded,int resultSetLimit) {
		super();
		this.logData = logData;
		this.limitExceeded = limitExceeded;
		this.resultSetLimit = resultSetLimit;
	}

	public List<String> getLogData() {
		return logData;
	}

	public void setLogData(List<String> logData) {
		this.logData = logData;
	}

	public boolean isLimitExceeded() {
		return limitExceeded;
	}

	public void setLimitExceeded(boolean limitExceeded) {
		this.limitExceeded = limitExceeded;
	}

	public int getResultSetLimit() {
		return resultSetLimit;
	}

	public void setResultSetLimit(int resultSetLimit) {
		this.resultSetLimit = resultSetLimit;
	}

}
