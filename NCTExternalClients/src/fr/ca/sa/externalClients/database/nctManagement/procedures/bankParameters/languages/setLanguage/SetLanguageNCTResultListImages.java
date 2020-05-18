package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.languages.setLanguage;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.AbstractStoreProcedureResultImages;
import fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.languages.getLanguages.GetLanguagesNCTResultListImages;

/**
 * 
 * Data holder for opportunity products list retrieved from database. Used in
 * pair with @SetLanguageNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetLanguageNCTResultListImages extends AbstractStoreProcedureResultImages implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private SetLanguageNCTResultItem language;

	/**
	 * Flag picture name
	 */
	public static final String FLAG_PIC_NAME = "flagPicture";

	/**
	 * default constructor for Set Language NCT Result List Images
	 */
	public SetLanguageNCTResultListImages() {
		super();

	}

	public void setParameter(SetLanguageNCTResultItem language) {
		this.language = language;
	}

	@Override
	public String getClassName() {
		// Use get method classname, so that newly uploaded pictures have same
		// hash
		return GetLanguagesNCTResultListImages.class.getSimpleName();
	}

	@Override
	public StoreProcedureResult getDataObject() {
		return this.language;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { SetLanguageNCTResultListImages.FLAG_PIC_NAME };
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
		if (imageMapName.equals(SetLanguageNCTResultListImages.FLAG_PIC_NAME)) {
			this.language.setFlagPicture(pictureURI);
		}
	}

	@Override
	public String toString() {
		return "SetLanguageNCTResultListImages [flagPicName=" + SetLanguageNCTResultListImages.FLAG_PIC_NAME + "]";
	}

}
