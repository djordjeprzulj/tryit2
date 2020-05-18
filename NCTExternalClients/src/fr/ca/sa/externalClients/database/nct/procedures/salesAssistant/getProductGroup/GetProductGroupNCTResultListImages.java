package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getProductGroup;

import java.io.Serializable;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.AbstractStoreProcedureResultImages;

/**
 * 
 * Data holder for opportunity products list retrieved from database. Used in
 * pair with @GetProductGroupNCTResultList
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetProductGroupNCTResultListImages extends AbstractStoreProcedureResultImages implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private GetProductGroupNCTResultList productsGroups;

	public static final String PRODUCT_GROUP_PIC_MAP_NAME = NCTDatabaseConstants.PRODUCT_GROUP_PICTURES_MAP_NAME;

	/**
	 * default constructor for Get Products Groups NCT Result List Images
	 */
	public GetProductGroupNCTResultListImages() {
		super();
		this.productsGroups = new GetProductGroupNCTResultList();

	}

	public GetProductGroupNCTResultList getProductsGroups() {
		return productsGroups;
	}

	@Override
	public GetProductGroupNCTResultList getDataObject() {
		return this.productsGroups;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { GetProductGroupNCTResultListImages.PRODUCT_GROUP_PIC_MAP_NAME };
	}

	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
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
		if (imageMapName.equals(GetProductGroupNCTResultListImages.PRODUCT_GROUP_PIC_MAP_NAME)) {
			this.productsGroups.getProductsGroups().stream()
					.filter(product -> key.equals(String.valueOf(product.getProductGroupId()))).forEach(product -> {
						product.setProductGroupPicture(pictureURI);
					});
		}
	}

	@Override
	public String toString() {
		return "GetProductGroupNCTResultListImages [productGroups=" + productsGroups + ", images=" + images + "]";
	}

}
