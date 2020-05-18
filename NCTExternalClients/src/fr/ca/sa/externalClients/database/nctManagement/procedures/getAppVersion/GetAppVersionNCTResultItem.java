package fr.ca.sa.externalClients.database.nctManagement.procedures.getAppVersion;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Result Item for application version store procedure
 * 
 * @author Jelena Raca
 */

public class GetAppVersionNCTResultItem implements StoreProcedureResult, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private String appVersion;

	/**
	 * default constructor for Get App Version NCT Result Item
	 */
	public GetAppVersionNCTResultItem() {
		super();
	}

	/**
	 * Get App Version NCT Result Item
	 * 
	 * @param appVersion
	 * 			Application version
	 */
	public GetAppVersionNCTResultItem(String appVersion) {
		super();
		this.appVersion = appVersion;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	@Override
	public String toString() {
		return "GetAppVersionResultItem [appVersion=" + appVersion + "]";
	}
	
}
