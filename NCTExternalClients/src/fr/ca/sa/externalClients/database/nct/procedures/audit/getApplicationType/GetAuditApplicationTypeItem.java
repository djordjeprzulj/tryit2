package fr.ca.sa.externalClients.database.nct.procedures.audit.getApplicationType;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Holder client agenda elements, single item
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetAuditApplicationTypeItem implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer applicationId;

	private String applicationName;

	/**
	 * default constructor for Get Audit Application Type Item
	 */
	public GetAuditApplicationTypeItem() {
		super();
	}

	/**
	 * Get Audit Application Type Item
	 * 
	 * @param applicationId
	 * 				Application ID
	 * 
	 * @param applicationName
	 * 				Application name
	 */
	public GetAuditApplicationTypeItem(Integer applicationId, String applicationName) {
		super();
		this.applicationId = applicationId;
		this.applicationName = applicationName;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	@Override
	public String toString() {
		return "GetAuditApplicationTypeItem [applicationId=" + applicationId + ", applicationName=" + applicationName
				+ "]";
	}

}
