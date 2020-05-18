package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.Map;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.model.BaseTranslatableProduct;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class TranslatableNeedSubCategoryProducts extends BaseTranslatableProduct implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int needCategoryId;

	/**
	 * default constructor for Translatable Need Sub Category Products
	 */
	public TranslatableNeedSubCategoryProducts() {
		super();
	}

	/**
	 * Translatable Need Sub Category Products
	 * 
	 * @param productId
	 * 				Product ID
	 * 
	 * @param productShortDescription
	 * 				Product short description
	 * 
	 * @param productLongDescription
	 * 				Product long description
	 * 
	 * @param productLongDescriptionLink
	 * 				Product long description link
	 * 
	 * @param productPicture
	 * 				Product picture
	 * 
	 * @param productTipsLink
	 * 				Product tips link
	 * 
	 * @param productTipsDesc
	 * 				Product tips description
	 * 
	 * @param productSimulatorLink
	 * 				Product simulator link
	 * 
	 * @param productColor
	 * 				Product color
	 * 
	 * @param productOwnedByClient
	 * 				Product owner by client
	 * 
	 * @param productHasAmount
	 * 				Product has amount
	 * 
	 * @param productHasPieces
	 * 				Product has pieces
	 * 
	 * @param needCategoryId
	 * 				Need category ID
	 * 
	 * @param productNames
	 * 				Product names
	 * 
	 * @param productGroupPicture
	 * 				Product group picture
	 * 
	 * @param productIdExt
	 * 				Product ID external
	 */
	public TranslatableNeedSubCategoryProducts(int id, Map<String, String> name, Map<String, String> shortDescription,
			Map<String, String> longDescription, Map<String, String> tipsDesc, String longDescriptionLink,   
			String tipsLink, String simulatorLink, String color, Boolean ownedByClient, Boolean hasAmount, 
			Boolean hasPieces, Integer productIdExt, String picture, String groupPicture, int needCategoryId) {
		super(id, name, shortDescription, longDescription, tipsDesc, longDescriptionLink,   
				tipsLink, simulatorLink, color, ownedByClient, hasAmount, 
				hasPieces, productIdExt, picture, groupPicture);
		this.needCategoryId = needCategoryId;
	}

	public int getNeedCategoryId() {
		return needCategoryId;
	}

	public void setNeedCategoryId(int needCategoryId) {
		this.needCategoryId = needCategoryId;
	}

}
