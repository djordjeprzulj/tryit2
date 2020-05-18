package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.AbstractStoreProcedureResultImages;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketPostponedListImages extends AbstractStoreProcedureResultImages implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private GetBasketPostponedOffersList postponed;

	public static final String PRODUCT_GROUP_PIC_MAP_NAME = NCTDatabaseConstants.PRODUCT_GROUP_PICTURES_MAP_NAME;

	/**
	 * default constructor for Get Basket Postponed List Images
	 */
	public GetBasketPostponedListImages() {
		super();
		this.postponed = new GetBasketPostponedOffersList();
	}

	public GetBasketPostponedOffersList getPostponed() {
		return postponed;
	}

	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}
	
	@Override
	public StoreProcedureResult getDataObject() {
		return postponed;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { GetBasketPostponedListImages.PRODUCT_GROUP_PIC_MAP_NAME };
	}

	@Override
	public void mergePictureURI(String imageMapName, String key, String pictureURI) {
		if (imageMapName.equals(GetBasketPostponedListImages.PRODUCT_GROUP_PIC_MAP_NAME)) {
			this.postponed.getPostponedList().stream()
					.filter(postponed -> String.valueOf(postponed.getProductGroupId()).equals(key)).forEach(product -> {
						product.setProductGroupPicture(pictureURI);
					});
		}

	}

	@Override
	public String toString() {
		return "GetBasketPostponedListImages [postponed=" + postponed + ", productPicMapName=" + PRODUCT_GROUP_PIC_MAP_NAME
				+ "]";
	}
}
