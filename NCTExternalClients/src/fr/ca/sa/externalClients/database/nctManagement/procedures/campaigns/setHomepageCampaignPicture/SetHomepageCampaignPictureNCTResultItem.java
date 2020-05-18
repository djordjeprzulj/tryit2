package fr.ca.sa.externalClients.database.nctManagement.procedures.campaigns.setHomepageCampaignPicture;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from
 *         spSetAppHomePageCampaignPicture store procedure
 */
public class SetHomepageCampaignPictureNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String campaignPicture;
	private int campaignId;

	/**
	 * Set Homepage Campaign Picture NCT Result Item
	 * 
	 * @param campaignId	
	 * 				Campaign ID
	 */
	public SetHomepageCampaignPictureNCTResultItem(int campaignId) {
		super();
		this.campaignId = campaignId;
	}

	/**
	 * Set Homepage Campaign Picture NCT Result Item
	 * 
	 * @param campaignPicture
	 * 				Campaign picture
	 * 
	 * @param campaignId
	 * 				Campaign ID
	 */
	public SetHomepageCampaignPictureNCTResultItem(String campaignPicture, int campaignId) {
		super();
		this.campaignPicture = campaignPicture;
		this.campaignId = campaignId;
	}

	public String getCampaignPicture() {
		return campaignPicture;
	}

	public void setCampaignPicture(String campaignPicture) {
		this.campaignPicture = campaignPicture;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	@Override
	public String toString() {
		return "SetLanguageNCTResultItem [campaignPicture=" + campaignPicture + ", campaignId=" + campaignId + "]";
	}

}
