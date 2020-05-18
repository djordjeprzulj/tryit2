package fr.ca.sa.model;

import java.io.Serializable;
import java.util.HashMap;
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

	private int id;
	private int typeId;
	private int stateId;
	private Map<String, String> names = new HashMap<String, String>();
	private String startDate;
	private String expirationDate;
	private String treatmentPeriod;
	private Map<String, String> longDescriptions = new HashMap<String, String>();
	private String tipsLink;
	private Map<String, String> tipsDescs = new HashMap<String, String>();
	private String simulatorLink;

	private String picture;
	private String categoryPicture;

	private PermissionInterface permissions;

	/**
	 * Translatable Client Opportunity
	 * 
	 * @param id
	 * 				ID
	 * 
	 * @param typeId
	 * 				Type ID
	 * 
	 * @param stateId
	 * 				State ID
	 * 
	 * @param names
	 * 				names
	 * 
	 * @param startDate
	 * 				Start date
	 * 
	 * @param expirationDate
	 * 				Expiration date
	 * 
	 * @param treatmentPeriod
	 * 				Treatment period
	 * 
	 * @param longDescriptions
	 * 				Long descriptions
	 * 
	 * @param tipsLink
	 * 				Tips link
	 * 
	 * @param tipsDescs
	 * 				Tips descriptions
	 * 
	 * @param simulatorLink
	 * 				Simulator link
	 * 
	 * @param picture
	 * 				Picture
	 * 
	 * @param categoryPicture
	 * 				Category picture
	 */
	public TranslatableClientOpportunity(int id, int typeId, int stateId,
			Map<String, String> names, String startDate, String expirationDate,
			String treatmentPeriod, Map<String, String> longDescriptions, String tipsLink,
			Map<String, String> tipsDescs, String simulatorLink, String picture,
			String categoryPicture) {
		super();
		this.id = id;
		this.typeId = typeId;
		this.stateId = stateId;
		this.names = names;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
		this.treatmentPeriod = treatmentPeriod;
		this.longDescriptions = longDescriptions;
		this.tipsLink = tipsLink;
		this.tipsDescs = tipsDescs;
		this.simulatorLink = simulatorLink;
		this.picture = determineOpportunityPicture(picture);
		this.categoryPicture = categoryPicture;
		this.permissions = new SAOpportunityPermission(false);
	}

	private String determineOpportunityPicture(String opportunityPicture) {
		if (opportunityPicture == null || opportunityPicture.isEmpty()) {
			return NCTSystemConstants.getOpportunityDefaultImg();
		}

		return opportunityPicture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getTreatmentPeriod() {
		return treatmentPeriod;
	}

	public void setTreatmentPeriod(String treatmentPeriod) {
		this.treatmentPeriod = treatmentPeriod;
	}

	public String getTipsLink() {
		return tipsLink;
	}

	public void setTipsLink(String tipsLink) {
		this.tipsLink = tipsLink;
	}

	public Map<String, String> getTipsDescs() {
		return tipsDescs;
	}

	public void setTipsDescs(Map<String, String> tipsDescs) {
		this.tipsDescs = tipsDescs;
	}

	public String getSimulatorLink() {
		return simulatorLink;
	}

	public void setSimulatorLink(String simulatorLink) {
		this.simulatorLink = simulatorLink;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public PermissionInterface getOpportunityPermissions() {
		return permissions;
	}

	public void setPermissions(PermissionInterface permissions) {
		this.permissions = permissions;
	}

	public Map<String, String> getNames() {
		return names;
	}

	public void setNames(Map<String, String> names) {
		this.names = names;
	}

	public Map<String, String> getLongDescriptions() {
		return longDescriptions;
	}

	public void setLongDescriptions(Map<String, String> longDescriptions) {
		this.longDescriptions = longDescriptions;
	}

	public String getCategoryPicture() {
		return categoryPicture;
	}

	public void setCategoryPicture(String categoryPicture) {
		this.categoryPicture = categoryPicture;
	}

}
