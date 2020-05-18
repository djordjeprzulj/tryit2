package fr.ca.sa.externalClients.database.common.procedures.users.getUserEntities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Holder for User Entities List
 * 
 * @author Sasa Radovanovic
 *
 */
public class UserEntitiesList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<UserEntityItem> userEntities;

	/**
	 * default constructor for User Entities List
	 */
	public UserEntitiesList() {
		super();
		userEntities = new ArrayList<>();
	}

	/**
	 * User Entities List
	 * 
	 * @param userEntities
	 * 				User entities
	 */
	public UserEntitiesList(List<UserEntityItem> userEntities) {
		super();
		this.userEntities = userEntities;
	}

	public List<UserEntityItem> getUserEntities() {
		return userEntities;
	}

	public void setUserEntities(List<UserEntityItem> userEntities) {
		this.userEntities = userEntities;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetAdvisorsNCTResultList [ ");
		if(userEntities != null){
			for (UserEntityItem entity : userEntities) {
				sbRetValue.append(entity.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}
		
		return "GetAdvisorsNCTResultList is empty!!!";
	}
}
