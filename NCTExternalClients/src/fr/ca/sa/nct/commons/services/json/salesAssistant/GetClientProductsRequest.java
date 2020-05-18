package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request for general product from catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientProductsRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer productGroupId;

	private int clientId;

	/**
	 * default constructor for Get Client Products Request
	 */
	public GetClientProductsRequest() {
		super();
	}

	/**
	 * Get Client Products Request
	 * 
	 * @param productGroupId
	 * 				Product group ID
	 * 
	 * @param clientId
	 * 				Client ID
	 */
	public GetClientProductsRequest(Integer productGroupId, int clientId) {
		super();
		this.productGroupId = productGroupId;
		this.clientId = clientId;
	}

	public Integer getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(Integer productGroupId) {
		this.productGroupId = productGroupId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "GetClientProductsRequest [productGroupId=" + productGroupId + ", clientId=" + clientId + "]";
	}

}
