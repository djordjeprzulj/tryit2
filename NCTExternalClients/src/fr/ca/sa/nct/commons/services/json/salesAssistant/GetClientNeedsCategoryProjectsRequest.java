package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request for getting client needs category projects from catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientNeedsCategoryProjectsRequest implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private Integer needCategoryId;

	/**
	 * default constructor for Get Client Needs Category Projects Request
	 */
	public GetClientNeedsCategoryProjectsRequest() {
		super();
	}

	/**
	 * Get Client Needs Category Projects Request
	 * 
	 * @param needCategoryId
	 * 				Need category ID
	 */
	public GetClientNeedsCategoryProjectsRequest(Integer needCategoryId) {
		super();
		this.needCategoryId = needCategoryId;
	}

	public Integer getNeedCategoryId() {
		return needCategoryId;
	}

	public void setNeedCategoryId(Integer needCategoryId) {
		this.needCategoryId = needCategoryId;
	}

	@Override
	public String toString() {
		return "GetClientNeedsSubCatProductsRequest [needCategoryId=" + needCategoryId + "]";
	}

}
