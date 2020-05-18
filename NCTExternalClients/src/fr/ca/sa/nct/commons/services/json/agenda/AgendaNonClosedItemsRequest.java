package fr.ca.sa.nct.commons.services.json.agenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.json.Target;
import fr.ca.sa.nct.commons.authorizationUtils.json.TargetAction;

/**
 * 
 * REST request for retrieving user specific non closed agenda items
 * 
 * @author Sasa Radovanovic
 *
 */
public class AgendaNonClosedItemsRequest implements Target, Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer branchId;

	private Integer userId;

	
	/**
	 * default constructor for Agenda Non Closed Items Request
	 */
	public AgendaNonClosedItemsRequest() {
		super();
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

}
