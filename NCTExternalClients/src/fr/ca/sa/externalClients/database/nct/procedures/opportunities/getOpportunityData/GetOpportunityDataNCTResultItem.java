package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityData;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.Opportunity;
import fr.ca.sa.nct.commons.authorizationUtils.permissionHolders.OpportunityItemPermission;

/**
 * 
 * Wrapper for returning single item of opportunity in JSON response
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetOpportunityDataNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int rowId;
	
	private Opportunity opportunity;
	/**
	 * default constructor for Get Opportunity Data NCT Result Item
	 */
	public GetOpportunityDataNCTResultItem() {
		super();
	}

	/**
	 * Get Opportunity Data NCT Result Item
	 * 
	 * @param rowId
	 * 				Row ID
	 * 
	 * @param opportunity
	 * 				Opportunity
	 * 
	 */
	public GetOpportunityDataNCTResultItem(int rowId, Opportunity opportunity) {
		super();
		this.rowId = rowId;
		this.opportunity = opportunity;
/*
		if (opportunityStartDate != null) {
			DateFormat df = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
			this.opportunityStartDate = df.format(opportunityStartDate);
		}

		if (opportunityExpirationDate != null) {
			DateFormat df = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
			this.opportunityExpirationDate = df.format(opportunityExpirationDate);
		}
*/
		opportunity.setPermission(new OpportunityItemPermission()); 
	}

	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public Opportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}

	@Override
	public String toString() {
		return "GetOpportunityDataNCTResultItem [rowId=" + rowId + ", opportunity=" + opportunity + "]";
	}

}
