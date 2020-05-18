package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientOpportunities;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.Opportunity;

/**
 * 
 * Single client opportunity data holder retrieved from database
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientOpportunitiesNCTResultItem implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Opportunity opportunity;
	
	/*
	private int opportunityId;
	private int opportunityTypeId;
	private int opportunityStateId;
	private String opportunityStartDate;
	private String opportunityExpirationDate;
	private String opportunityCategoryPicture;
	private String treatmentPeriod;

	private String opportunitySubCategoryName;
	private String opportunityLongDescription;
	private String opportunityTipsLink;
	private String opportunityTipsDesc;
	private String opportunitySimulatorLink;
	private String opportunityPicture;
	private PermissionInterface opportunityPermissions;
	*/

	/**
	 * default constructor for Get Client Opportunities NCT Result Item
	 */
	public GetClientOpportunitiesNCTResultItem() {
		super();
	}

	/**
	 * Get Client Opportunities NCT Result Item
	 * 
	 * @param opportunity
	 * 				Opportunity
	 * 
	 */
	public GetClientOpportunitiesNCTResultItem(Opportunity opportunity) {
		super();
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
	}

	public Opportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}

	@Override
	public String toString() {
		return "GetClientOpportunitiesNCTResultItem [opportunity=" + opportunity + "]";
	}
}
