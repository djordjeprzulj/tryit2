package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.configurationAttributes;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from
 *         spGetCONFIGURATION_ATTRIBUTES store procedure
 */
public class GetConfigurationAttributesNCTResultItem implements StoreProcedureResult {

	private String configurationTypeName;
	private String attributeName;

	/**
	 * default constructor for Get Configuration Attributes NCT Result Item
	 */
	public GetConfigurationAttributesNCTResultItem() {
		super();
	}

	/**
	 * Get Configuration Attributes NCT Result Item
	 * 
	 * @param configurationTypeName
	 * 				Configuration type name
	 * 
	 * @param attributeName
	 * 				Attribute name
	 */
	public GetConfigurationAttributesNCTResultItem(String configurationTypeName, String attributeName) {
		super();
		this.configurationTypeName = configurationTypeName;
		this.attributeName = attributeName;
	}

	public String getConfigurationTypeName() {
		return configurationTypeName;
	}

	public void setConfigurationTypeName(String configurationTypeName) {
		this.configurationTypeName = configurationTypeName;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	@Override
	public String toString() {
		return "GetConfigurationAttributesNCTResultItem [configurationTypeName=" + configurationTypeName
				+ ", attributeName=" + attributeName + "]";
	}

}
