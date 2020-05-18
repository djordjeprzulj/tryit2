package fr.ca.sa.nct.commons.services.json.portfolioManagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.nct.commons.authorizationUtils.json.Target;
import fr.ca.sa.nct.commons.authorizationUtils.json.TargetAction;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ReassignProspectPortfolioRequest implements Target, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int prospectId;
	private int portfolioId;

	private ArrayList<TargetAction> targetActionObjects;

	/**
	 * default constructor for Reassign Prospect Portfolio Request
	 */
	public ReassignProspectPortfolioRequest() {
		super();
	}

	/**
	 * Reassign Prospect Portfolio Request
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 * 
	 * @param portfolioId
	 * 				Portfolio ID
	 */
	public ReassignProspectPortfolioRequest(int prospectId, int portfolioId) {
		super();
		this.prospectId = prospectId;
		this.portfolioId = portfolioId;
	}

	public int getProspectId() {
		return prospectId;
	}

	public void setProspectId(int prospectId) {
		this.prospectId = prospectId;
	}

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}

	@Override
	public List<TargetAction> getTargetActionObjects() {
		return targetActionObjects;
	}

	@Override
	public void defineTargetActionObjects() {
	}
}
