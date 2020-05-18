package fr.ca.sa.nct.commons.services.json.leadManagement;

import java.io.Serializable;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.nct.procedures.leadManagement.prospectRelates.getProspectRelates.GetProspectRelatesNCTResultList;
import fr.ca.sa.model.Prospect;
import fr.ca.sa.nct.commons.authorizationUtils.json.Target;
import fr.ca.sa.nct.commons.authorizationUtils.json.TargetAction;

/**
 * Request JSON wrapper for setting lead prospect
 * 
 * @author Nemanja Ignjatov
 *
 */
//FIXME create SetProspectResponse
public class SetProspectRequest implements Target, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Prospect prospect;
	private String setProspectError;

	private GetProspectRelatesNCTResultList relates;
	private List<Integer> competitors;

	private List<TargetAction> targetActionObjects;

	/**
	 * default constructor for Set Prospect Request
	 */
	public SetProspectRequest() {
		super();
	}

	/**
	 * Set Prospect Request
	 * 
	 * @param prospect
	 * 				Prospect
	 *   
	 * @param relates
	 * 				Relates
	 * 
	 * @param competitors
	 * 				Competitors
	 * 
	 * @param targetActions
	 * 				Target actions
	 *  
	 */
	public SetProspectRequest(Prospect prospect, String setProspectError, GetProspectRelatesNCTResultList relates, List<Integer> competitors, List<TargetAction> targetActions) {
		super();
		this.prospect = prospect;
		this.setProspectError=setProspectError;		
		this.relates = relates;
		this.competitors = competitors;
		this.targetActionObjects = targetActions;		
	}

	public Prospect getProspect() {
		return prospect;
	}

	public void setProspect(Prospect prospect) {
		this.prospect = prospect;
	}

	public String getSetProspectError() {
		return setProspectError;
	}

	public void setSetProspectError(String setProspectError) {
		this.setProspectError = setProspectError;
	}

	public GetProspectRelatesNCTResultList getRelates() {
		return relates;
	}

	public void setRelates(GetProspectRelatesNCTResultList relates) {
		this.relates = relates;
	}

	public List<Integer> getCompetitors() {
		return competitors;
	}

	public void setCompetitors(List<Integer> competitors) {
		this.competitors = competitors;
	}

	public void setTargetActionObjects(List<TargetAction> targetActionObjects) {
		this.targetActionObjects = targetActionObjects;
	}

	@Override
	public String toString() {
		return "SetProspectRequest [prospect=" + prospect + ", setProspectError=" + setProspectError + ", relates="
				+ relates + ", competitors=" + competitors + ", targetActionObjects=" + targetActionObjects + "]";
	}

	@Override
	public List<TargetAction> getTargetActionObjects() {
		return targetActionObjects;
	}

	@Override
	public void defineTargetActionObjects() {
	}
	
}
