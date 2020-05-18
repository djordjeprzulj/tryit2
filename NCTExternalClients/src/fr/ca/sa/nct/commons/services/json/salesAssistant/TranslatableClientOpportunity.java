package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.NCTSystemConstants;
import fr.ca.sa.nct.commons.authorizationUtils.PermissionInterface;
import fr.ca.sa.nct.commons.authorizationUtils.permissionHolders.SAOpportunityPermission;

/**
 * 
 * Translatable Holder for Client opportunities on Sales Assistant endpoints
 * 
 * @author Sasa Radovanovic
 *
 */
public class TranslatableClientOpportunity implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int opportunityId;
	private int opportunityTypeId;
	private int opportunityStateId;
	private Map<String, String> opportunityNames;
	private String opportunityStartDate;
	private String opportunityExpirationDate;
	private String treatmentPeriod;
	private Map<String, String> opportunityLongDescription;
	private String opportunityTipsLink;
	private Map<String, String> opportunityTipsDesc;
	private String opportunitySimulatorLink;

	private String opportunityPicture;
	private String opportunityCategoryPicture;

	private PermissionInterface opportunityPermissions;

	/**
	 * Translatable Client Opportunity
	 * 
	 * @param opportunityId
	 * 				Opportunity ID
	 * 
	 * @param opportunityTypeId
	 * 				Opportunity type ID
	 * 
	 * @param opportunityStateId
	 * 				Opportunity state ID
	 * 
	 * @param opportunityNames
	 * 				Opportunity names
	 * 
	 * @param opportunityStartDate
	 * 				Opportunity start date
	 * 
	 * @param opportunityExpirationDate
	 * 				Opportunity expiration date
	 * 
	 * @param treatmentPeriod
	 * 				Treatment period
	 * 
	 * @param opportunityLongDescription
	 * 				Opportunity long description
	 * 
	 * @param opportunityTipsLink
	 * 				Opportunity tips link
	 * 
	 * @param opportunityTipsDesc
	 * 				Opportunity tips description
	 * 
	 * @param opportunitySimulatorLink
	 * 				Opportunity simulator link
	 * 
	 * @param opportunityPicture
	 * 				Opportunity picture
	 * 
	 * @param opportunityCategoryPicture
	 * 				Opportunity category picture
	 */
	public TranslatableClientOpportunity(int opportunityId, int opportunityTypeId, int opportunityStateId,
			Map<String, String> opportunityNames, String opportunityStartDate, String opportunityExpirationDate,
			String treatmentPeriod, Map<String, String> opportunityLongDescription, String opportunityTipsLink,
			Map<String, String> opportunityTipsDesc, String opportunitySimulatorLink, String opportunityPicture,
			String opportunityCategoryPicture) {
		super();
		this.opportunityId = opportunityId;
		this.opportunityTypeId = opportunityTypeId;
		this.opportunityStateId = opportunityStateId;
		this.opportunityNames = opportunityNames;
		this.opportunityStartDate = opportunityStartDate;
		this.opportunityExpirationDate = opportunityExpirationDate;
		this.treatmentPeriod = treatmentPeriod;
		this.opportunityLongDescription = opportunityLongDescription;
		this.opportunityTipsLink = opportunityTipsLink;
		this.opportunityTipsDesc = opportunityTipsDesc;
		this.opportunitySimulatorLink = opportunitySimulatorLink;
		this.opportunityPicture = determineOpportunityPicture(opportunityPicture);
		this.opportunityCategoryPicture = opportunityCategoryPicture;
		this.opportunityPermissions = new SAOpportunityPermission(false);
	}

	private String determineOpportunityPicture(String opportunityPicture) {
		if (opportunityPicture == null || opportunityPicture.isEmpty()) {
			return NCTSystemConstants.getOpportunityDefaultImg();
		}

		return opportunityPicture;
	}

	public int getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(int opportunityId) {
		this.opportunityId = opportunityId;
	}

	public int getOpportunityTypeId() {
		return opportunityTypeId;
	}

	public void setOpportunityTypeId(int opportunityTypeId) {
		this.opportunityTypeId = opportunityTypeId;
	}

	public int getOpportunityStateId() {
		return opportunityStateId;
	}

	public void setOpportunityStateId(int opportunityStateId) {
		this.opportunityStateId = opportunityStateId;
	}

	public String getOpportunityStartDate() {
		return opportunityStartDate;
	}

	public void setOpportunityStartDate(String opportunityStartDate) {
		this.opportunityStartDate = opportunityStartDate;
	}

	public String getOpportunityExpirationDate() {
		return opportunityExpirationDate;
	}

	public void setOpportunityExpirationDate(String opportunityExpirationDate) {
		this.opportunityExpirationDate = opportunityExpirationDate;
	}

	public String getTreatmentPeriod() {
		return treatmentPeriod;
	}

	public void setTreatmentPeriod(String treatmentPeriod) {
		this.treatmentPeriod = treatmentPeriod;
	}

	public String getOpportunityTipsLink() {
		return opportunityTipsLink;
	}

	public void setOpportunityTipsLink(String opportunityTipsLink) {
		this.opportunityTipsLink = opportunityTipsLink;
	}

	public Map<String, String> getOpportunityTipsDesc() {
		return opportunityTipsDesc;
	}

	public void setOpportunityTipsDesc(Map<String, String> opportunityTipsDesc) {
		this.opportunityTipsDesc = opportunityTipsDesc;
	}

	public String getOpportunitySimulatorLink() {
		return opportunitySimulatorLink;
	}

	public void setOpportunitySimulatorLink(String opportunitySimulatorLink) {
		this.opportunitySimulatorLink = opportunitySimulatorLink;
	}

	public String getOpportunityPicture() {
		return opportunityPicture;
	}

	public void setOpportunityPicture(String opportunityPicture) {
		this.opportunityPicture = opportunityPicture;
	}

	public PermissionInterface getOpportunityPermissions() {
		return opportunityPermissions;
	}

	public void setOpportunityPermissions(PermissionInterface opportunityPermissions) {
		this.opportunityPermissions = opportunityPermissions;
	}

	public Map<String, String> getOpportunityNames() {
		return opportunityNames;
	}

	public void setOpportunityNames(Map<String, String> opportunityNames) {
		this.opportunityNames = opportunityNames;
	}

	public Map<String, String> getOpportunityLongDescription() {
		return opportunityLongDescription;
	}

	public void setOpportunityLongDescription(Map<String, String> opportunityLongDescription) {
		this.opportunityLongDescription = opportunityLongDescription;
	}

	public String getOpportunityCategoryPicture() {
		return opportunityCategoryPicture;
	}

	public void setOpportunityCategoryPicture(String opportunityCategoryPicture) {
		this.opportunityCategoryPicture = opportunityCategoryPicture;
	}

}
