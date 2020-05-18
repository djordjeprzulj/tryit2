package fr.ca.sa.nct.commons.services.json.audit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Response containing audit data
 * 
 * @author Nemanja Ignjatov
 *
 */
public class AuditConfigurationResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<AuditMergedApplicationType> applications;

	/**
	 * default constructor for Audit Configuration Response
	 */
	public AuditConfigurationResponse() {
		super();
		this.applications = new ArrayList<AuditMergedApplicationType>();
	}

	/**
	 * Audit Configuration Response
	 * 
	 * @param applications
	 * 				Applications
	 */
	public AuditConfigurationResponse(List<AuditMergedApplicationType> applications) {
		this.applications = applications;
	}

	public List<AuditMergedApplicationType> getApplications() {
		return applications;
	}

	public void setApplications(List<AuditMergedApplicationType> applications) {
		this.applications = applications;
	}

}
