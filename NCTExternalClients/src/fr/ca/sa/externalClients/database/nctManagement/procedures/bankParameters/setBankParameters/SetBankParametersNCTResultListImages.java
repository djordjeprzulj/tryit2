package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.setBankParameters;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.AbstractStoreProcedureResultImages;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankParameters.GetBankParametersNCTResultListImages;

/**
 * 
 * Data holder for opportunity products list retrieved from database. Used in
 * pair with @GetOpportunityProductsNCTResultItem
 * 
 * @author Nemanja Ignjatov
 *
 */
public class SetBankParametersNCTResultListImages extends AbstractStoreProcedureResultImages implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private SetBankParametersNCTResultItem parameter;

	/**
	 * Logo picture name
	 */
	public static final String LOGO_PIC_NAME = "logo";

	/**
	 * default constructor for Set Bank Parameters NCT Result List Images
	 */
	public SetBankParametersNCTResultListImages() {
		super();

	}

	public void setParameter(SetBankParametersNCTResultItem parameter) {
		this.parameter = parameter;
	}

	@Override
	public String getClassName() {
		// Use get method classname, so that newly uploaded pictures have same
		// hash
		return GetBankParametersNCTResultListImages.class.getSimpleName();
	}

	@Override
	public StoreProcedureResult getDataObject() {
		return this.parameter;
	}

	@Override
	public String[] getImagesMapsNames() {
		return new String[] { SetBankParametersNCTResultListImages.LOGO_PIC_NAME };
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
		if (imageMapName.equals(SetBankParametersNCTResultListImages.LOGO_PIC_NAME)) {
			this.parameter = new SetBankParametersNCTResultItem(pictureURI);
		}
	}

	@Override
	public String toString() {
		return "SetBankParametersNCTResultListImages [logoPicName=" + SetBankParametersNCTResultListImages.LOGO_PIC_NAME + "]";
	}

}
