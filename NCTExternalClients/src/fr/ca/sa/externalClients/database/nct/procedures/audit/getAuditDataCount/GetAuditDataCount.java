package fr.ca.sa.externalClients.database.nct.procedures.audit.getAuditDataCount;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Holder audit log count
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetAuditDataCount implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer recordCount;

	/**
	 * default constructor for Get Audit Data Count
	 */
	public GetAuditDataCount() {
		super();
	}

	/**
	 * Get Audit Data Count
	 * 
	 * @param recordCount
	 * 				Record count
	 */
	public GetAuditDataCount(Integer recordCount) {
		super();
		this.recordCount = recordCount;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	@Override
	public String toString() {
		return "GetAuditDataCount [recordCount=" + recordCount + "]";
	}

}
