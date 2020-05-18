package fr.ca.sa.externalClients.database.nctManagement.procedures.campaigns.setHomepageCampaignPicture;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.AbstractStoreProcedureResultImages;
import fr.ca.sa.externalClients.database.common.procedures.campaigns.getHomepageCampaigns.GetHomepageCampaignsNCTResultListImages;

/**
 * 
 * Data holder for opportunity products list retrieved from database. Used in
 * pair with @SetLanguageNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetHomepageCampaignPictureNCTResultListImages extends AbstractStoreProcedureResultImages implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private SetHomepageCampaignPictureNCTResultItem campaign;

	/**
	 * Campaign picture name
	 */
	public static final String CAMPAIGN_PIC_NAME = "campaignPicture";

	/**
	 * default constructor for Set Homepage Campaign Picture NCT Result List Images
	 */
	public SetHomepageCampaignPictureNCTResultListImages() {
		super();

	}

	public void setCampaign(SetHomepageCampaignPictureNCTResultItem campaign) {
		this.campaign = campaign;
	}

	@Override
	public String getClassName() {
		// Use get method classname, so that newly uploaded pictures have same
		// hash
		return GetHomepageCampaignsNCTResultListImages.class.getSimpleName();
	}

	@Override
	public StoreProcedureResult getDataObject() {
		return this.campaign;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { SetHomepageCampaignPictureNCTResultListImages.CAMPAIGN_PIC_NAME };
	}

	/**
	 * Merge Picture URI
	 * 
	 * @param imageMapName
	 * 				Image map name
	 * 
	 * @param key
	 * 				Key
	 * 
	 * @param pictureURI
	 * 				Picture URI
	 */
	public void mergePictureURI(String imageMapName, String key, String pictureURI) {
		if (imageMapName.equals(SetHomepageCampaignPictureNCTResultListImages.CAMPAIGN_PIC_NAME)) {
			this.campaign.setCampaignPicture(pictureURI);
		}
	}

	@Override
	public String toString() {
		return "SetHomepageCampaignPictureNCTResultListImages [campaignPicName=" + SetHomepageCampaignPictureNCTResultListImages.CAMPAIGN_PIC_NAME + "]";
	}

}
