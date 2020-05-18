package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.configurationPictures;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.AbstractStoreProcedureResultImages;

/**
 * 
 * Data holder for bank parameters list retrieved from database. Used in pair
 * with @GetBankParametersNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetConfigurationPicturesNCTResultListImages extends AbstractStoreProcedureResultImages
		implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private GetConfigurationPicturesNCTResultList pictures;

	public static final String CONFIG_PIC_NAME = "paramValue";

	/**
	 * default constructor for Get Configuration Pictures NCT Result List Images
	 */
	public GetConfigurationPicturesNCTResultListImages() {
		super();
		this.pictures = new GetConfigurationPicturesNCTResultList();
	}

	public GetConfigurationPicturesNCTResultList getPictures() {
		return pictures;
	}

	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}
	
	@Override
	public StoreProcedureResult getDataObject() {
		return this.pictures;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { GetConfigurationPicturesNCTResultListImages.CONFIG_PIC_NAME };
	}

	/**
	 * Merge picture URI
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
		if (imageMapName.equals(GetConfigurationPicturesNCTResultListImages.CONFIG_PIC_NAME)) {
			this.pictures.getPictures().stream().filter(param -> key.equals(String.valueOf(param.getParamId())))
					.forEach(param -> {
						param.setParamValue(pictureURI);
					});
		}
	}

	@Override
	public String toString() {
		return "GetConfigurationPicturesNCTResultListImages [pictures=" + pictures + "]";
	}

}
