package fr.ca.sa.externalClients.database.common.procedures.campaigns.getHomepageCampaigns;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.AbstractStoreProcedureResultImages;

/**
 * 
 * Data holder for bank parameters list retrieved from database. Used in pair
 * with @GetHomepageCampaignsNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetHomepageCampaignsNCTResultListImages extends AbstractStoreProcedureResultImages
		implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private GetHomepageCampaignsNCTResultList parameters;

	public static final String CAMPAIGN_PIC_NAME = "campaignPicture";

	/**
	 * default constructor for Get Homepage Campaigns NCT Result List Images
	 */
	public GetHomepageCampaignsNCTResultListImages() {
		super();
		this.parameters = new GetHomepageCampaignsNCTResultList();
	}

	public GetHomepageCampaignsNCTResultList getParameters() {
		return parameters;
	}

	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}
	
	@Override
	public StoreProcedureResult getDataObject() {
		return this.parameters;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { GetHomepageCampaignsNCTResultListImages.CAMPAIGN_PIC_NAME };
	}

	/**
	 * Merge picture URI
	 * 
	 * @param imageMapName
	 * 				Image map name
	 * @param key
	 * 				Key
	 * 
	 * @param pictureURI
	 * 				Picture URI
	 */
	public void mergePictureURI(String imageMapName, String key, String pictureURI) {
		if (imageMapName.equals(GetHomepageCampaignsNCTResultListImages.CAMPAIGN_PIC_NAME)) {
			this.parameters.getCampaigns().stream()
					.filter(campaign -> key.equals(String.valueOf(campaign.getCampaignOrder()))).forEach(param -> {
						param.setCampaignPicture(pictureURI);
					});
		}
	}

	@Override
	public String toString() {
		return "GetHomepageCampaignsNCTResultListImages [parameters=" + parameters + "]";
	}

}
