package fr.ca.sa.externalClients.database.common.procedures.campaigns.getHomepageCampaigns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for all results from spGetAppHomePageCampaigns store
 *         procedure
 */

public class GetHomepageCampaignsNCTResultList implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private List<GetHomepageCampaignsNCTResultItem> campaigns;

	/**
	 * default constructor for Get Homepage Campaigns NCT Result List
	 */
	public GetHomepageCampaignsNCTResultList() {
		super();
		campaigns = new ArrayList<GetHomepageCampaignsNCTResultItem>();
	}

	/**
	 * Get Homepage Campaigns NCT Result List
	 * 
	 * @param campaigns
	 * 				Campaigns
	 */
	public GetHomepageCampaignsNCTResultList(List<GetHomepageCampaignsNCTResultItem> campaigns) {
		super();
		this.campaigns = campaigns;
	}

	public List<GetHomepageCampaignsNCTResultItem> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(List<GetHomepageCampaignsNCTResultItem> campaigns) {
		this.campaigns = campaigns;
	}

	@Override
	public String toString() {
		StringBuilder sbRetValue = new StringBuilder("GetHomepageCampaignsNCTResultList [ ");
		if (this.campaigns != null) {
			for (GetHomepageCampaignsNCTResultItem campaign : this.campaigns) {
				sbRetValue.append(campaign.toString());
			}
			sbRetValue.append(" ]");
			return sbRetValue.toString();
		}

		return "GetHomepageCampaignsNCTResultList is empty!!!";
	}

}
