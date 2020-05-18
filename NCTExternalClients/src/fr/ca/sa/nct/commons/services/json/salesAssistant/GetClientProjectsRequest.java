package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request for getting client projects from catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientProjectsRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private int clientId;

	private Integer needCategoryId;

	/**
	 * default constructor for Get Client Projects Request
	 */
	public GetClientProjectsRequest() {
		super();
	}

	/**
	 * Get Client Projects Request
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param needCategoryId
	 * 				Need category ID
	 */
	public GetClientProjectsRequest(int clientId, Integer needCategoryId) {
		super();
		this.clientId = clientId;
		this.needCategoryId = needCategoryId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public Integer getNeedCategoryId() {
		return needCategoryId;
	}

	public void setNeedCategoryId(Integer needCategoryId) {
		this.needCategoryId = needCategoryId;
	}

	@Override
	public String toString() {
		return "GetClientProjectsRequest [clientId=" + clientId + ", needCategoryId=" + needCategoryId + "]";
	}

}
