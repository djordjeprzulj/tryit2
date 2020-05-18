package fr.ca.sa.externalClients.database.nct.procedures.audit.getAuditData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Holder audit logs item list
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetAuditDataList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetAuditDataItem> logs;

	/**
	 * default constructor for Get Audit Data List
	 */
	public GetAuditDataList() {
		super();
		this.logs = new ArrayList<>();
	}

	/**
	 * Get Audit Data List
	 * 
	 * @param logs
	 * 				Logs
	 */
	public GetAuditDataList(List<GetAuditDataItem> logs) {
		super();
		this.logs = logs;
	}

	public List<GetAuditDataItem> getLogs() {
		return logs;
	}

	public void setLogs(List<GetAuditDataItem> logs) {
		this.logs = logs;
	}

	@Override
	public String toString() {
		return "GetAuditDataList [logs=" + logs + "]";
	}

}
