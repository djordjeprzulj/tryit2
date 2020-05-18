package fr.ca.sa.nct.commons.services.json.agenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.json.Target;
import fr.ca.sa.nct.commons.authorizationUtils.json.TargetAction;

/**
 * 
 * Request from client to retrieve Agenda data for specific user/entity
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaRequest implements Target, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String lang;

	private String fromTime;

	private String toTime;

	private Integer branchId;

	private Integer userId;

	/**
	 * default constructor for Agenda Request
	 */
	public AgendaRequest() {
		super();
	}

	/**
	 * Agenda Request
	 * 
	 * @param fromTime
	 * 			From time
	 * 
	 * @param toTime
	 * 			To time
	 * 
	 * @param branchId
	 * 			Branch ID
	 * 
	 * @param lang
	 * 			Language
	 */
	public AgendaRequest(String fromTime, String toTime, Integer branchId, String lang) {
		super();
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.branchId = branchId;
		this.userId = null;
		this.lang = lang;
	}

	/**
	 * Agenda Request
	 * 
	 * @param fromTime
	 * 				From time
	 * 
	 * @param toTime
	 * 				To time
	 * 
	 * @param branchId
	 * 				Branch ID
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param lang
	 * 				Language
	 */
	public AgendaRequest(String fromTime, String toTime, Integer branchId, Integer userId, String lang) {
		super();
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.branchId = branchId;
		this.userId = userId;
		this.lang = lang;
	}

	@Override
	public List<TargetAction> getTargetActionObjects() {
		TargetAction ta = new TargetAction(branchId, userId);
		ArrayList<TargetAction> list = new ArrayList<>();
		list.add(ta);
		return list;
	}

	@Override
	public void defineTargetActionObjects() {
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		return "AgendaRequest [lang=" + lang + ", fromTime=" + fromTime + ", toTime=" + toTime + ", branchId="
				+ branchId + ", userId=" + userId + "]";
	}

}
