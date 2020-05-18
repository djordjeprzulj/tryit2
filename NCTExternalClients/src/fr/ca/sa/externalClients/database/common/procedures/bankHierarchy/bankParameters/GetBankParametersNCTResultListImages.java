package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankParameters;

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
public class GetBankParametersNCTResultListImages extends AbstractStoreProcedureResultImages implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private GetBankParametersNCTResultList parameters;

	/**
	 * Logo picture name
	 */
	public static final String LOGO_PIC_NAME = "logo";
	
	/**
	 * Flag picture name
	 */
	public static final String FLAG_PIC_NAME = "flagPicture";

	/**
	 * default constructor for Get Bank Parameters NCT Result List Images
	 */
	public GetBankParametersNCTResultListImages() {
		super();
		this.parameters = new GetBankParametersNCTResultList();
	}

	public GetBankParametersNCTResultList getParameters() {
		return parameters;
	}

	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public StoreProcedureResult getDataObject() {
		return this.parameters;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { GetBankParametersNCTResultListImages.LOGO_PIC_NAME, GetBankParametersNCTResultListImages.FLAG_PIC_NAME };
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
		if (imageMapName.equals(GetBankParametersNCTResultListImages.LOGO_PIC_NAME)) {
			this.parameters.getParameters().stream().filter(param -> key.equals(String.valueOf(param.getBankId())))
					.forEach(param -> {
						param.setLogoPicture(pictureURI);
					});
		} else if (imageMapName.equals(GetBankParametersNCTResultListImages.FLAG_PIC_NAME)) {
			this.parameters.getParameters().stream().filter(param -> key.equals(String.valueOf(param.getLangId())))
					.forEach(param -> {
						param.setFlagPicture(pictureURI);
					});
		}
	}

	@Override
	public String toString() {
		return "GetBankParametersNCTResultListImages [parameters=" + parameters + "]";
	}

}
