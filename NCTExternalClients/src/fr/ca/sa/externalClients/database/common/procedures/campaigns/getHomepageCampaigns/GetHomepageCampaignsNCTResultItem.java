package fr.ca.sa.externalClients.database.common.procedures.campaigns.getHomepageCampaigns;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from
 *         spGetAppHomePageCampaigns store procedure
 */
public class GetHomepageCampaignsNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private int campaignId;
	private int campaignOrder;
	private String campaignUrl;
	private String campaignPicture;
	private int active;

	/**
	 * default constructor for Get Homepage Campaigns NCT Result Item
	 */
	public GetHomepageCampaignsNCTResultItem() {
		super();
	}

	/**
	 * Get Homepage Campaigns NCT Result Item
	 * 
	 * @param campaignId
	 * 				Campaign ID
	 * 
	 * @param campaignOrder
	 * 				Campaign order
	 * 
	 * @param campaignUrl
	 * 				Campaign URL
	 * 
	 * @param active
	 * 				Activity
	 */
	public GetHomepageCampaignsNCTResultItem(int campaignId, int campaignOrder, String campaignUrl, int active) {
		super();
		this.campaignId = campaignId;
		this.campaignOrder = campaignOrder;
		this.campaignUrl = campaignUrl;
		this.active = active;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public int getCampaignOrder() {
		return campaignOrder;
	}

	public void setCampaignOrder(int campaignOrder) {
		this.campaignOrder = campaignOrder;
	}

	public String getCampaignUrl() {
		return campaignUrl;
	}

	public void setCampaignUrl(String campaignUrl) {
		this.campaignUrl = campaignUrl;
	}

	public String getCampaignPicture() {
		return campaignPicture;
	}

	public void setCampaignPicture(String campaignPicture) {
		this.campaignPicture = campaignPicture;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "GetHomepageCampaignsNCTResultItem [campaignId=" + campaignId + ", campaignOrder=" + campaignOrder
				+ ", campaignUrl=" + campaignUrl + ", campaignPicture=" + campaignPicture + ", active=" + active + "]";
	}

}
