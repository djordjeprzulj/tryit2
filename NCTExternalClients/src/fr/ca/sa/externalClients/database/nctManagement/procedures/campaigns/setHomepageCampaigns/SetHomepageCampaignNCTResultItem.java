package fr.ca.sa.externalClients.database.nctManagement.procedures.campaigns.setHomepageCampaigns;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from
 *         spSetAppHomePageCampaign store procedure
 */
public class SetHomepageCampaignNCTResultItem implements StoreProcedureResult {

	private int campaignId;

	/**
	 * default constructor for Set Homepage Campaign NCT Result Item
	 */
	public SetHomepageCampaignNCTResultItem() {
		super();
	}

	/**
	 * Set Homepage Campaign NCT Result Item
	 * 
	 * @param campaignId
	 * 				Campaign ID
	 */
	public SetHomepageCampaignNCTResultItem(int campaignId) {
		super();
		this.campaignId = campaignId;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	@Override
	public String toString() {
		return "SetHomepageCampaignNCTResultItem [campaignId=" + campaignId + "]";
	}

}
