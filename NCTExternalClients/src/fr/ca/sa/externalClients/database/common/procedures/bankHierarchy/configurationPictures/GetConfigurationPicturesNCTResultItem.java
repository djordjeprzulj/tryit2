package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.configurationPictures;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from
 *         spGetCONFIGURATION_PICTURES store procedure
 */
public class GetConfigurationPicturesNCTResultItem implements StoreProcedureResult, Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;
	
	private int paramId;
	private String paramName;
	private String description;

	private String paramValue;

	/**
	 * default constructor for Get Configuration Pictures NCT Result Item
	 */
	public GetConfigurationPicturesNCTResultItem() {
		super();
	}

	/**
	 * Get Configuration Pictures NCT Result Item
	 * 
	 * @param paramId
	 * 				Parameter ID
	 * 
	 * @param paramName
	 * 				Parameter name
	 * 
	 * @param description
	 * 				Description
	 */
	public GetConfigurationPicturesNCTResultItem(int paramId, String paramName, String description) {
		super();
		this.paramId = paramId;
		this.paramName = paramName;
		this.description = description;
	}

	public int getParamId() {
		return paramId;
	}

	public void setParamId(int paramId) {
		this.paramId = paramId;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	@Override
	public String toString() {
		return "GetConfigurationPicturesNCTResultItem [paramId=" + paramId + ", paramName=" + paramName
				+ ", description=" + description + ", paramValue=" + paramValue + "]";
	}

}
