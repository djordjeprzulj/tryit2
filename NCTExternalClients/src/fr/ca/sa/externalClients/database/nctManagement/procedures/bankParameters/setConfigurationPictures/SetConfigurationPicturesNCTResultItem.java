package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.setConfigurationPictures;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from
 *         spSetCONFIGURATION_PICTURES store procedure
 */
public class SetConfigurationPicturesNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private String paramValue;

	/**
	 * default constructor for Set Configuration Pictures NCT Result Item
	 */
	public SetConfigurationPicturesNCTResultItem() {
		super();
	}

	/**
	 * Set Configuration Pictures NCT Result Item
	 * 
	 * @param paramValue
	 * 				Parameter value
	 */
	public SetConfigurationPicturesNCTResultItem(String paramValue) {
		super();
		this.paramValue = paramValue;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	@Override
	public String toString() {
		return "SetConfigurationPicturesNCTResultItem [paramValue=" + paramValue + "]";
	}

}
