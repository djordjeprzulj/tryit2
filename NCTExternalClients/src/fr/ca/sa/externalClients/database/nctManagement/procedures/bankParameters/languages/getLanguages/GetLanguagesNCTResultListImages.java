package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.languages.getLanguages;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.AbstractStoreProcedureResultImages;

/**
 * 
 * Data holder for bank languages list retrieved from database. Used in pair
 * with @GetLanguagesNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetLanguagesNCTResultListImages extends AbstractStoreProcedureResultImages implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private GetLanguagesNCTResultList languages;

	/**
	 * Flag picture name
	 */
	public static final String FLAG_PIC_NAME = "flagPicture";

	/**
	 * default constructor for Get Languages NCT Result List Images
	 */
	public GetLanguagesNCTResultListImages() {
		super();
		this.languages = new GetLanguagesNCTResultList();
	}

	public GetLanguagesNCTResultList getLanguages() {
		return languages;
	}

	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public StoreProcedureResult getDataObject() {
		return this.languages;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { GetLanguagesNCTResultListImages.FLAG_PIC_NAME };
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
		if (imageMapName.equals(GetLanguagesNCTResultListImages.FLAG_PIC_NAME)) {
			this.languages.getLanguages().stream().filter(param -> key.equals(String.valueOf(param.getLangId()))).forEach(param -> {
				param.setFlagPicture(pictureURI);
			});
		}
	}

	@Override
	public String toString() {
		return "GetLanguagesNCTResultListImages [languages=" + languages + "]";
	}

}
