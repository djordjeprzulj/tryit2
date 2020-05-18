package fr.ca.sa.nct.commons.services.json.salesAssistant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.ca.sa.commons.constants.ProjectConstants;

/**
 * 
 * Request for getting client needs subcatategory products from catalog
 * 
 * @author Nemanja Ignjatov
 *
 */
public class GetClientNeedsSubCatProductsResponse implements Serializable {

	public static final long serialVersionUID = ProjectConstants.SERIALIZABLE_CLASS_UID;

	private List<TranslatableMergedNeedCategory> needCategories;

	/**
	 * default constructor for Get Client Needs SubCategory Products Response
	 */
	public GetClientNeedsSubCatProductsResponse() {
		super();
		this.needCategories = new ArrayList<TranslatableMergedNeedCategory>();
	}

	public List<TranslatableMergedNeedCategory> getNeedCategories() {
		return needCategories;
	}

	public void setNeedCategories(List<TranslatableMergedNeedCategory> needCategories) {
		this.needCategories = needCategories;
	}

	@Override
	public String toString() {
		return "GetClientNeedsSubCatProductsResponse [needCategories=" + needCategories + "]";
	}

}
