package fr.ca.sa.nct.commons.services.json.leadManagement;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.json.Target;
import fr.ca.sa.nct.commons.authorizationUtils.json.TargetAction;

/**
 * 
 * Request JSON wrapper for changing lead prospect status
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ChangeProspectStatusRequest implements Target, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int prospectId;
	private Integer clientId;
	private int newStatusId;
	private String changeDate;

	private List<TargetAction> targetActionObjects;

	/**
	 * default constructor for Change Prospect Status Request
	 */
	public ChangeProspectStatusRequest() {
		super();
	}

	/**
	 * Change Prospect Status Request
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param newStatusId
	 * 				New status ID
	 * 
	 * @param changeDate
	 * 				Change date
	 * 
	 * @param targetActionObjects
	 * 				Target action objects
	 */
	public ChangeProspectStatusRequest(int prospectId, Integer clientId, int newStatusId, String changeDate,
			List<TargetAction> targetActionObjects) {
		super();
		this.prospectId = prospectId;
		this.clientId = clientId;
		this.newStatusId = newStatusId;
		this.changeDate = changeDate;
		this.targetActionObjects = targetActionObjects;
	}

	public int getProspectId() {
		return prospectId;
	}

	public void setProspectId(int prospectId) {
		this.prospectId = prospectId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public int getNewStatusId() {
		return newStatusId;
	}

	public void setNewStatusId(int newStatusId) {
		this.newStatusId = newStatusId;
	}

	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

	@Override
	public List<TargetAction> getTargetActionObjects() {
		return targetActionObjects;
	}

	@Override
	public void defineTargetActionObjects() {
	}

	@Override
	public String toString() {
		return "ChangeProspectStatusRequest [prospectId=" + prospectId + ", clientId=" + clientId + ", newStatusId="
				+ newStatusId + ", changeDate=" + changeDate + ", targetActionObjects=" + targetActionObjects + "]";
	}

}
