package fr.ca.sa.nct.commons.services.json.agenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.json.Target;
import fr.ca.sa.nct.commons.authorizationUtils.json.TargetAction;

/**
 * 
 * Set Work time request for changing worktime information of specific entity
 * 
 * @author Sasa Radovanovic
 *
 */
public class SetWorktimeRequest implements Target, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<SingleDayWorktimeRequest> dayTimes;

	private Integer branchId;

	private Integer userId;

	@Override
	public List<TargetAction> getTargetActionObjects() {
		TargetAction ta = new TargetAction(branchId, userId);
		ArrayList<TargetAction> taList = new ArrayList<>();
		taList.add(ta);
		return taList;
	}

	@Override
	public void defineTargetActionObjects() {
	}

	/**
	 * default constructor for Worktime request
	 */
	public SetWorktimeRequest() {
		super();
	}

	public List<SingleDayWorktimeRequest> getDayTimes() {
		return dayTimes;
	}

	public void setDayTimes(List<SingleDayWorktimeRequest> dayTimes) {
		this.dayTimes = dayTimes;
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

	@Override
	public String toString() {
		return "SetWorktimeRequest [dayTimes=" + dayTimes + ", branchId=" + branchId + ", userId=" + userId + "]";
	}
}
