package fr.ca.sa.externalClients.database.nct.procedures.clientSynthesis.getDataSource;

import java.io.Serializable;
import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Result Item for data source
 * 
 * @author Djordje Przulj
 *
 */
public class GetDataSourceResultItem implements Serializable {

	private static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer clientDataSourceId;
	private String clientDataSourceName;

	/**
	 * Get Data Source Result Item
	 * 
	 * @param clientDataSourceId
	 * 				Client data source ID
	 * 
	 * @param clientDataSourceName
	 * 				Client data source name
	 * 
	 */
	public GetDataSourceResultItem(Integer clientDataSourceId, String clientDataSourceName) {
		super();
		this.clientDataSourceId = clientDataSourceId;
		this.clientDataSourceName = clientDataSourceName;
	}

	public Integer getClientDataSourceId() {
		return clientDataSourceId;
	}

	public void setClientDataSourceId(Integer clientDataSourceId) {
		this.clientDataSourceId = clientDataSourceId;
	}

	public String getClientDataSourceName() {
		return clientDataSourceName;
	}

	public void setClientDataSourceName(String clientDataSourceName) {
		this.clientDataSourceName = clientDataSourceName;
	}

	@Override
	public String toString() {
		return "GetDataSourceResultItem [clientDataSourceId=" + clientDataSourceId + ", clientDataSourceName=" + clientDataSourceName + "]";
	}
}
