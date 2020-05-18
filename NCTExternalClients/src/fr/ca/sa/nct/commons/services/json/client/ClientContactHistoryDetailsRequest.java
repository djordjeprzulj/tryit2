package fr.ca.sa.nct.commons.services.json.client;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class ClientContactHistoryDetailsRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int clientId;
	private String startDate;
	private String endDate;
	private String dataSource;

	/**
	 * default constructor for Client Contact History Details Request
	 */
	public ClientContactHistoryDetailsRequest() {
		super();
	}

	/**
	 * Client Contact History Details Request
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param startDate
	 * 				Start date
	 * 
	 * @param endDate
	 * 				End date
	 */
	public ClientContactHistoryDetailsRequest(int clientId, String startDate, String endDate, String dataSource) {
		super();
		this.clientId = clientId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dataSource = dataSource;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
}
