package fr.ca.sa.externalClients.database.nct.procedures.audit.getApplicationType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Holder audit applications item list
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetAuditApplicationTypeList implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetAuditApplicationTypeItem> applications;

	/**
	 * default constructor for Get Audit Application Type List
	 */
	public GetAuditApplicationTypeList() {
		super();
		this.applications = new ArrayList<>();
	}

	/**
	 * Get Audit Application Type List
	 * 
	 * @param applications
	 * 				Application
	 */
	public GetAuditApplicationTypeList(List<GetAuditApplicationTypeItem> applications) {
		super();
		this.applications = applications;
	}

	public List<GetAuditApplicationTypeItem> getApplications() {
		return applications;
	}

	public void setApplications(List<GetAuditApplicationTypeItem> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return "GetAuditApplicationTypeList [applications=" + applications + "]";
	}

}
