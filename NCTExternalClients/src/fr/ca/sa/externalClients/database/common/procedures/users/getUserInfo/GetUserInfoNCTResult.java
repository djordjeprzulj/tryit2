package fr.ca.sa.externalClients.database.common.procedures.users.getUserInfo;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.nct.commons.authorizationUtils.PermissionInterface;
import fr.ca.sa.nct.commons.authorizationUtils.permissionHolders.AgendaPermissions;
import fr.ca.sa.nct.commons.authorizationUtils.permissionHolders.AuditPermissions;
import fr.ca.sa.nct.commons.authorizationUtils.permissionHolders.LeadClientPermissions;
import fr.ca.sa.nct.commons.authorizationUtils.permissionHolders.OpportunityPermissions;
import fr.ca.sa.nct.commons.authorizationUtils.permissionHolders.PortfolioManagementPermissions;
import fr.ca.sa.nct.commons.authorizationUtils.permissionHolders.StatisticsPermissions;

/**
 * 
 * Wrapper for returning basic user data JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetUserInfoNCTResult implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String firstName;
	private String lastName;
	private String functionName;
	private String entityName;
	private String entityCode;
	private List<Integer> entities;
	private Integer userId;
	private Integer userCoreId;
	private Double progress;

	private PermissionInterface permissions;
	
	private PermissionInterface oppPermissions;
	
	private PermissionInterface leadPermissions;

	private PermissionInterface portfolioPermissions;
	
	private PermissionInterface statisticsPermissions;

	private PermissionInterface auditPermissions;

	

	/**
	 * Get User Info NCT Result
	 * 
	 * @param firstName
	 * 				First name
	 * 
	 * @param lastName
	 * 				Last name
	 * 
	 * @param functionName
	 * 				Function name
	 * 
	 * @param entityName
	 * 				Entity name
	 * 
	 * @param entityCode
	 * 				Entity code
	 */
	public GetUserInfoNCTResult(String firstName, String lastName, String functionName, String entityName,
			String entityCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.functionName = functionName;
		this.entityName = entityName;
		this.entityCode = entityCode;
		this.entities = null;
		this.userId = null;
		this.userCoreId = null;
		this.progress = 0.0;
		this.permissions = new AgendaPermissions(false, false, false);
		this.leadPermissions = new LeadClientPermissions(false);
		this.oppPermissions = new OpportunityPermissions();
		this.portfolioPermissions=new PortfolioManagementPermissions(false);
		this.statisticsPermissions=new StatisticsPermissions(false);
		this.auditPermissions=new AuditPermissions(false);
		
		
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFunctionName() {
		return functionName;
	}

	public String getEntityName() {
		return entityName;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public List<Integer> getEntities() {
		return entities;
	}

	public void setEntities(List<Integer> entities) {
		this.entities = entities;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int getUserCoreId() {
		return userCoreId;
	}

	public void setUserCoreId(int userCoreId) {
		this.userCoreId = userCoreId;
	}

	public PermissionInterface getPermissions() {
		return permissions;
	}

	public void setPermissions(PermissionInterface permissions) {
		this.permissions = permissions;
	}

	public PermissionInterface getLeadPermissions() {
		return leadPermissions;
	}

	public void setLeadPermissions(PermissionInterface leadPermissions) {
		this.leadPermissions = leadPermissions;
	}

	public PermissionInterface getPortfolioPermissions() {
		return portfolioPermissions;
	}

	public void setPortfolioPermissions(PermissionInterface portfolioPermissions) {
		this.portfolioPermissions = portfolioPermissions;
	}

	public Double getProgress() {
		return progress;
	}

	public void setProgress(Double progress) {
		this.progress = progress;
	}

	public PermissionInterface getOppPermissions() {
		return oppPermissions;
	}

	public void setOppPermissions(PermissionInterface oppPermissions) {
		this.oppPermissions = oppPermissions;
	}
	
	

	public PermissionInterface getStatisticsPermissions() {
		return statisticsPermissions;
	}

	public void setStatisticsPermissions(PermissionInterface statisticsPermissions) {
		this.statisticsPermissions = statisticsPermissions;
	}

	public PermissionInterface getAuditPermissions() {
		return auditPermissions;
	}

	public void setAuditPermissions(PermissionInterface auditPermissions) {
		this.auditPermissions = auditPermissions;
	}
	
	@Override
	public String toString() {
		return "GetUserInfoNCTResult [firstName=" + firstName + ", lastName=" + lastName + ", functionName="
				+ functionName + ", entityName=" + entityName + ", entityCode=" + entityCode + ", entities=" + entities
				+ ", userId=" + userId + ", userCoreId=" + userCoreId + ", progress=" + progress + ", permissions="
				+ permissions + ", oppPermissions=" + oppPermissions + ", leadPermissions=" + leadPermissions
				+ ", portfolioPermissions=" + portfolioPermissions + ", statisticsPermissions=" + statisticsPermissions
				+ ", auditPermissions=" + auditPermissions + "]";
	}

	

	

}
