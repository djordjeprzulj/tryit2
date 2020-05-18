package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getCancelReasons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * List of opportunities cancellation reasons fetched from DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunitiesCancelReasonsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<GetOpportunitiesCancelReasonsNCTResultItem> cancelReasons;

	/**
	 * default constructor for Get Opportunities Cancel Reasons NCT Result List
	 */
	public GetOpportunitiesCancelReasonsNCTResultList() {
		this.cancelReasons = new ArrayList<GetOpportunitiesCancelReasonsNCTResultItem>();
	}

	/**
	 * Get Opportunities Cancel Reasons NCT Result List
	 * 
	 * @param cancelReasons
	 * 				Cancel reasons
	 */
	public GetOpportunitiesCancelReasonsNCTResultList(
			List<GetOpportunitiesCancelReasonsNCTResultItem> cancelReasons) {
		super();
		this.cancelReasons = cancelReasons;
	}

	public List<GetOpportunitiesCancelReasonsNCTResultItem> getCancelReasons() {
		return cancelReasons;
	}

	public void setCancelReasons(List<GetOpportunitiesCancelReasonsNCTResultItem> cancelReasons) {
		this.cancelReasons = cancelReasons;
	}

	@Override
	public String toString() {
		return "GetOpportunitiesCancelReasonsNCTResultList [cancelReasons=" + cancelReasons + "]";
	}

}
