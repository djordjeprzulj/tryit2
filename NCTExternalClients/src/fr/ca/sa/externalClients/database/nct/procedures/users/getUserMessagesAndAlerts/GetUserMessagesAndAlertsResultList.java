package fr.ca.sa.externalClients.database.nct.procedures.users.getUserMessagesAndAlerts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * Holder for User messages and alerts List
 * 
 * @author Stefan Djokic
 *
 */
public class GetUserMessagesAndAlertsResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetUserMessagesAndAlertsItem> userMessagesAndAlerts;

	/**
	 * default constructor for Get User Messages And Alerts Result List
	 */
	public GetUserMessagesAndAlertsResultList() {
		super();
		this.userMessagesAndAlerts = new ArrayList<>();
	}

	/**
	 * Get User Messages And Alerts Result List
	 * 
	 * @param usermessagesAndAlerts
	 * 				User messages and alerts
	 */
	public GetUserMessagesAndAlertsResultList(List<GetUserMessagesAndAlertsItem> usermessagesAndAlerts) {
		super();
		this.userMessagesAndAlerts = usermessagesAndAlerts;
	}

	public List<GetUserMessagesAndAlertsItem> getUserMessagesAndAlerts() {
		return userMessagesAndAlerts;
	}

	public void setUserMessagesAndAlerts(List<GetUserMessagesAndAlertsItem> userMessagesAndAlerts) {
		this.userMessagesAndAlerts = userMessagesAndAlerts;
	}

	@Override
	public String toString() {
		return "GetUserMessagesAndAlertsResultList [userMessagesAndAlerts=" + userMessagesAndAlerts + "]";
	}

}
