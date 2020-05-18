package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request for getting client needs subcategory products from catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientNeedsSubCatProductsRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer needCategoryId;

	private int clientId;

	/**
	 * default constructor for Get Client Needs SubCategory Products Request
	 */
	public GetClientNeedsSubCatProductsRequest() {
		super();
	}

	/**
	 * Get Client Needs SubCategory Products Request
	 * 
	 * @param needCategoryId
	 * 				Need category ID
	 * 
	 * @param clientId
	 * 				CLient ID
	 */
	public GetClientNeedsSubCatProductsRequest(Integer needCategoryId, int clientId) {
		super();
		this.needCategoryId = needCategoryId;
		this.clientId = clientId;
	}

	public Integer getNeedCategoryId() {
		return needCategoryId;
	}

	public void setNeedCategoryId(Integer needCategoryId) {
		this.needCategoryId = needCategoryId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "GetClientNeedsSubCatProductsRequest [needCategoryId=" + needCategoryId + ", clientId=" + clientId + "]";
	}

}
