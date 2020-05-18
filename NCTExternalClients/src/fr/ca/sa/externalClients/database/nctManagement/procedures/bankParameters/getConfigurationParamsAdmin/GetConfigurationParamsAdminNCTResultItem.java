package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.getConfigurationParamsAdmin;

/**
 * 
 * @author Nemanja Ignjatov
 * 
 *
 */
public class GetConfigurationParamsAdminNCTResultItem {

	private int parameterId;
	private String parameterName;
	private String parameterValue;
	private String parameterDataType;
	
	/**
	 * default constructor for Get Configuration Parameters Admin NCT Result Item
	 */
	public GetConfigurationParamsAdminNCTResultItem() {
		super();
	}
	
	/**
	 * Get Configuration Parameters Admin NCT Result Item
	 * 
	 * @param parameterId
	 * 				parameter ID
	 * 
	 * @param parameterName
	 * 				Parameter name
	 * 
	 * @param parameterValue
	 * 				Parameter value
	 * 
	 * @param parameterDataType
	 * 				Parameter data type
	 */
	public GetConfigurationParamsAdminNCTResultItem(int parameterId, String parameterName, String parameterValue,
			String parameterDataType) {
		super();
		this.parameterId = parameterId;
		this.parameterName = parameterName;
		this.parameterValue = parameterValue;
		this.parameterDataType = parameterDataType;
	}
	public int getParameterId() {
		return parameterId;
	}
	public void setParameterId(int parameterId) {
		this.parameterId = parameterId;
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
	public String getParameterDataType() {
		return parameterDataType;
	}
	public void setParameterDataType(String parameterDataType) {
		this.parameterDataType = parameterDataType;
	}
	@Override
	public String toString() {
		return "GetConfigurationParamsAdminNCTResultItem [parameterId=" + parameterId + ", parameterName="
				+ parameterName + ", parameterValue=" + parameterValue + ", parameterDataType=" + parameterDataType
				+ "]";
	}
	
	
}
