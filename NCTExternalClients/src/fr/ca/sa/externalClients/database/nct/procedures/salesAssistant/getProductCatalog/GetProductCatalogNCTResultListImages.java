package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getProductCatalog;

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
public class GetProductCatalogNCTResultListImages extends AbstractStoreProcedureResultImages implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private GetProductCatalogNCTResultList products;

	public static final String PRODUCT_PIC_MAP_NAME = NCTDatabaseConstants.PRODUCT_PICTURES_MAP_NAME;

	/**
	 * default constructor for Get Products Groups NCT Result List Images
	 */
	public GetProductCatalogNCTResultListImages() {
		super();
		this.products = new GetProductCatalogNCTResultList();

	}

	public GetProductCatalogNCTResultList getProducts() {
		return products;
	}

	@Override
	public GetProductCatalogNCTResultList getDataObject() {
		return this.products;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { GetProductCatalogNCTResultListImages.PRODUCT_PIC_MAP_NAME };
	}

	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	/**
	 * Merge Picture URI
	 * 
	 * @param imageMapName
	 *            Image map name
	 * 
	 * @param key
	 *            Key
	 * 
	 * @param pictureURI
	 *            Picture URI
	 */
	public void mergePictureURI(String imageMapName, String key, String pictureURI) {
		if (imageMapName.equals(GetProductCatalogNCTResultListImages.PRODUCT_PIC_MAP_NAME)) {
			this.products.getProductsCatalog().stream()
					.filter(product -> key.equals(String.valueOf(product.getProduct().getId()))).forEach(product -> {
						product.getProduct().setPicture(pictureURI);
					});
		}
	}

	@Override
	public String toString() {
		return "GetProductCatalogNCTResultListImages [products=" + products + ", images=" + images + "]";
	}

}
