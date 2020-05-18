package fr.ca.sa.nct.commons.commonEntities;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.procedures.users.getUserEntities.UserEntitiesList;
import fr.ca.sa.externalClients.database.common.procedures.users.getUserPortfolio.UserPortfolioList;
import fr.ca.sa.externalClients.database.common.procedures.users.getUserRoles.GetUserRoleNCTResult;

/**
 * 
 * Username and Role holder for authentication and authorization
 * 
 * @author Sasa Radovanovic
 *
 */
public class UsernameRoleHolder implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String username;

	private int userId;

	private Integer userCoreId;

	private GetUserRoleNCTResult role;

	private UserEntitiesList entitiesList;

	private UserPortfolioList userPortfolioList;

	private ConcurrentMap<Integer, WSDLCachedResponseContainer> wsdlResponses;

	/**
	 * default constructor for Username Role Holder
	 */
	public UsernameRoleHolder() {
		super();
		this.wsdlResponses = new ConcurrentHashMap<Integer, WSDLCachedResponseContainer>();
	}

	/**
	 * Username Role Holder
	 * 
	 * @param username
	 * 				Username
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param userCoreId
	 * 				User core ID
	 * 
	 * @param role
	 * 				Role
	 * 
	 * @param entitiesList
	 * 				Entities list
	 * 
	 * @param userPortfolioList
	 * 				User portfolio list
	 */
	public UsernameRoleHolder(String username, int userId, Integer userCoreId, GetUserRoleNCTResult role,
			UserEntitiesList entitiesList, UserPortfolioList userPortfolioList) {
		super();
		this.username = username;
		this.userId = userId;
		this.userCoreId = userCoreId;
		this.role = role;
		this.entitiesList = entitiesList;
		this.userPortfolioList = userPortfolioList;
		this.wsdlResponses = new ConcurrentHashMap<Integer, WSDLCachedResponseContainer>();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public GetUserRoleNCTResult getRole() {
		return role;
	}

	public void setRole(GetUserRoleNCTResult role) {
		this.role = role;
	}

	public UserEntitiesList getEntitiesList() {
		return entitiesList;
	}

	public void setEntitiesList(UserEntitiesList entitiesList) {
		this.entitiesList = entitiesList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserPortfolioList getUserPortfolioList() {
		return userPortfolioList;
	}

	public void setUserPortfolioList(UserPortfolioList userPortfolioList) {
		this.userPortfolioList = userPortfolioList;
	}

	public Integer getUserCoreId() {
		return userCoreId;
	}

	public ConcurrentMap<Integer, WSDLCachedResponseContainer> getWsdlResponses() {
		return wsdlResponses;
	}

	public void setWsdlResponses(ConcurrentMap<Integer, WSDLCachedResponseContainer> wsdlResponses) {
		this.wsdlResponses = wsdlResponses;
	}

	public void setUserCoreId(Integer userCoreId) {
		this.userCoreId = userCoreId;
	}

	@Override
	public String toString() {
		return "UsernameRoleHolder [username=" + username + ", userId=" + userId + ", userCoreId=" + userCoreId
				+ ", role=" + role + ", entitiesList=" + entitiesList + ", userPortfolioList=" + userPortfolioList
				+ "]";
	}

}
