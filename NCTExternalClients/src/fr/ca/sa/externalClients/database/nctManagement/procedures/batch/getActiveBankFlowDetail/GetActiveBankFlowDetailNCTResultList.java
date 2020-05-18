package fr.ca.sa.externalClients.database.nctManagement.procedures.batch.getActiveBankFlowDetail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetActiveBankFlowDetailNCTResultList implements StoreProcedureResult, Serializable {
	
	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private List<GetActiveBankFlowDetailNCTResultItem> activeBankFlowDetails;
	
	/**
	 * default constructor for Get Active Bank Flow Detail NCT Result List
	 */
	public GetActiveBankFlowDetailNCTResultList() {
		super();
		activeBankFlowDetails=new ArrayList<GetActiveBankFlowDetailNCTResultItem>();
	}

	/**
	 * Get Active Bank Flow Detail NCT Result List
	 * 
	 * @param activeBankFlowDetails
	 * 				Active bank flow details
	 */
	public GetActiveBankFlowDetailNCTResultList(List<GetActiveBankFlowDetailNCTResultItem> activeBankFlowDetails) {
		super();
		this.activeBankFlowDetails = activeBankFlowDetails;
	}

	public List<GetActiveBankFlowDetailNCTResultItem> getActiveBankFlowDetails() {
		return activeBankFlowDetails;
	}

	public void setActiveBankFlowDetails(List<GetActiveBankFlowDetailNCTResultItem> activeBankFlowDetails) {
		this.activeBankFlowDetails = activeBankFlowDetails;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetFlowColumnsNCTResultList [ ");
		if (this.activeBankFlowDetails != null) {
			for (GetActiveBankFlowDetailNCTResultItem column : this.activeBankFlowDetails) {
				sbRetValue.append(column.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetFlowColumnsNCTResultList is empty!!!";
	}
	
	
}
