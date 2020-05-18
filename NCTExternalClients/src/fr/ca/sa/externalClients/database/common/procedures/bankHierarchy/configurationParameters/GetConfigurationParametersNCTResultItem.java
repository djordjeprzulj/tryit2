package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.configurationParameters;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * @author Nemanja Ignjatov
 *
 *         Wrapper class for single result in result set from
 *         spGetCONFIGURATION_PARAMS store procedure
 */
public class GetConfigurationParametersNCTResultItem implements StoreProcedureResult {

	private int parameterId;
	private String configurationTypeName;
	private String parameterName;
	private String parameterValue;
	private String type;
	private Integer minValue;
	private Integer maxValue;
	private Integer minLength;
	private Integer maxLength;
	private String description;

	/**
	 * default constructor for Get Configuration Parameters NCT Result Item
	 */
	public GetConfigurationParametersNCTResultItem() {
		super();
	}

	/**
	 * Get Configuration Parameters NCT Result Item
	 * 
	 * @param parameterId
	 * 				Parameter ID
	 * 
	 * @param configurationTypeName
	 * 				Configuration type name
	 * 
	 * @param parameterName
	 * 				Parameter name
	 * 
	 * @param parameterValue
	 * 				Parameter value
	 * 
	 * @param type
	 * 				Type
	 * 
	 * @param minValue
	 * 				Minimal value
	 * 
	 * @param maxValue
	 * 				Maximal value
	 * 
	 * @param minLength
	 * 				Minimal length
	 * 
	 * @param maxLength
	 * 				Maximal length
	 * 
	 * @param description
	 * 				Description
	 */
	public GetConfigurationParametersNCTResultItem(int parameterId, String configurationTypeName, String parameterName,
			String parameterValue, String type, Integer minValue, Integer maxValue, Integer minLength,
			Integer maxLength, String description) {
		super();
		this.parameterId = parameterId;
		this.configurationTypeName = configurationTypeName;
		this.parameterName = parameterName;
		this.parameterValue = parameterValue;
		this.type = type;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.minLength = minLength;
		this.maxLength = maxLength;
		this.description = description;
	}

	public int getParameterId() {
		return parameterId;
	}

	public void setParameterId(int parameterId) {
		this.parameterId = parameterId;
	}

	public String getConfigurationTypeName() {
		return configurationTypeName;
	}

	public void setConfigurationTypeName(String configurationTypeName) {
		this.configurationTypeName = configurationTypeName;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getMinValue() {
		return minValue;
	}

	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	public Integer getMinLength() {
		return minLength;
	}

	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "GetConfigurationParametersNCTResultItem [parameterId=" + parameterId + ", configurationTypeName="
				+ configurationTypeName + ", parameterName=" + parameterName + ", parameterValue=" + parameterValue
				+ ", type=" + type + ", minValue=" + minValue + ", maxValue=" + maxValue + ", minLength=" + minLength
				+ ", maxLength=" + maxLength + ", description=" + description + "]";
	}

}
