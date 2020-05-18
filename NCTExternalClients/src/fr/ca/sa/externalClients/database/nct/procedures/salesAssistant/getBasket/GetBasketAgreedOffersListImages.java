package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.AbstractStoreProcedureResultImages;

/**
 * 
 * Data holder for agreed offers list with images
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketAgreedOffersListImages extends AbstractStoreProcedureResultImages implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private GetBasketAgreedOffersList agreed;

	public static final String PRODUCT_GROUP_PIC_MAP_NAME = NCTDatabaseConstants.PRODUCT_GROUP_PICTURES_MAP_NAME;

	/**
	 * default constructor for Get Basket Agreed Offers List Images
	 */
	public GetBasketAgreedOffersListImages() {
		super();
		this.agreed = new GetBasketAgreedOffersList();
	}

	public GetBasketAgreedOffersList getAgreed() {
		return agreed;
	}

	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}
	
	@Override
	public StoreProcedureResult getDataObject() {
		return agreed;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { GetBasketAgreedOffersListImages.PRODUCT_GROUP_PIC_MAP_NAME };
	}

	@Override
	public void mergePictureURI(String imageMapName, String key, String pictureURI) {
		if (imageMapName.equals(GetBasketAgreedOffersListImages.PRODUCT_GROUP_PIC_MAP_NAME)) {
			this.agreed.getAgreedList().stream().filter(agreed -> String.valueOf(agreed.getProductGroupId()).equals(key))
					.forEach(product -> {
						product.setProductGroupPicture(pictureURI);
					});
		}
	}

	@Override
	public String toString() {
		return "GetBasketAgreedOffersListImages [agreed=" + agreed + ", productPicMapName=" + PRODUCT_GROUP_PIC_MAP_NAME
				+ "]";
	}

}
