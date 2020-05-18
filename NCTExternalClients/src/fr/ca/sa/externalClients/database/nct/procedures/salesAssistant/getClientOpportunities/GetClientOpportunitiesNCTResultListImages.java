package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getClientOpportunities;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.AbstractStoreProcedureResultImages;

/**
 * 
 * Data holder for opportunity products list retrieved from database. Used in
 * pair with @GetOpportunityProductsNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientOpportunitiesNCTResultListImages extends AbstractStoreProcedureResultImages
		implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private GetClientOpportunitiesNCTResultList opportunities;

	public static final String OPPORTUNITY_PIC_MAP_NAME = "opportunityPicture";

	/**
	 * default constructor for Get Client Opportunities NCT Result List Images
	 */
	public GetClientOpportunitiesNCTResultListImages() {
		super();
		this.opportunities = new GetClientOpportunitiesNCTResultList();
	}

	public GetClientOpportunitiesNCTResultList getOpportunities() {
		return opportunities;
	}

	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}
	
	@Override
	public StoreProcedureResult getDataObject() {
		return this.opportunities;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { GetClientOpportunitiesNCTResultListImages.OPPORTUNITY_PIC_MAP_NAME };
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
		if (imageMapName.equals(GetClientOpportunitiesNCTResultListImages.OPPORTUNITY_PIC_MAP_NAME)) {
			this.opportunities.getOpportunities().stream()
					.filter(opportunity -> key.equals(String.valueOf(opportunity.getOpportunity().getId())))
					.forEach(opportunity -> {
						opportunity.getOpportunity().setCategoryPictureUri(pictureURI);
					});
		}
	}

	@Override
	public String toString() {
		return "GetOpportunitiesNCTResultListImages [opportunities=" + opportunities + "]";
	}

}
