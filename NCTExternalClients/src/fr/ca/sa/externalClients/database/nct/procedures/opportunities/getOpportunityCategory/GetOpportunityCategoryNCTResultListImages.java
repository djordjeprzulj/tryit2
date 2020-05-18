package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityCategory;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.AbstractStoreProcedureResultImages;

/**
 * 
 * Data holder for opportunity category list retrieved from database. Used in
 * pair with @GetOpportunityCategoryNCTResultList
 * 
 * @author Stefan Djokic
 *
 */
public class GetOpportunityCategoryNCTResultListImages extends AbstractStoreProcedureResultImages
		implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private GetOpportunityCategoryNCTResultList opportunityCategories;

	public static final String OPPORTUNITY_CATEGORIES_PIC_MAP_NAME = "opportunityCategoriesPicture";

	/**
	 * default constructor for Get Opportunity Category NCT Result List Images
	 */
	public GetOpportunityCategoryNCTResultListImages() {
		super();
		this.opportunityCategories = new GetOpportunityCategoryNCTResultList();

	}

	public GetOpportunityCategoryNCTResultList getOpportunityCategories() {
		return opportunityCategories;
	}

	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}
	
	@Override
	public GetOpportunityCategoryNCTResultList getDataObject() {
		return this.opportunityCategories;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { GetOpportunityCategoryNCTResultListImages.OPPORTUNITY_CATEGORIES_PIC_MAP_NAME };
	}

	/**
	 * Merge Picture URI
	 * 
	 * @param imageMapName
	 * 				Image map name
	 * @param key
	 * 				Key
	 * @param pictureURI
	 * 				Picture URI
	 */
	public void mergePictureURI(String imageMapName, String key, String pictureURI) {
		if (imageMapName.equals(GetOpportunityCategoryNCTResultListImages.OPPORTUNITY_CATEGORIES_PIC_MAP_NAME)) {
			this.opportunityCategories.getOpportunityCategories().stream()
					.filter(param -> key.equals(String.valueOf(param.getOppCategoryId()))).forEach(category -> {
						category.setOppCategoryPicture(pictureURI);
					});
		}
	}

	@Override
	public String toString() {
		return "GetOpportunityCategoryNCTResultListImages [opportunityCategories=" + opportunityCategories
				+ ", opportunityCategoriesPicMapName="
				+ GetOpportunityCategoryNCTResultListImages.OPPORTUNITY_CATEGORIES_PIC_MAP_NAME + "]";
	}

}
