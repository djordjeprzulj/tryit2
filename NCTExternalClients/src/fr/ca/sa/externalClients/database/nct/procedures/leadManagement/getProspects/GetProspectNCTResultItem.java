package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.getProspects;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.nct.procedures.leadManagement.prospectRelates.getProspectRelates.GetProspectRelatesNCTResultList;
import fr.ca.sa.model.Prospect;

/**
 * 
 * Wrapper for returning single item of prospect in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetProspectNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Prospect prospect;
	
	private GetProspectRelatesNCTResultList relates;

	private List<Integer> competitors;

	private HashMap<String, Boolean> editPermissions;

	/**
	 * default constructor for Get Prospect NCT Result Item
	 */
	public GetProspectNCTResultItem() {
		super();
	}

	/**
	 * Get Prospect NCT Result Item
	 * 
	 * @param prospect
	 * 				Prospect
	 * 
	 * @param clientCodeTypeId
	 * 				Client code type ID
	 */
	public GetProspectNCTResultItem(Prospect prospect) {
		super();
		this.prospect = prospect;
		this.editPermissions = new HashMap<>();
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

	public Map<String, Boolean> getEditPermissions() {
		return editPermissions;
	}
	
	public Prospect getProspect() {
		return prospect;
	}

	public void setProspect(Prospect prospect) {
		this.prospect = prospect;
	}

	/**
	 * Set Edit Permissions
	 * 
	 * @param allFieldsAndSaveButtonEnabled
	 * 				Enabled fields and save button
	 * 
	 * @param changeStatusEnabled
	 * 				Change status enabled
	 */
	public void setEditPermissions(Boolean allFieldsAndSaveButtonEnabled, Boolean changeStatusEnabled) {
		if (this.editPermissions == null) {
			this.editPermissions = new HashMap<>();
		}
		this.editPermissions.put("ALL_FIELDS_AND_SAVE_BUTTON_ENABLED", allFieldsAndSaveButtonEnabled);
		this.editPermissions.put("CHANGE_STATUS_BUTTON_ENABLED", changeStatusEnabled);
	}

	@Override
	public String toString() {
		return "GetProspectNCTResultItem [prospect=" + prospect				
				+ ", relates=" + relates + ", competitors=" + competitors + ", editPermissions=" + editPermissions
				+ "]";
	}

}
