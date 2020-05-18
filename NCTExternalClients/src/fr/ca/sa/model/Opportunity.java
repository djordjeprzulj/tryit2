package fr.ca.sa.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.PermissionInterface;

public class Opportunity implements Serializable {
	
	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private Integer id;
	private Integer typeId;
	private String startDate;
	private String expirationDate;
	private Integer priorityId;
	private Integer statusId;
	private Integer stateId;
	private Map<String, String> names = new HashMap<String, String>();
	private Map<String, String> statusNames = new HashMap<String, String>();
	private Map<String, String> subCatNames = new HashMap<String, String>();
	private IdName segment = new IdName();
	private String categoryPictureUri;

	private Entity entity = new Entity(); 
	private Client client = new Client();
	private Collaborator advisor = new Collaborator();
	
	private PermissionInterface permission;

	private Integer contactPriority;

	private String civility;
	private String treatmentPeriod;

	private OpportunitySubcategory subcategory;
	private String longDescription;
	private String tipsLink;
	private String tipsDesc;
	private String simulatorLink;

	private String picture;
	
	public Opportunity() {
		super();
	}
	
	public Opportunity(Integer id, Integer typeId, OpportunitySubcategory subcategory) {
		super();
		this.id = id;
		this.typeId = typeId;
		this.subcategory = subcategory;
	}
	
	public OpportunitySubcategory getSubcategory() {
		return subcategory;
	}
	
	public void setSubcategory(OpportunitySubcategory subcategory) {
		this.subcategory = subcategory;
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
	
	public int getPriorityId() {
		return priorityId;
	}
	
	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}
	
	public Integer getStatusId() {
		return statusId;
	}
	
	public Map<String, String> getStatusNames() {
		return statusNames;
	}
	
	public void setStatusNames(Map<String, String> statusNames) {
		this.statusNames = statusNames;
	}
	
	public Map<String, String> getSubCatNames() {
		return subCatNames;
	}
	
	public void setSubCatNames(Map<String, String> subCatNames) {
		this.subCatNames = subCatNames;
	}
	
	public IdName getSegment() {
		return segment;
	}
	
	public void setSegment(IdName segment) {
		this.segment = segment;
	}
	
	public String getCategoryPictureUri() {
		return categoryPictureUri;
	}
	
	public void setCategoryPictureUri(String categoryPictureUri) {
		this.categoryPictureUri = categoryPictureUri;
	}
	
	public Entity getEntity() {
		return entity;
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Collaborator getAdvisor() {
		return advisor;
	}
	
	public void setAdvisor(Collaborator advisor) {
		this.advisor = advisor;
	}
	
	public PermissionInterface getPermission() {
		return permission;
	}
	
	public void setPermission(PermissionInterface permission) {
		this.permission = permission;
	}
	
	public int getContactPriority() {
		return contactPriority;
	}
	
	public void setContactPriority(int contactPriority) {
		this.contactPriority = contactPriority;
	}
	
	public String getCivility() {
		return civility;
	}
	
	public void setCivility(String civility) {
		this.civility = civility;
	}
	
	public String getTreatmentPeriod() {
		return treatmentPeriod;
	}
	
	public void setTreatmentPeriod(String treatmentPeriod) {
		this.treatmentPeriod = treatmentPeriod;
	}
	
	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getTipsLink() {
		return tipsLink;
	}

	public void setTipsLink(String tipsLink) {
		this.tipsLink = tipsLink;
	}

	public String getTipsDesc() {
		return tipsDesc;
	}

	public void setTipsDesc(String tipsDesc) {
		this.tipsDesc = tipsDesc;
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

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public void setPriorityId(Integer priorityId) {
		this.priorityId = priorityId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public void setContactPriority(Integer contactPriority) {
		this.contactPriority = contactPriority;
	}
	
	public Map<String, String> getNames() {
		return names;
	}

	public void setNames(Map<String, String> names) {
		this.names = names;
	}

	public Integer getTypeId() {
		return typeId;
	}

	@Override
	public String toString() {
		return "Opportunity [id=" + id + ", typeId=" + typeId + ", subcategory=" + subcategory + ", startDate=" + startDate
				+ ", expirationDate=" + expirationDate + ", priorityId=" + priorityId + ", statusId=" + statusId
				+ ", statusNames=" + statusNames + ", subCatNames=" + subCatNames + ", segment=" + segment
				+ ", categoryPictureUri=" + categoryPictureUri + ", entity=" + entity + ", client=" + client
				+ ", advisor=" + advisor + ", permission=" + permission + ", contactPriority=" + contactPriority
				+ ", civility=" + civility + ", treatmentPeriod=" + treatmentPeriod + "]";
	}
	
}
