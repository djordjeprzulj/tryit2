package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getNeedsCategories;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.AbstractStoreProcedureResultImages;

/**
 * 
 * Data holder for opportunity products list retrieved from database. Used in
 * pair with @GetNeedsCategoriesNCTResultList
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetNeedsCategoriesNCTResultListImages extends AbstractStoreProcedureResultImages implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private GetNeedsCategoriesNCTResultList needsCategories;

	public static final String NEED_CAT_PIC_MAP_NAME = "needCategoryPicture";

	public static final String NEED_CAT_ICON_NAME = "needCategoryIcon";

	/**
	 * default constructor for Get Needs Categories NCT Result List Images
	 */
	public GetNeedsCategoriesNCTResultListImages() {
		super();
		this.needsCategories = new GetNeedsCategoriesNCTResultList();
	}

	public GetNeedsCategoriesNCTResultList getNeedsCategories() {
		return needsCategories;
	}

	@Override
	public StoreProcedureResult getDataObject() {
		return this.needsCategories;
	}

	@Override
	public String[] getImagesMapsNames() {

		return new String[] { GetNeedsCategoriesNCTResultListImages.NEED_CAT_PIC_MAP_NAME,
				GetNeedsCategoriesNCTResultListImages.NEED_CAT_ICON_NAME };
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
		if (imageMapName.equals(GetNeedsCategoriesNCTResultListImages.NEED_CAT_PIC_MAP_NAME)) {
			this.needsCategories.getNeedsCategories().stream()
					.filter(need -> key.equals(String.valueOf(need.getNeedCategory().getId()))).forEach(need -> {
						need.getNeedCategory().setPicture(pictureURI);
					});
		} else if (imageMapName.equals(GetNeedsCategoriesNCTResultListImages.NEED_CAT_ICON_NAME)) {
			this.needsCategories.getNeedsCategories().stream()
					.filter(need -> key.equals(String.valueOf(need.getNeedCategory().getId()))).forEach(need -> {
						need.getNeedCategory().setIcon(pictureURI);
					});
		}
	}

	@Override
	public String toString() {
		return "GetNeedsCategoriesNCTResultListImages [products=" + needsCategories + "]";
	}

}
