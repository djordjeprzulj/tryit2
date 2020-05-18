package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.setConfigurationPictures;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.AbstractStoreProcedureResultImages;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.configurationPictures.GetConfigurationPicturesNCTResultListImages;

/**
 * 
 * Data holder for configuration list retrieved from database.
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetConfigurationPicturesNCTResultListImages extends AbstractStoreProcedureResultImages
		implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private SetConfigurationPicturesNCTResultItem picture;

	/**
	 * configuration picture name
	 */
	public static final String CONFIG_PIC_NAME = "paramValue";

	/**
	 * default constructor for Set Configuration Pictures NCT Result List Images
	 */
	public SetConfigurationPicturesNCTResultListImages() {
		super();

	}

	public void setParameter(SetConfigurationPicturesNCTResultItem picture) {
		this.picture = picture;
	}

	@Override
	public String getClassName() {
		// Use get method classname, so that newly uploaded pictures have same
		// hash
		return GetConfigurationPicturesNCTResultListImages.class.getSimpleName();
	}

	@Override
	public StoreProcedureResult getDataObject() {
		return this.picture;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { SetConfigurationPicturesNCTResultListImages.CONFIG_PIC_NAME };
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
		if (imageMapName.equals(SetConfigurationPicturesNCTResultListImages.CONFIG_PIC_NAME)) {
			this.picture = new SetConfigurationPicturesNCTResultItem(pictureURI);
		}
	}

	@Override
	public String toString() {
		return "SetConfigurationPicturesNCTResultListImages [configPicName=" + SetConfigurationPicturesNCTResultListImages.CONFIG_PIC_NAME + "]";
	}

}
