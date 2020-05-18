package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.io.Serializable;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.AbstractStoreProcedureResultImages;

/**
 * 
 * Data holder for offers list with images
 * 
 * @author Sasa Radovanovic
 *
 */
public class GetBasketNotIntOfferListImages extends AbstractStoreProcedureResultImages implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private GetBasketNotIntOfferList notInterested;

	public static final String PRODUCT_GROUP_PIC_MAP_NAME = NCTDatabaseConstants.PRODUCT_GROUP_PICTURES_MAP_NAME;

	/**
	 * default constructor for Get Basket Not Interested Offer List Images
	 */
	public GetBasketNotIntOfferListImages() {
		super();
		this.notInterested = new GetBasketNotIntOfferList();
	}

	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}
	
	public GetBasketNotIntOfferList getNotInterested() {
		return notInterested;
	}

	@Override
	public StoreProcedureResult getDataObject() {
		return notInterested;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { GetBasketNotIntOfferListImages.PRODUCT_GROUP_PIC_MAP_NAME };
	}

	@Override
	public void mergePictureURI(String imageMapName, String key, String pictureURI) {
		if (imageMapName.equals(GetBasketNotIntOfferListImages.PRODUCT_GROUP_PIC_MAP_NAME)) {
			this.notInterested.getNotInterestedList().stream()
					.filter(notInt -> String.valueOf(notInt.getProductGroupId()).equals(key)).forEach(product -> {
						product.setProductGroupPicture(pictureURI);
					});
		}

	}

	@Override
	public String toString() {
		return "GetBasketNotIntOfferListImages [notInterested=" + notInterested + ", productPicMapName="
				+ PRODUCT_GROUP_PIC_MAP_NAME + "]";
	}

}
